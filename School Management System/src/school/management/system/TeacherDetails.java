package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


//Extending JFrame as Parent Class
public class TeacherDetails extends JFrame implements ActionListener {

    private JLabel delfac,addnew,updel;
    public JTable t1;
    public JButton del,adfac,upfac,cncl;
    public JTextField id;
    public String column[] = {"Name","Email","Username","Password","ID", "Course"};
    public String data[][] = new String[20][13];
    private int i=0, j=0;

    TeacherDetails(){
        super("Teacher Details");
        setSize(1260,650);
        setLocation(200,200);
        setLayout(null);

        delfac = new JLabel("Enter id to delete a Teacher : ");
        delfac.setBounds(50,360,400,30);
        delfac.setFont(new Font("serif",Font.BOLD,20));
        add(delfac);

        id = new JTextField();
        id.setBounds(400,360,200,30);
        add(id);

        del = new JButton("Delete");
        del.setBackground(Color.BLACK);
        del.setForeground(Color.WHITE);
        del.setBounds(620, 360, 100 ,30);
        add(del);

        addnew = new JLabel("Add New Teacher");
        addnew.setBounds(50,450,400,30);
        addnew.setFont(new Font("serif",Font.BOLD,20));
        add(addnew);

        adfac = new JButton("Add Teacher");
        adfac.setBackground(Color.BLACK);
        adfac.setForeground(Color.WHITE);
        adfac.setBounds(300, 450, 150 ,30);
        add(adfac);

        updel = new JLabel("Update Teacher Details");
        updel.setBounds(50,490,400,30);
        updel.setFont(new Font("serif",Font.BOLD,20));
        add(updel);

        upfac = new JButton("Update Teacher");
        upfac.setBackground(Color.BLACK);
        upfac.setForeground(Color.WHITE);
        upfac.setBounds(300, 490, 150 ,30);
        add(upfac);

        cncl = new JButton("Cancel");
        cncl.setBackground(Color.BLACK);
        cncl.setForeground(Color.WHITE);
        cncl.setFocusable(false);
        cncl.setBounds(500, 490, 150 ,30);
        add(cncl);

        del.addActionListener(this);
        adfac.addActionListener(this);
        upfac.addActionListener(this);
        cncl.addActionListener(this);


        try{
            Connect c1  = new Connect();
            String s1 = "select * from teacherlogin";
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
    public void actionPerformed(ActionEvent ae) {

        Connect c1 = null;
        try {
            c1 = new Connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (ae.getSource() == del) {
            try {
                String a = id.getText();
                String q = "delete from teacherlogin where id = '" + a + "'";
                c1.s.executeUpdate(q);

            } catch (Exception e) {

            }
            this.dispose();
            new TeacherDetails().setVisible(true);

        }
        else if (ae.getSource() == adfac)
        {
            this.dispose();
            new AddTeacher().setVisible(true);

        } else if (ae.getSource() == upfac) {
            this.dispose();
            new UpFacDtl().setVisible(true);

        }
        else if(ae.getSource()==cncl){
            this.dispose();
            new AdminPanel().setVisible(true);
        }
    }


}
