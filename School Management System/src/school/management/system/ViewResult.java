package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class ViewResult extends JFrame implements ActionListener {

    //declaring varibales for GUI representation
    String data[][] = new String[15][8];
    String column[] = {"Semester", "Module", "ModuleID", "Marks Obtained"};
    JLabel result;
    String name;
    JTable table;
    int i = 0, j = 0;
    JButton bck;

    ViewResult(String name) {
        super("Student Individual Result");
        setLayout(null);
        setLocationRelativeTo(null);
        this.name = name;

        result = new JLabel("Your Results");
        result.setBounds(120, 50, 150, 30);
        result.setFont(new Font("serif", Font.ITALIC, 20));
        add(result);

        String id = null;
        String que = "Select ID from studentlogin where name='" + this.name + "'";

        try {
            Connect c1 = new Connect();
            ResultSet rs = c1.s.executeQuery(que);
            if (rs.next()) {
                id = rs.getString("ID");
            }
            String str = "Select * from result where ID= '" + id + "'";
            ResultSet res = c1.s.executeQuery(str);
            while (res.next()) {
                data[i][j++] = res.getString("Semester");
                data[i][j++] = res.getString("Modules");
                data[i][j++] = res.getString("ModuleCode");
                data[i][j++] = res.getString("Marks");
                i++;
                j = 0;
            }
            table = new JTable(data, column);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(70, 100, 630, 150);
        add(sp);


        bck = new JButton("Back");
        bck.setFocusable(false);
        bck.setBounds(350, 300, 100, 40);
        bck.setFont(new Font("serif", Font.BOLD, 15));
        bck.setBackground(Color.BLACK);
        bck.setForeground(Color.WHITE);
        bck.addActionListener(this);
        add(bck);


        setVisible(true);
        setSize(800, 450);
        setLocationRelativeTo(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bck) {
            this.dispose();
        }
    }
}

