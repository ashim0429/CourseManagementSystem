package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


//Extending JFrame as Parent Class
public class EditCourse extends JFrame implements ActionListener {


    //declaring varibales for GUI representation
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    private JTextField t1,t2,t3,t4,t5,t6,t7;
    public JButton b1,b2,b3;

    EditCourse(){

        super("Edit Course and Module");
        setLayout(null);

        l1 = new JLabel("Enter name of module to update details");
        l1.setBounds(50,100,500,30);
        l1.setFont(new Font("serif", Font.ITALIC,20));
        add(l1);

        t1 = new JTextField();
        t1.setBounds(500,100,200,30);
        add(t1);

        b1 = new JButton("Enter");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(720,100,100,30);
        add(b1);
        b1.addActionListener( this);


        l2 = new JLabel("Update Course and Modules:");
        l2.setBounds(50,10,500,50);
        l2.setFont(new Font("serif",Font.ITALIC,40));
        l2.setForeground(Color.black);
        add(l2);

        l3 = new JLabel("Course Name");
        l3.setBounds(50,170,150,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        add(l3);

        t2=new JTextField();
        t2.setBounds(200,170,150,30);
        add(t2);

        l4= new JLabel("Module Name");
        l4.setBounds(400,170,200,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        add(l4);

        t3=new JTextField();
        t3.setBounds(600,170,150,30);
        add(t3);

        l5= new JLabel("Module ID");
        l5.setBounds(50,250,150,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        add(l5);

        t4=new JTextField();
        t4.setBounds(200,250,150,30);
        add(t4);

        l6= new JLabel("Year");
        l6.setBounds(400,250,150,30);
        l6.setFont(new Font("serif",Font.BOLD,20));
        add(l6);

        t5=new JTextField();
        t5.setBounds(600,250,150,30);
        add(t5);

        l7= new JLabel("Semester");
        l7.setBounds(50,330,100,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        add(l7);

        t6=new JTextField();
        t6.setBounds(200,330,150,30);
        add(t6);

        l8= new JLabel("Teacher name");
        l8.setBounds(400,320,150,30);
        l8.setFont(new Font("serif",Font.BOLD,20));
        add(l8);

        t7=new JTextField();
        t7.setBounds(600,330,150,30);
        add(t7);

        b2=new JButton("Submit");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(300,450,120,30);
        add(b2);
        b2.addActionListener( this);

        b3 = new JButton("Cancel");
        b3.setBounds(570,450,120,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        add(b3);

        setSize(850,600);
        setLocationRelativeTo(null);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b2){
            try{
                Connect c = new Connect();
                String str = "Update coursetable set Course='"+t2.getText()+"',Level='"+t3.getText()+"',Semester='"+t4.getText()+"', Modules='"+t5.getText()+"',ModuleCode='"+t6.getText()+"',Teachername='"+t7.getText()+"' where Modules= '"+t1.getText()+"'";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Course and Modules successfully updated");
                setVisible(false);
                new AddCourse();
            }catch(Exception ex){
                System.out.println("The error is:"+ex);
            }
        }
        if(e.getSource()==b3){
            setVisible(false);
            new AdminPanel().setVisible(true);
        }
        if(e.getSource() == b1){
            try{
                Connect c = new Connect();
                String str = "select * from coursetable where Modules = '"+t1.getText()+"'";
                ResultSet rs = c.s.executeQuery(str);
                while(rs.next()){
                    t2.setText(rs.getString("Course"));
                    t3.setText(rs.getString("Level"));
                    t4.setText(rs.getString("Semester"));
                    t5.setText(rs.getString("Modules"));
                    t6.setText(rs.getString("ModuleCode"));
                    t7.setText(rs.getString("Teachername"));

                }

            } catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
