package school.management.system;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//Extending JFrame as Parent Class
public class AdminPanel extends JFrame implements ActionListener {

    AdminPanel()
    {
        super("School Management System");

        setSize(750,500);
        setLocationRelativeTo(null);

        ImageIcon ic =  new ImageIcon("src\\school\\management\\system\\Images\\img.jpg");
        Image i3 = ic.getImage().getScaledInstance(850, 950,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);

        add(l1);

        JMenuBar mb  = new JMenuBar();
        JMenu New = new JMenu("New");
        JMenuItem m1 = new JMenuItem("New Faculty");
        JMenuItem m2 = new JMenuItem("New Student Admission");
        New.setForeground(Color.BLACK);
        New.setFont(new Font("monospaces",Font.BOLD,27));


        m1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon("src\\school\\management\\system\\Images\\add.png");
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setBackground(Color.WHITE);

        m2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon2 = new ImageIcon("src\\school\\management\\system\\Images\\add-user.png");
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setBackground(Color.WHITE);


        m1.addActionListener(this);
        m2.addActionListener(this);



        JMenu user = new JMenu("Details");
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        user.setForeground(Color.BLACK);
        user.setFont(new Font("monospaces",Font.BOLD,27));

        u1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon4 = new ImageIcon("src\\school\\management\\system\\Images\\profile.png");
        Image image4 = icon4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setBackground(Color.WHITE);

        u2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon5 = new ImageIcon("src\\school\\management\\system\\Images\\resume.png");
        Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setBackground(Color.WHITE);

        u1.addActionListener(this);
        u2.addActionListener(this);



        JMenu res = new JMenu("Result");
        JMenuItem c2 = new JMenuItem("Generate Report");
        res.setForeground(Color.BLACK);
        res.setFont(new Font("monospaces",Font.BOLD,27));


        c2.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon32 = new ImageIcon("university/management/system/icons/icon17.png");
        Image image33 = icon32.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        c2.setIcon(new ImageIcon(image33));
        c2.setBackground(Color.WHITE);
        res.add(c2);
        c2.addActionListener(this);

        JMenu crse = new JMenu("View Course");
        JMenuItem r1 = new JMenuItem("View Module and Course");
        crse.setForeground(Color.BLACK);
        crse.setFont(new Font("monospaces",Font.BOLD,30));

        r1.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon7 = new ImageIcon("src\\school\\management\\system\\Images\\update.png");
        Image image7 = icon7.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image7));
        r1.setBackground(Color.WHITE);

        r1.addActionListener(this);


        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.RED);
        exit.setFont(new Font("monospaces",Font.BOLD,27));


        ex.setFont(new Font("monospaced",Font.BOLD,16));
        ImageIcon icon11 = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\School Management System\\src\\school\\management\\system\\Images\\sign-out.png");
        Image image11 = icon11.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);



        New.add(m1);
        New.add(m2);

        user.add(u1);
        user.add(u2);

        crse.add(r1);




        exit.add(ex);

        mb.add(New);
        mb.add(user);
        mb.add(res);
        mb.add(crse);
        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());

        setVisible(false);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("New Student Admission")){
            this.dispose();
            new AddStudent().setVisible(true);

        }else if(msg.equals("New Faculty")){
            this.dispose();
            new AddTeacher().setVisible(true);

        }else if(msg.equals("Student Details")){
            this.dispose();
            new StudentDetails().setVisible(true);

        }else if(msg.equals("Teacher Details")){
            this.dispose();
            new TeacherDetails().setVisible(true);

        }
        else if(msg.equals("Generate Report")){
            this.dispose();
            new SeeResult().setVisible(true);

        }
        else if(msg.equals("View Module and Course")){
            this.dispose();
            new CourseDetail().setVisible(true);

        }
        else if(msg.equals("Exit")){
            this.dispose();
            new Login();
        }

    }

    public static void main(String[] args) {
        new AdminPanel();
    }

    }

