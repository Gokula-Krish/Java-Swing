package bootathon1_JAVA;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class StudentPage extends JFrame{
    static JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    static JLabel tl1,tl2,tl3,tl4,tl5,tl6,tl7,tl8,tl9,tl10;
    static Font fo=new Font("Eras Bold ITC",Font.BOLD,25);
    static JPanel reportpanel = new JPanel();
    static JPanel editPanel=new JPanel();
    static JPanel viewPanel=new JPanel();
    static JLabel report,view,edit;
    static String mail,password;
    static JLabel l01,l02,l03,l04,l05,l06,l07,l08,l09,l010;
    static JLabel t0l1,t0l2,t0l3,t0l4,t0l5,t0l6,t0l7,t0l8,t0l9,t0l10;
    static String name1,roolno,mobo;
    public StudentPage(String mail,String pass){
        super("Student Dashboard");
        setLayout(null);
        this.mail=mail;
        this.password=pass;        
        setBounds(0,0,1900,1400);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lab1=new JLabel("Student DashBoard");
        lab1.setBounds(790,60,1000,90);
        lab1.setFont(new Font("Stencil",13,90));
        add(lab1);
        JLabel lab2=new JLabel("Sri Krishna Institutions");
        lab2.setBounds(10,10,470,120);
        lab2.setFont(new Font("Segoe UI Black",12,40)); 
        add(lab2);
        JLabel lab3=new JLabel("Transport Management System");
        lab3.setBounds(10,70, 470,150);
        lab3.setFont(new Font("Segoe UI Black",12,30)); 
        add(lab3);
        JButton back=new JButton("Back");
        back.setBounds(60,800,350,70);
        back.setFont(new Font("Segoe UI Black",12,40));
        back.setBackground(Color.green);        
        add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomePage();
            }
        });
        back.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) { }
            @Override
            public void mouseMoved(MouseEvent e) {
                back.setBackground(Color.red);
                back.setForeground(Color.white);
            }
        });
        view =new JLabel("View");
        view.setBounds(710,210,200,50);
        view.setForeground(Color.white);
        view.setFont(new Font("Segoe UI Black",12,30));
        add(view);
        edit =new JLabel("Edit");
        edit.setBounds(1150,210,200,50);
        edit.setForeground(Color.white);
        edit.setFont(new Font("Segoe UI Black",12,30));
        add(edit);
        System.out.println("HOME PAGE STUDENT");
        report=new JLabel("Report");
        report.setBounds(1600,210,200,50);
        report.setForeground(Color.white);
        report.setFont(new Font("Segoe UI Black",12,30));
        add(report);
        view.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}
            @Override
            public void mouseMoved(MouseEvent e) {
                view.setOpaque(true);
                view.setBackground(new Color(10, 56, 130));
            }
        });

        edit.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e){}
            @Override
            public void mouseMoved(MouseEvent e) {
                edit.setOpaque(true);
                edit.setBackground(new Color(10, 56, 130));
            }
        });

        report.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}
            @Override
            public void mouseMoved(MouseEvent e) {
                report.setOpaque(true);
                report.setBackground(new Color(10, 56, 130));               
            }
        });              
        report.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                editPanel.setVisible(false);
                viewPanel.setVisible(false);
                addReport(reportpanel);  
            }
        }); 
        add(reportpanel);
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              reportpanel.setVisible(false);
              viewPanel.setVisible(false);
              for(int i=0;i<10;i++){
                  addEdit(editPanel);  
              }
              
            }
        }); 
        add(editPanel);
        view.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                editPanel.setVisible(false);
                reportpanel.setVisible(false);
                addView(viewPanel);                  
            }
        });        
        add(viewPanel);   
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                back.setBackground(Color.green);
                back.setForeground(Color.black);  
                view.setBackground(new Color(140, 184, 255));  
                edit.setBackground(new Color(140, 184, 255));  
                report.setBackground(new Color(140, 184, 255));  
            }
        });                
        setLayout(new BorderLayout());
        add(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
              super.paintComponent(g);             
              g.setColor(Color.red);
              g.fillRect(0,0,490,2000);              
              g.setColor(getBackground());
              g.fillRect(820, 240,860,600);
              Image img1=new ImageIcon("D:\\pot7.jpg").getImage();
              g.drawImage(img1,0,0,490,1100,null);
              g.setColor(Color.white);
              g.fillRect(490,0,1700,1970);
              g.setColor(new Color(140, 184, 255));
              g.fillRect(600,200,1240,70);
              g.setColor(new Color(247, 207, 121));
              g.fillRect(600,270,1240,800);
              g.setColor(Color.lightGray);
              g.fillRect(650,0,1100,170);
              Image img2=new ImageIcon("D:\\student.png").getImage();
              g.drawImage(img2,690,50,100,90,null);
            }
        },BorderLayout.CENTER);        
        setVisible(true);
    } 
    
    public void addView(JPanel viewPanel){
        viewPanel.setBounds(600,270,1240,800);          
        viewPanel.setLayout(null);  
        JLabel ba=new JLabel("------------------------------------------------------------------------------------------------------------------");
        ba.setBounds(50,20,1300,50);
        ba.setFont(new Font("Times New Roman",13,30));
        viewPanel.add(ba);
        JLabel aa=new JLabel("VIEW FORM");
        aa.setBounds(530,50,200,50);
        aa.setFont(new Font("Arial Black",13,30));
        viewPanel.add(aa);
        JLabel bb=new JLabel("------------------------------------------------------------------------------------------------------------------");
        bb.setBounds(50,80,1300,50);
        bb.setFont(new Font("Times New Roman",13,30));
        viewPanel.add(bb);
        Font f1=new Font("Century",Font.BOLD,25);
        l2=new JLabel("Name:");l2.setFont(fo);l2.setBounds(175,150,150,35);
        l3=new JLabel("Roll No:");l3.setFont(fo);l3.setBounds(175,210,150,35);
        l4=new JLabel("College Mail:");l4.setFont(fo);l4.setBounds(175,270,200,35);
        l6=new JLabel("Mobile No:");l6.setFont(fo);l6.setBounds(175,330,150,35);
        l7=new JLabel("Destination:");l7.setFont(fo);l7.setBounds(175,390,350,35);
        l8=new JLabel("Selected Bus:");l8.setFont(fo);l8.setBounds(175,450,250,35);
        l9=new JLabel("Fees Allocated:");l9.setFont(fo);l9.setBounds(175,510,250,35);
        l10=new JLabel("Fees Paid:");l10.setFont(fo);l10.setBounds(175,570,250,35);    
        tl2=new JLabel();tl2.setFont(f1);tl2.setBounds(450,150,250,35);
        tl3=new JLabel();tl3.setFont(f1);tl3.setBounds(450,210,150,35);
        tl4=new JLabel();tl4.setFont(f1);tl4.setBounds(450,270,390,35);
        tl5=new JLabel();tl5.setFont(f1);tl5.setBounds(450,330,200,35);
        tl6=new JLabel();tl6.setFont(f1);tl6.setBounds(450,330,150,35);
        tl7=new JLabel();tl7.setFont(f1);tl7.setBounds(450,390,350,35);
        tl8=new JLabel();tl8.setFont(f1);tl8.setBounds(450,450,250,35);
        tl9=new JLabel();tl9.setFont(f1);tl9.setBounds(450,510,250,35);
        tl10=new JLabel();tl10.setFont(f1);tl10.setBounds(450,570,250,35);    
        viewPanel.add(l2); viewPanel.add(l3); viewPanel.add(l4); viewPanel.add(l6); viewPanel.add(l7); viewPanel.add(l8); viewPanel.add(l9); viewPanel.add(l10);
        viewPanel.add(tl2); viewPanel.add(tl3); viewPanel.add(tl4);  viewPanel.add(tl6); viewPanel.add(tl7); viewPanel.add(tl8); viewPanel.add(tl9); viewPanel.add(tl10);
        viewPanel.setBackground(new Color(247, 207, 121));
        view(mail, password);viewPanel.setVisible(true);  
    }    
    static String sb="";int ii=0;
    public  void addEdit(JPanel editPanel){
        sb="";
        update(mail, password);
        editPanel.setLayout(null);
        editPanel.setBounds(600, 270, 1240,800);         
        JLabel bb=new JLabel("------------------------------------------------------------------------------------------------------------------");
        bb.setBounds(50,80,1300,50);        
        bb.setFont(new Font("Times New Roman",13,30));
        editPanel.add(bb);              
        JTextField namField,rollField;  
        namField=new JTextField();namField.setBounds(330,160,320,35);
        rollField=new JTextField();rollField.setBounds(330,220,320,35); 
        JTextField mobi;
        mobi=new JTextField();mobi.setBounds(330,400,320,35);
        System.out.println("Details: "+sb);
        String[] str1=new String[3];
        int j=0;   
        String dum="";
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==','){
                str1[j]=dum;j++;
                dum="";
            }
            else if(sb.charAt(i)==' '){
                System.out.println("White space");
                dum+=sb.charAt(i);
            }
            else if(Character.isLetterOrDigit(sb.charAt(i))){
                dum+=sb.charAt(i);
            }
        }
        if(dum.length()!=0){
            str1[j]=dum;
        }
        System.out.println(str1);
        namField.setText(str1[0]);
        rollField.setText(str1[1]);
        mobi.setText(str1[2]);mobi.setEditable(false);
        System.out.println("Mobile Number: "+mobi.getText());
        editPanel.add(namField); 
        editPanel.add(rollField);  
        editPanel.add(mobi);
        
        JCheckBox chkbox=new JCheckBox();
        chkbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chkbox.isSelected()){
                    mobi.setEditable(true);
                }
            }
        });
        chkbox.setBounds(670,400,320,35);
        editPanel.add(chkbox);
        chkbox.setBackground(new Color(247, 207, 121));
        Font fo=new Font("Eras Bold ITC",Font.BOLD,25);
        Font f1=new Font("Century",Font.BOLD,25);
        Font fi=new Font("Eras Demi ITC",Font.BOLD,30);
        l01=new JLabel("UPDATE DETAILS");l01.setFont(fi);l01.setBounds(450,60,350,45);
        l02=new JLabel("Name:");l02.setFont(fo);l02.setBounds(120,160,150,35);
        l03=new JLabel("Roll No:");l03.setFont(fo);l03.setBounds(120,220,150,35);
        l04=new JLabel("College Mail:");l04.setFont(fo);l04.setBounds(120,280,200,35);
        l05=new JLabel("Password:");l05.setFont(fo);l05.setBounds(120,340,200,35);
        l06=new JLabel("Mobile No:");l06.setFont(fo);l06.setBounds(120,400,150,35);
        l07=new JLabel("Destination:");l07.setFont(fo);l07.setBounds(120,460,350,35);
        l08=new JLabel("Selected Bus:");l08.setFont(fo);l08.setBounds(120,520,250,35);
        l09=new JLabel("Fees Allocated:");l09.setFont(fo);l09.setBounds(120,580,250,35);
        l010=new JLabel("Fees Paid:");l010.setFont(fo);l010.setBounds(120,640,250,35);    
        t0l4=new JLabel();t0l4.setFont(f1);t0l4.setBounds(330,280,400,35);
        t0l5=new JLabel();t0l5.setFont(f1);t0l5.setBounds(330,340,200,35);       
        t0l7=new JLabel();t0l7.setFont(f1);t0l7.setBounds(330,460,350,35);
        t0l8=new JLabel();t0l8.setFont(f1);t0l8.setBounds(330,520,250,35);
        t0l9=new JLabel();t0l9.setFont(f1);t0l9.setBounds(330,580,250,35);
        t0l10=new JLabel();t0l10.setFont(f1);t0l10.setBounds(330,640,250,35);
        editPanel.add(l01);       
        JButton save=new JButton("Save");
        save.setBounds(790,600,260,70);
        editPanel.add(save);    
        save.setFont(new Font("Bahnschrift",Font.PLAIN,30));
        editPanel.add(l02); editPanel.add(l03); editPanel.add(l04); editPanel.add(l05); editPanel.add(l06); editPanel.add(l07); editPanel.add(l08); editPanel.add(l09); editPanel.add(l010);
        editPanel.add(t0l4); editPanel.add(t0l5);editPanel.add(t0l7); editPanel.add(t0l8); editPanel.add(t0l9); editPanel.add(t0l10);
        
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                  if(namField.getText().length()!=0 && rollField.getText().length()!=0){
                      System.out.println("Submission: "+mobi.getText());
                        try{
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
                            Statement st=con.createStatement();
                            String name=namField.getText(),no=rollField.getText(),mo=mobi.getText();
                            System.out.println(name+"--->"+no+"--->"+mo);
                            String q1="update StudentDetails set name='"+name+"',rollno='"+no+"',mobile_number='"+mo+"' where mail='"+mail+"' and password='"+password+"'";
                            int t=st.executeUpdate(q1);
                            if(t==1){
                                System.out.println("Success: "+t);
                                JOptionPane.showMessageDialog(StudentPage.this,"Successfully Updated","Alert",JOptionPane.CLOSED_OPTION); 
                            }
                            con.setAutoCommit(true);
                            con.close();
                            }
                            catch(Exception e1){System.out.println("Error is: "+e1);}
                  } 
                  else{
                      String name=namField.getText(),no=rollField.getText(),mo=mobi.getText();
                      System.out.println(name+"--->"+no+"--->"+mo);
                      JOptionPane.showMessageDialog(StudentPage.this,"Field Empty!!","Alert",JOptionPane.WARNING_MESSAGE); 
                  }
            }
        });
        
        mobi.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Listener OMG: "+mobi.getText());    
            }
        });
        editPanel.setVisible(true);
        editPanel.setBackground(new Color(247, 207, 121));
    }String key="";
    public void paintComponent1(Graphics g){
        super.paintComponents(g);
        g.setColor(Color.white);
        g.fillRect(30, 30,1240,8000);
    }
    
    public void addReport(JPanel reportpanel){               
        reportpanel.setBounds(600,270,1240,800);
        reportpanel.setLayout(null);
        JLabel note=new JLabel("Note:");
        note.setBounds(100,130,1200, 35);
        note.setFont(new Font("Arial Black",Font.BOLD,29));
        reportpanel.add(note);
        JLabel description1=new JLabel("🔆 Report if you have any grievances regarding the SKI Transport Management.");
        description1.setBounds(100,160,1200, 35);
        reportpanel.add(description1);
        description1.setFont(new Font("Calibri (Body)",Font.PLAIN,22));
        JLabel description2=new JLabel("🔆 Details will be recorded if you Submit.");
        description2.setBounds(100,195,1200, 35);
        reportpanel.add(description2);
        description2.setFont(new Font("Calibri (Body)",Font.PLAIN,22));
        JLabel description3=new JLabel("🔆 Actions will be taken within 24 hours of Submission.");
        description3.setBounds(100,230,1200, 35);
        reportpanel.add(description3);
        JTextArea reptext;
        description3.setFont(new Font("Calibri (Body)",Font.PLAIN,22));
        JLabel line1=new JLabel("------------------------------------------------------------------------------");
        line1.setBounds(100,90,1200,40);
        line1.setFont(new Font("Times New Roman",113,40));
        reportpanel.add(line1);
        JLabel line2=new JLabel("------------------------------------------------------------------------------");
        line2.setBounds(100,300,1200,90);
        line2.setFont(new Font("Times New Roman",113,40));
        reportpanel.add(line2);
        JLabel j1=new JLabel("REPORT");
        j1.setBounds(510,50,500,70);
        j1.setFont(new Font("Britannic Bold",12,40));
        reportpanel.add(j1);
        reptext=new JTextArea();
        reptext.setBounds(190,400,850,190);
        reportpanel.add(reptext);
        reptext.setFont(new Font("Californian FB",13,22));
        JButton send=new JButton("SEND");
        send.setFont(new Font("Britannic Bold",13,27));
        send.setBounds(530,630,120,50);
        send.setEnabled(false);
        reportpanel.add(send);
        reptext.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
            @Override
            public void keyPressed(KeyEvent e) { }
            @Override
            public void keyReleased(KeyEvent e) {
                String report=reptext.getText();
                if(report.length()==0){
                    send.setEnabled(false);
                }
                if(report.length()!=0){
                    send.setEnabled(true);
                }
                if(report.length()>0 && report.length()<=500){
                    reptext.setBackground(Color.white);
                }
                else if(report.length()>500){
                    reptext.setBackground(Color.red);
                }                
            }
        });  
        //reptext.setText("Illinois");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(reptext.getText());
                JOptionPane.showMessageDialog(reportpanel,"Want to send??","Alert",JOptionPane.WARNING_MESSAGE); 
                String report=reptext.getText();
                SqlCreation.sendReport(mail,report);
            }
        });
        reportpanel.setVisible(true);
        reportpanel.setBackground(new Color(247, 207, 121));
    } 
    public static void editChanges(){
       
    }
    public static void main(String[] args) {
        new StudentPage("19euec018@skcet.ac.in","Arun@123");
    }
    public void update(String email,String pass){ 
       try{
            mail=email;
            password=pass;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from StudentDetails where mail='"+email+"' and password='"+pass+"'");
            while(rs.next()){
                sb+=rs.getString("name")+",";
                sb+=rs.getString("rollno")+",";           
                t0l4.setText(rs.getString("mail")); 
                t0l5.setText(rs.getString("password"));
                sb+=rs.getString("mobile_number")+",";
                t0l7.setText(rs.getString("destin"));
                t0l8.setText(rs.getString("bus")); 
                t0l9.setText(rs.getString("fees"));
                t0l10.setText(rs.getString("paid")); 
            }                                 
            con.setAutoCommit(true);
            con.close();
        }
    catch(Exception e){System.out.println(e);}
    }
    void view(String email,String password){ 
       try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from StudentDetails where mail='"+email+"'");             
             while(rs.next()){
                tl2.setText(rs.getString("name")); 
                tl3.setText(rs.getString("rollno"));
                tl4.setText(rs.getString("mail")); 
                tl5.setText(rs.getString("password"));
                tl6.setText(rs.getString("mobile_number")); 
                tl7.setText(rs.getString("destin"));
                tl8.setText(rs.getString("bus")); 
                tl9.setText(rs.getString("fees"));
                tl10.setText(rs.getString("paid"));
            }
           con.setAutoCommit(true);
           con.close();
        }
        catch(Exception e){System.out.println("Ohhh No!!!! "+e);}    
     }
}
