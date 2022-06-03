package school.management.system;
//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;



//Extending JFrame as Parent Class
public class CourseDetail extends JFrame implements ActionListener {


    //declaring varibales for GUI representation
    private JLabel crname,adcrse,upcrse;
    public JTable t1;
    public JButton del,adcrsemod,upcrsemod,cncl;
    public JTextField t2;
    public String column[] = {"Course","Level","Semester","Modules","ModuleCode", "TeacherName"};
    public String data[][] = new String[20][13];
    private int i=0, j=0;

    CourseDetail(){

        super("Module and Course Details");
        setLayout(null);

        crname = new JLabel("Enter name of module to delete : ");
        crname.setBounds(50,360,400,30);
        crname.setFont(new Font("serif",Font.BOLD,20));
        add(crname);

        t2 = new JTextField();
        t2.setBounds(400,360,200,30);
        add(t2);

        del = new JButton("Delete");
        del.setBackground(Color.BLACK);
        del.setForeground(Color.WHITE);
        del.setBounds(620, 360, 100 ,30);
        add(del);

        adcrse = new JLabel("Add Course");
        adcrse.setBounds(50,450,400,30);
        adcrse.setFont(new Font("serif",Font.BOLD,20));
        add(adcrse);

        adcrsemod = new JButton("Add Course and Module");
        adcrsemod.setBackground(Color.BLACK);
        adcrsemod.setForeground(Color.WHITE);
        adcrsemod.setBounds(300, 450, 250 ,30);
        add(adcrsemod);

        upcrse = new JLabel("Update Course and Modules");
        upcrse.setBounds(50,490,400,30);
        upcrse.setFont(new Font("serif",Font.BOLD,20));
        add(upcrse);

        upcrsemod = new JButton("Update Module and Course");
        upcrsemod.setBackground(Color.BLACK);
        upcrsemod.setForeground(Color.WHITE);
        upcrsemod.setBounds(300, 490, 250 ,30);
        add(upcrsemod);

        cncl = new JButton("Cancel");
        cncl.setBackground(Color.BLACK);
        cncl.setForeground(Color.WHITE);
        cncl.setBounds(300, 550, 250 ,30);
        add(cncl);


        del.addActionListener(this);
        adcrsemod.addActionListener(this);
        upcrsemod.addActionListener(this);
        cncl.addActionListener(this);


        try{
            Connect c1  = new Connect();
            String s1 = "select * from coursetable";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                data[i][j++]=rs.getString("Course");
                data[i][j++]=rs.getString("Level");
                data[i][j++]=rs.getString("Semester");
                data[i][j++]=rs.getString("Modules");
                data[i][j++]=rs.getString("ModuleCode");
                data[i][j++]=rs.getString("TeacherName");
                i++;
                j=0;
            }
            t1 = new JTable(data,column);

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,750,330);
        add(sp);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,650);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Connect c1 = null;
        try {
            c1 = new Connect();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (e.getSource() == del) {
            try
            {
                String a = t2.getText();
                String q = "delete from coursetable where Modules = '" + a + "'";
                c1.s.executeUpdate(q);
                this.dispose();
                new CourseDetail().setVisible(true);
            }
            catch (Exception ex) {
                ex.printStackTrace();

            }

        }
        else if (e.getSource() == adcrsemod)
        {
            this.dispose();
            new AddCourse().setVisible(true);
        }
        else if (e.getSource() == upcrsemod)
        {
            this.dispose();
            new EditCourse().setVisible(true);
        }
        else if(e.getSource()==cncl){
            this.dispose();
            new AdminPanel().setVisible(true);
        }
    }
}
