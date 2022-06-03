package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

//Extending JFrame as Parent Class
public class ViewModule extends JFrame implements ActionListener {


    //declaring varibales for GUI representation
    JTable t1;
    String data[][] = new String[15][8];
    String column[] = {"Semester", "My Subjects", "ModuleID"};
    int i = 0, j= 0;
    String name;
    JButton bck;

    ViewModule(String name){

        super("Module Table");

        this.name = name;
                try{
                    Connect c2 = new Connect();
                    String s2 =  "select * from coursetable where Teachername='"+this.name+"' ";
                    ResultSet rs = c2.s.executeQuery(s2);
                    while(rs.next()){
                        data[i][j++]=rs.getString("Semester");
                        data[i][j++]=rs.getString("Modules");
                        data[i][j++]=rs.getString("ModuleCode");
                        i++;
                        j=0;
                    }
                    t1 = new JTable(data,column);
                }catch (Exception ex){
                    ex.printStackTrace();

                }JScrollPane sp = new JScrollPane(t1);
                 sp.setBounds(20,20,350,150);
                 add(sp);

        bck = new JButton("Back");
        bck.setFocusable(false);
        bck.setBounds(150,200,100,40);
        bck.setFont(new Font("serif",Font.BOLD,15));
        bck.setBackground(Color.BLACK);
        bck.setForeground(Color.WHITE);
        bck.addActionListener(this::actionPerformed);
        add(bck);

        setLocationRelativeTo(null);
        setLayout(null);
        setSize(450,350);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==bck){
            this.dispose();
            setVisible(true);
        }
    }
}
