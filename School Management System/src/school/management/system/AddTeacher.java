package school.management.system;

//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//Extending JFrame as Parent Class
public class AddTeacher extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    private JLabel name,email,usern,id,pas,crse,urol;
    private JTextField nam,eml,uname,Id;
    private JPasswordField pass;
    private JComboBox cb,cbx;
    private JButton submit,cncl;

    private String role[] = {"Faculty"};


    public AddTeacher() {

        super("Add Teacher");
        setBackground(Color.white);
        setLayout(null);

        name = new JLabel("Name");
        name.setBounds(40, 20, 100, 30);
        add(name);
        nam = new JTextField();
        nam.setBounds(150, 20, 150, 30);
        add(nam);

        email = new JLabel("Email");
        email.setBounds(430, 20, 100, 30);
        add(email);
        eml = new JTextField();
        eml.setBounds(520, 20, 150, 30);
        add(eml);

        usern = new JLabel("Username");
        usern.setBounds(40, 70, 100, 30);
        add(usern);
        uname = new JTextField();
        uname.setBounds(150, 70, 150, 30);
        add(uname);

        id = new JLabel("ID");
        id.setBounds(430, 120, 100, 30);
        add(id);
        Id = new JTextField();
        Id.setBounds(520, 120, 150, 30);
        add(Id);

        pas = new JLabel("Password");
        pas.setBounds(430, 70, 100, 30);
        add(pas);
        pass = new JPasswordField();
        pass.setBounds(520, 70, 150, 30);
        add(pass);



        urol = new JLabel("User Role");
        urol.setBounds(40,170,150,30);
        add(urol);
        cbx = new JComboBox(role);
        cbx.setBounds(150,170,150,30);
        add(cbx);

        crse = new JLabel("Course");
        crse.setBounds(40, 120, 150, 30);
        add(crse);
        String aray[] = null;
        try {
            Connect c = new Connect();
            String a = "Select Course from courseTable";
            ResultSet rs = c.s.executeQuery(a);
            ArrayList<String> list = new ArrayList<>();
            int x = 0;
            while(rs.next()){

                if (!list.contains(rs.getString("Course"))){
                    list.add(rs.getString("Course"));

                }

            }
            aray = (String[]) list.toArray(new String[list.size()] );
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cb = new JComboBox(aray);
        cb.setBounds(150, 120, 150, 30);
        add(cb);


        submit = new JButton("Submit");
        submit.setBounds(350, 250, 120, 30);
        submit.setFont(new Font("serif", Font.BOLD, 15));
        submit.addActionListener(this);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);

        cncl = new JButton("Cancel");
        cncl.setBounds(500, 250, 120, 30);
        cncl.setFont(new Font("serif", Font.BOLD, 15));
        cncl.addActionListener(this);
        cncl.setBackground(Color.BLACK);
        cncl.setForeground(Color.WHITE);
        add(cncl);


        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(800, 450);
        setLocation(400, 200);
    }

        @Override
        public void actionPerformed (ActionEvent e){
            String namee = nam.getText();
            String emaill = eml.getText();
            String unamee = uname.getText();
            String passs = pass.getText();
            String ID = Id.getText();
            String course = (String) cb.getSelectedItem();
            String role = (String) cbx.getSelectedItem();
            if (e.getSource() == submit) {
                try {
                    Connect c1 = new Connect();
                    String a = "Insert into teacherlogin(name,email,username,pass,role,ID,course)  values('" + namee + "','" + emaill + "','" + unamee + "','" + passs + "','" + role + "','" + ID + "','" + course + "')";
                    c1.s.executeUpdate(a);


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                JOptionPane.showMessageDialog(null, "User Created Successfully");
                setVisible(false);
                new AdminPanel().setVisible(true);


            }
            if (e.getSource()==cncl)
            {
                this.dispose();
                new AdminPanel().setVisible(true);
            }

        }

    }


