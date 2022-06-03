package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


//Extending JFrame as Parent Class
public class Enroll extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    private JLabel acrse,ecrse;
    private JTable ctable,crstable;
    public JButton erolnow;
    public String column[] = {"Level","Semester","Modules","ModuleCode"};
    public String data[][] = new String[50][6];
    public String row[][] = new String[50][5];
    private int i=0, j=0, x=0, y=0;

    Enroll(){

        super("Course Enrollment");
        setLocationRelativeTo(null);
        setLayout(null);


        acrse = new JLabel("Available Course");
        acrse.setBounds(300,35,250,40);
        acrse.setFont(new Font("serif", Font.ITALIC,22));
        add(acrse);

        ecrse = new JLabel("Enrolled Course");
        ecrse.setBounds(300,240,250,40);
        ecrse.setFont(new Font("serif", Font.ITALIC,22));
        add(ecrse);

        erolnow = new JButton("Enroll now");
        erolnow.setBackground(Color.BLACK);
        erolnow.setForeground(Color.WHITE);
        erolnow.setBounds(540,240,150,30);
        erolnow.setFocusable(false);
        add(erolnow);
        erolnow.addActionListener( this);


//Upper Table
        try{
            Connect c1  = new Connect();
            String s1 = "select * from coursetable";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                data[i][j++]=rs.getString("Level");
                data[i][j++]=rs.getString("Semester");
                data[i][j++]=rs.getString("Modules");
                data[i][j++]=rs.getString("ModuleCode");
                i++;
                j=0;
            }
            ctable = new JTable(data,column);

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(ctable);
        sp.setBounds(70,70,600,150);
        add(sp);





        setSize(750,550);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==erolnow){
            try{
                Connect c2  = new Connect();
                String s2 = "select * from coursetable";
                ResultSet res  = c2.s.executeQuery(s2);
                while(res.next()){
                    row[x][y++]=res.getString("Level");
                    row[x][y++]=res.getString("Semester");
                    row[x][y++]=res.getString("Modules");
                    row[x][y++]=res.getString("ModuleCode");
                    x++;
                    y=0;
                }
                crstable = new JTable(row,column);

            }catch(SQLException ae){
                ae.printStackTrace();
            }

            JScrollPane sp1 = new JScrollPane(crstable);
            sp1.setBounds(70,280,600,150);
            add(sp1);
        }

    }


}
