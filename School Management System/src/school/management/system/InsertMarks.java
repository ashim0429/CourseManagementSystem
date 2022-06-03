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
public class InsertMarks extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    private JLabel l1,l2,l3,l4,lab,l5, l6;
    private JTextField t4,t5,t6;
    private JButton b1,b2;
    private JComboBox combox1, combox2, combo;
    private String sem, mod, modid;
    InsertMarks(){
        super("Add Marks");
        setBackground(Color.white);

        lab = new JLabel("Fill the data below to add marks");
        lab.setBounds(50,50,400,30);
        lab.setFont(new Font("serif",Font.BOLD,20));
        add(lab);

        l1 = new JLabel("Semester");
        l1.setBounds(30,120,100,30);
        add(l1);
        String aray[] = null;
        try {
            Connect c = new Connect();
            String a = "Select Semester from courseTable";
            ResultSet rs = c.s.executeQuery(a);
            ArrayList <String> list = new ArrayList<>();
            int x = 0;
            while(rs.next()){

                if (!list.contains(rs.getString("Semester"))){
                    list.add(rs.getString("Semester"));

                }

            }
            aray = (String[]) list.toArray(new String[list.size()] );

        } catch (SQLException e) {
            e.printStackTrace();
        }
        combo = new JComboBox(aray);
        combo.setBounds(100,120,150,30);
        add(combo);

        l2 = new JLabel("Module");
        l2.setBounds(270,120,100,30);
        add(l2);
        String array1[] = null;
        try {
            Connect c1 = new Connect();
            String w = "Select Modules from coursetable";
            ResultSet as = c1.s.executeQuery(w);
            ArrayList<String> list = new ArrayList<>();
            int n = 0;
            while(as.next()){

                if (!list.contains(as.getString("Modules"))){
                    list.add(as.getString("Modules"));

                }

            }
            array1 = (String[]) list.toArray(new String[list.size()] );
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        combox1 = new JComboBox(array1);
        combox1.setBounds(370, 120, 100, 30);
        add(combox1);

        l3 = new JLabel("Module ID");
        l3.setBounds(30,200,100,30);
        add(l3);
        String array2[] = null;
        try {
            Connect c2 = new Connect();
            String t = "Select ModuleCode from coursetable";
            ResultSet as = c2.s.executeQuery(t);
            ArrayList<String> list = new ArrayList<>();
            int u = 0;
            while(as.next()){

                if (!list.contains(as.getString("ModuleCode"))){
                    list.add(as.getString("ModuleCode"));

                }

            }
            array2 = (String[]) list.toArray(new String[list.size()] );
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        combox2 = new JComboBox(array2);
        combox2.setBounds(100, 200, 150, 30);
        add(combox2);

        l4 = new JLabel("Student Name");
        l4.setBounds(270,200,100,30);
        add(l4);
        t4=new JTextField();
        t4.setBounds(370,200,150,30);
        add(t4);

        l5 = new JLabel("Marks \tObtained");
        l5.setBounds(30,280,100,30);
        add(l5);
        t5=new JTextField();
        t5.setBounds(100,280,150,30);
        add(t5);

        l6 = new JLabel("Student ID");
        l6.setBounds(270,280,100,30);
        add(l6);
        t6=new JTextField();
        t6.setBounds(370,280,150,30);
        add(t6);

        b1 = new JButton("Enter marks");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setFocusable(false);
        b1.setBounds(170,350,150,30);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setFocusable(false);
        b2.setBounds(400,350,150,30);
        b2.addActionListener(this);
        add(b2);


        setLayout(null);
        setSize(600,450);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource()==b1){
                try {
                    sem = (String) combo.getSelectedItem();
                    mod = (String) combox1.getSelectedItem();
                    modid = (String) combox2.getSelectedItem();
                    Connect c = new Connect();
                    String s = "Insert into result(Semester,Modules, ModuleCode, Studentname, Marks, ID) values('"+sem+"', '"+mod+"', '"+modid+"', '"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"')";
                    c.s.executeUpdate(s);

                } catch (SQLException ex) {

                }
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                setVisible(false);
                new EnterMarks().setVisible(true);
            }
            if (e.getSource()==b2){
                this.dispose();
                new EnterMarks();
            }

    }
}
