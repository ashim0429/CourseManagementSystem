package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


//Extending JFrame as Parent Class
public class StudentPanel extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    JLabel lab,nam;
    JButton vwmod,vwres,eroll,ext;
    JPanel p1;
    String name;


    StudentPanel(String name)

    {
        super("Student Panel");
        setLayout(null);
        setLocationRelativeTo(null);
        this.name = name;


        p1 = new JPanel();
        p1.setBackground(Color.DARK_GRAY);
        p1.setBounds(0,0,300,450);
        p1.setLayout(null);
        add(p1);


        lab = new JLabel("Welcome to Student Panel");
        lab.setBounds(380,40,500,50);
        lab.setFont(new Font("serif",Font.ITALIC,25));
        lab.setForeground(Color.black);
        add(lab);


        vwmod = new JButton("View Modules");
        vwmod.setBounds(80,50,200,40);
        vwmod.setFocusable(false);
        vwmod.addActionListener(this::actionPerformed);
        p1.add(vwmod);

        vwres = new JButton("View Result");
        vwres.setBounds(80,150,200,40);
        vwres.setFocusable(false);
        p1.add(vwres);
        vwres.addActionListener(this);

        eroll = new JButton("Enroll");
        eroll.setBounds(80,250,200,40);
        eroll.setFocusable(false);
        p1.add(eroll);
        eroll.addActionListener(this);

        ext = new JButton("Exit");
        ext.setBounds(80,350,200,40);
        ext.setFocusable(false);
        p1.add(ext);
        ext.addActionListener(this);

        String str = "Select * from studentlogin where name= '"+this.name+"'";
        try {
            Connect connect = new Connect();

            ResultSet rs = connect.s.executeQuery(str);
            if (rs.next()){
                nam = new JLabel(rs.getString("name"));
                nam.setBounds(420,100,250,50);
                nam.setFont(new Font("serif",Font.BOLD,25));
                nam.setForeground(Color.black);
                add(nam);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }




        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(800,450);
        setLocationRelativeTo(null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==vwmod){
            new Module(this.name).setVisible(true);
        }

        if(e.getSource()==vwres){
            new ViewResult(name).setVisible(true);

        }
        if(e.getSource()==eroll){;
            new Enroll().setVisible(true);
        }
        if (e.getSource()== ext){
            this.dispose();
            new Login().setVisible(true);
        }

    }

}
