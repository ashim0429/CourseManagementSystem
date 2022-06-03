package school.management.system;


//importing all necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

//Extending JFrame as Parent Class
public class Module extends JFrame implements ActionListener {

    JPanel p1;
    JTable t1,t2,t3;
    JButton fy,sy,ty,bck;
    String data[][] = new String[50][8];
    String row[][] = new String[50][8];
    String ro[][] = new String[50][8];
    String column[] =  {"Semester","Modules","ModuleCode"};
    String name;
    int i = 0,j = 0;

    Module(String name){

        super("Module List");

        this.name = name;
        setLayout(null);
        setVisible(true);

        p1 = new JPanel();
        p1.setBackground(Color.DARK_GRAY);
        p1.setBounds(0,0,200,450);
        p1.setLayout(null);
        add(p1);


        fy = new JButton("First Year");
        fy.setBounds(80,50,100,40);
        fy.setFocusable(false);
        fy.addActionListener(this);
        p1.add(fy);

        sy = new JButton("Second Year");
        sy.setBounds(80,150,100,40);
        sy.setFocusable(false);
        sy.addActionListener(this);
//        sy.setEnabled(false);
        p1.add(sy);

        ty = new JButton("Third Year");
        ty.setBounds(80,250,100,40);
        ty.setFocusable(false);
        ty.addActionListener(this);
        p1.add(ty);


        bck = new JButton("Back");
        bck.setBounds(80,350,100,30);
        bck.setFocusable(false);
        bck.addActionListener(this);
        p1.add(bck);



        setLayout(null);
        setSize(800,450);





    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==fy){
            try {
                Connect c1  = new Connect();
                    String a = null;
                        try{
                            String s2 = "Select course from studentlogin where username='"+this.name+"' ";
                            ResultSet rs2 = c1.s.executeQuery(s2);
                            if(rs2.next()){
                               a = rs2.getString("course");
                            }
                            String s1 = "select * from coursetable where Course='BIT' and Level='Level 4'";
                            ResultSet res  = c1.s.executeQuery(s1);
                            while(res.next()){
                                data[i][j++]=res.getString("Semester");
                                data[i][j++]=res.getString("Modules");
                                data[i][j++]=res.getString("ModuleCode");
                                i++;
                                j=0;
                            }
                            t1 = new JTable(data,column);

                            JScrollPane sp = new JScrollPane(t1);
                            sp.setBounds(250,70,450,250);
                            add(sp);
                        }catch(Exception eo){
                            eo.printStackTrace();
                        }



            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            JPanel seemodule = new JPanel();
            seemodule.setBackground(Color.gray);
        }

        if(e.getSource()==sy){
            try {
                Connect c2  = new Connect();
                    String b = null;
                    try{
                        String s3 = "Select course from studentlogin where username='"+this.name+"' ";
                        ResultSet rs4 = c2.s.executeQuery(s3);
                        if(rs4.next()){
                            b = rs4.getString("course");
                        }
                        String s4 = "select * from coursetable where Course='BIT' and Level='Level 5'";
                        ResultSet res2  = c2.s.executeQuery(s4);
                        while(res2.next()){
                            row[i][j++]=res2.getString("Semester");
                            row[i][j++]=res2.getString("Modules");
                            row[i][j++]=res2.getString("ModuleCode");
                            i++;
                            j=0;
                        }
                        t2 = new JTable(row,column);

                        JScrollPane sp2 = new JScrollPane(t2);
                        sp2.setBounds(250,70,450,250);
                        add(sp2);

                    }catch(Exception eo){
                        eo.printStackTrace();
                    }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==ty){
            try {
                Connect c4  = new Connect();
                    String c = null;
                    try{
                        String s5 = "Select course from studentlogin where username='"+this.name+"' ";
                        ResultSet rs6 = c4.s.executeQuery(s5);
                        if(rs6.next()){
                            c = rs6.getString("course");
                        }
                        String s6 = "select * from coursetable where Course='BIT' and Level='Level 6'";
                        ResultSet res  = c4.s.executeQuery(s6);
                        while(res.next()){
                            ro[i][j++]=res.getString("Semester");
                            ro[i][j++]=res.getString("Modules");
                            ro[i][j++]=res.getString("ModuleCode");
                            i++;
                            j=0;
                        }
                        t3 = new JTable(ro,column);



                    }catch(Exception eo){
                        eo.printStackTrace();
                    }
                JScrollPane sp3 = new JScrollPane(t3);
                sp3.setBounds(250,70,450,250);
                add(sp3);

            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==bck){
            this.dispose();
            new StudentPanel("").setVisible(true);
        }


    }

    public static void main(String[] args) {
        new Module("");
    }

}
