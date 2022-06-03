package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;



//Extending JFrame as Parent Class
    public class Login extends JFrame implements ActionListener {

        private JLabel uname,pas,urol;
        private JTextField nam;
        private JPasswordField pass;
        private JComboBox cb;
        private JButton login,cancel;


        String role[] ={"Please Choose a Role", "Admin", "Faculty", "Student"};

        Login(){

            super("Login");

            setBackground(Color.white);
            setLayout(null);

            uname = new JLabel("Username");
            uname.setBounds(40,20,100,30);
            add(uname);

            pas = new JLabel("Password");
            pas.setBounds(40,70,100,30);
            add(pas);

            urol = new JLabel("User Role");
            urol.setBounds(40,120,100,30);
            add(urol);

            nam=new JTextField();
            nam.setBounds(150,20,150,30);
            add(nam);

            pass=new JPasswordField();
            pass.setBounds(150,70,150,30);
            add(pass);


            cb = new JComboBox(role);
            cb.setBounds(150,120,150,30);
            add(cb);


            ImageIcon i1 = new ImageIcon("C:\\Users\\Admin\\IdeaProjects\\School Management System\\src\\school\\management\\system\\Images\\user.png");
            Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
            ImageIcon i3 =  new ImageIcon(i2);
            JLabel l3 = new JLabel(i3);
            l3.setBounds(350,20,150,150);
            add(l3);


            login = new JButton("Login");
            login.setBounds(40,200,120,30);
            login.setFont(new Font("serif",Font.BOLD,15));
            login.addActionListener(this);
            login.setBackground(Color.BLACK);
            login.setForeground(Color.WHITE);
            add(login);



            cancel = new JButton("Cancel");
            cancel.setBounds(320,200,120,30);
            cancel.setFont(new Font("serif",Font.BOLD,15));
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            add(cancel);


            getContentPane().setBackground(Color.WHITE);

            setVisible(true);
            setSize(600,300);
            setLocation(500,300);

        }

        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == login) {
                try {
                    Connect c1 = new Connect();
                    String u = nam.getText();
                    String v = pass.getText();


                    String q = "select * from admin where Uname='" + u + "' and pass='" + v + "'and Role = '" + cb.getSelectedItem() + "'";
                    String s = "select * from teacherlogin where username='"+u+"' and pass= '"+v+"' and Role='"+cb.getSelectedItem()+"'";

                    String t = "select * from studentlogin where username='"+u+"' and pass= '"+v+"' and Role='"+cb.getSelectedItem()+"'";


                    ResultSet rs = c1.s.executeQuery(q);
                    if (rs.next()) {

                        if (rs.getString("Role").equals("Admin")) {
                            this.dispose();
                            new AdminPanel().setVisible(true);

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Invalid login");
                            setVisible(false);
                        }
                    }

                    ResultSet res = c1.s.executeQuery(s);
                    if (res.next()) {

                        if (res.getString("Role").equals("Faculty")) {
                            this.dispose();
                            new TeacherPanel(res.getString("name")).setVisible(true);

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Invalid login");
                            setVisible(false);
                        }
                    }
                    ResultSet r = c1.s.executeQuery(t);
                    if (r.next()) {

                        if (r.getString("Role").equals("Student")) {
                            this.dispose();
                            new StudentPanel(r.getString("name")).setVisible(true);

                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Invalid login");
                            setVisible(false);
                        }
                    }
//
//
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (ae.getSource()==cancel){
                this.dispose();
            }
        }
        public static void main(String[] arg){
            Login l = new Login();
        }
    }

