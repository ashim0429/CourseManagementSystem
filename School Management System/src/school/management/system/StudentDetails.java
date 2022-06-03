package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class StudentDetails extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    private JLabel delstu,adnewstu,upstude;
    public JTable t1;
    public JButton del,adstu,upstu,cncl;
    public JTextField id;
    public String column[] = {"Name","Email","Username","Password","ID", "Course"};
    public String data[][] = new String[20][13];
    private int i=0, j=0;

    public StudentDetails(){
        super("Student Details");
        setSize(1260,650);
        setLocation(200,200);
        setLayout(null);

        delstu = new JLabel("Enter id to delete Student : ");
        delstu.setBounds(50,360,400,30);
        delstu.setFont(new Font("serif",Font.BOLD,20));
        add(delstu);

        id = new JTextField();
        id.setBounds(400,360,200,30);
        add(id);

        del = new JButton("Delete");
        del.setBackground(Color.BLACK);
        del.setForeground(Color.WHITE);
        del.setBounds(620, 360, 100 ,30);
        add(del);

        adnewstu = new JLabel("Add New Student");
        adnewstu.setBounds(50,450,400,30);
        adnewstu.setFont(new Font("serif",Font.BOLD,20));
        add(adnewstu);

        adstu = new JButton("Add Student");
        adstu.setBackground(Color.BLACK);
        adstu.setForeground(Color.WHITE);
        adstu.setBounds(300, 450, 150 ,30);
        add(adstu);

        upstude = new JLabel("Update Student Details");
        upstude.setBounds(50,490,400,30);
        upstude.setFont(new Font("serif",Font.BOLD,20));
        add(upstude);

        upstu = new JButton("Update Student");
        upstu.setBackground(Color.BLACK);
        upstu.setForeground(Color.WHITE);
        upstu.setBounds(300, 490, 150 ,30);
        upstu.setFocusable(false);
        add(upstu);

        cncl = new JButton("Cancel");
        cncl.setBackground(Color.BLACK);
        cncl.setForeground(Color.WHITE);
        cncl.setFocusable(false);
        cncl.setBounds(500, 490, 150 ,30);
        add(cncl);

        del.addActionListener(this);
        adstu.addActionListener(this);
        upstu.addActionListener(this);
        cncl.addActionListener(this);


        try{
            Connect c1  = new Connect();
            String s1 = "select * from studentlogin";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                data[i][j++]=rs.getString("name");
                data[i][j++]=rs.getString("email");
                data[i][j++]=rs.getString("username");
                data[i][j++]=rs.getString("pass");
                data[i][j++]=rs.getString("ID");
                data[i][j++]=rs.getString("course");
                i++;
                j=0;
            }
            t1 = new JTable(data,column);

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);

        getContentPane().setBackground(Color.WHITE);

        del.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){

        Connect c1 = null;
        try {
            c1 = new Connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(ae.getSource() == del){
            try{
                String a = id.getText();
                String q = "delete from studentlogin where ID = '"+a+"'";
                c1.s.executeUpdate(q);


            }catch(Exception e){
                e.printStackTrace();
            }
            this.dispose();
            new StudentDetails().setVisible(true);
        }
        else if(ae.getSource() == adstu)
        {
            this.dispose();
            new AddStudent().setVisible(true);
        }
        else if(ae.getSource() == upstu){
            this.dispose();
            new UpStuDtl().setVisible(true);

        }
        else if (ae.getSource()==cncl){
            this.dispose();
            new AdminPanel().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new StudentDetails().setVisible(true);
    }
}
