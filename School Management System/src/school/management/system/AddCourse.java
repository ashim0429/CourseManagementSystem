package school.management.system;
//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class AddCourse extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    private JLabel coursename, modules, id, title, level, sem, teach;
    private JTextField crsename;
    private JComboBox yearB;
    private JComboBox yearA;
    private JTextField cb;
    protected JTextField modname;
    protected JTextField modid;
    protected JButton submit, cancel,edit;
    public String crname, monam, moid, yra, yrb, cbx;
    public String year[] = {"Please Choose a year","Level 3","Level 4","Level 5", "Level 6"};
    public String semester[] = {"Please Choose a semester", "1", "2","3","4","5","6","7","8"};

    AddCourse(){
        super("Add Course");

        setLayout(null);

        title = new JLabel("Add Course and Module");
        title.setFont(new Font("serif",Font.BOLD,25));
        title.setBounds(250,40,300,40);
        add(title);

        coursename = new JLabel("Course Name");
        coursename.setBounds(40,120,200,40);
        add(coursename);

        crsename = new JTextField();
        crsename.setBounds(150,120,200,40);
        add(crsename);

        modules = new JLabel("Module Name");
        modules.setBounds(430,120,200,40);
        add(modules);


        modname = new JTextField();
        modname.setBounds(520,120,200,40);
        add(modname);

        id = new JLabel("Module ID");
        id.setBounds(40,220,200,40);
        add(id);

        modid = new JTextField();
        modid.setBounds(150,220,200,40);
        add(modid);

        level = new JLabel("Year");
        level.setBounds(430,220,200,40);
        add(level);

        yearB = new JComboBox(year);
        yearB.setBounds(520,220,200,40);
        add(yearB);

        sem = new JLabel("Semester");
        sem.setBounds(40,320,200,40);
        add(sem);

        yearA = new JComboBox(semester);
        yearA.setBounds(150,320,200,40);
        add(yearA);

        teach = new JLabel("Teacher Name");
        teach.setBounds(430,320,200,40);
        add(teach);


        cb = new JTextField();
        cb.setBounds(520,320,200,40);
        add(cb);


        submit = new JButton("Add");
        submit.setBounds(230,480,120,30);
        submit.setFont(new Font("serif",Font.BOLD,15));
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);

        edit = new JButton("Edit");
        edit.setBounds(400,480,120,30);
        edit.setFont(new Font("serif",Font.BOLD,15));
        edit.addActionListener(this);
        edit.setBackground(Color.BLACK);
        edit.setForeground(Color.WHITE);
        add(edit);


        cancel = new JButton("Cancel");
        cancel.setBounds(570,480,120,30);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);



        setSize(850,600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== submit){

            crname = crsename.getText();
            monam = modname.getText();
            moid =  modid.getText();
            yrb = (String) yearB.getSelectedItem();
            yra = (String) yearA.getSelectedItem();
            cbx = cb.getText();

            try {
                Connect c = new Connect();
                String str = "Insert into coursetable(Course, Level, Semester, Modules, ModuleCode, Teachername) values('" + crname + "', '" + yrb + "','" + yra + "','" +monam  + "','" + moid + "','" + cbx + "')";
                c.s.executeUpdate(str);
                this.dispose();
                new CourseDetail().setVisible(true);


            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Course and Module Added Successfully");
            setVisible(false);


        }
        if (e.getSource()==edit){
            this.dispose();
            new EditCourse().setVisible(true);
        }
        if (e.getSource()== cancel){
            this.dispose();
            new AdminPanel().setVisible(true);
        }

    }
}
