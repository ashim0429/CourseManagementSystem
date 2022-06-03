package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


//Extending JFrame as Parent Class
public class TeacherPanel extends JFrame implements ActionListener {
    //declaring varibales for GUI representation
    JLabel lab,nme;
    JButton vm,etres,exit;
    JPanel p1;
    String name;
    TeacherPanel(String name){
        super("Teacher Panel");
        setLayout(null);
        setLocationRelativeTo(null);
        this.name = name;

        p1 = new JPanel();
        p1.setBackground(Color.DARK_GRAY);
        p1.setBounds(0,0,300,450);
        p1.setLayout(null);
        add(p1);


        lab = new JLabel("Welcome to Teacher Panel");
        lab.setBounds(380,40,500,50);
        lab.setFont(new Font("serif",Font.ITALIC,25));
        lab.setForeground(Color.black);
        add(lab);


        vm = new JButton("View Modules");
        vm.setBounds(80,50,200,40);
        vm.setFocusable(false);
        vm.addActionListener(this);
        p1.add(vm);

        etres = new JButton("Enter Result");
        etres.setBounds(80,150,200,40);
        etres.setFocusable(false);
        p1.add(etres);
        etres.addActionListener(this);


        exit = new JButton("Exit");
        exit.setBounds(80,350,200,40);
        exit.setFocusable(false);
        p1.add(exit);
        exit.addActionListener(this);

        String str = "Select * from teacherlogin where name= '"+this.name+"'";
        try {
            Connect connect = new Connect();

            ResultSet rs = connect.s.executeQuery(str);
            if (rs.next()){
                nme = new JLabel(rs.getString("name"));
                nme.setBounds(420,100,250,50);
                nme.setFont(new Font("serif",Font.BOLD,25));
                nme.setForeground(Color.black);
                add(nme);
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
        if (e.getSource()==vm){
            new ViewModule(name).setVisible(true);
        }

        if(e.getSource()==etres){
            new EnterMarks().setVisible(true);
        }

        if(e.getSource()==exit){
            this.dispose();
            new Login().setVisible(true);
        }

    }
}
