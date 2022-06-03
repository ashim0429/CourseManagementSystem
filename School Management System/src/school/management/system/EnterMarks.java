package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



//Extending JFrame as Parent Class
public class EnterMarks extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    JLabel l1;
    JTable t1;
    JButton b1,b2;
   EnterMarks(){
       super("Marks details for the module");


       l1 = new JLabel("Marks Table");
       l1.setBounds(100,10,100,30);
       add(l1);


       String data[][] = new String[15][8];
       String column[] = {"Semester", "Modules", "ModuleID","Student Name","Marks","Student ID"};
       int i = 0, j= 0;

       try{
           Connect c1  = new Connect();
           String s1 = "select * from result";
           ResultSet rs  = c1.s.executeQuery(s1);
           while(rs.next()){
               data[i][j++]=rs.getString("Semester");
               data[i][j++]=rs.getString("Modules");
               data[i][j++]=rs.getString("ModuleCode");
               data[i][j++]=rs.getString("Studentname");
               data[i][j++]=rs.getString("ID");
               data[i][j++]= String.valueOf(rs.getDouble("Marks"));
               i++;
               j=0;
           }
           t1 = new JTable(data,column);

       }catch(Exception e){
           e.printStackTrace();
       }

       JScrollPane sp = new JScrollPane(t1);
       sp.setBounds(50,50,450,250);
       add(sp);

       b1 = new JButton("Enter Marks Now");
       b1.setBounds(120,310,250,30);
       b1.setFont(new Font("serif",Font.BOLD,15));
       b1.setFocusable(false);
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.addActionListener(this);
       add(b1);

       b2 = new JButton("Cancel");
       b2.setBounds(400,310,150,30);
       b2.setFont(new Font("serif",Font.BOLD,15));
       b2.setFocusable(false);
       b2.setBackground(Color.BLACK);
       b2.setForeground(Color.WHITE);
       b2.addActionListener(this);
       add(b2);


       setLayout(null);
       setSize(600,450);
       setLocationRelativeTo(null);
       setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e) {

       if (e.getSource()==b1){
           this.dispose();
           new InsertMarks();

       }

        if (e.getSource()==b2){
            this.dispose();
        }

    }
}
