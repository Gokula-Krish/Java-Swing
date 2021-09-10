package bootathon1_JAVA;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.util.Arrays;
import javax.swing.*;
public class AdminPage extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JLabel tl1,tl2,tl3,tl4,tl5,tl6,tl7,tl8,tl9,tl10;
    JFrame hm;
    Font fo=new Font("Eras Bold ITC",Font.BOLD,25);
    Font f=new Font("Times New Roman",Font.BOLD,20);
    JPanel reportpanel = new JPanel();
    JPanel updatePanel=new JPanel();
    JPanel infoPanel=new JPanel();
    JPanel addPanel=new JPanel();
    JLabel report,update,info,add;
    public AdminPage(){
        super("Admin Dashboard");
        hm=this;
        setLayout(null);
        setBounds(0,0,1900,1400);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lab1=new JLabel("Admin DashBoard");
        lab1.setBounds(875,60,1000,90);
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
        update =new JLabel("Update");
        update.setBounds(960,210,135,50);
        update.setForeground(Color.white);
        update.setFont(new Font("Segoe UI Black",12,30));
        add(update);
        info =new JLabel("Information");
        info.setBounds(1550,210,190,50);
        info.setForeground(Color.white);
        info.setFont(new Font("Segoe UI Black",12,30));
        add(info);                                                                                                          
        System.out.println("HOME PAGE ADMIN");                 
        report=new JLabel("Reports");
        report.setBounds(1285,210,135,50);
        report.setForeground(Color.white);
        report.setFont(new Font("Segoe UI Black",12,30));
        add(report);
        add=new JLabel("Add Bus");
        add.setBounds(670,210,150,50);
        add.setForeground(Color.white);
        add.setFont(new Font("Segoe UI Black",12,30));
        add(add);
        update.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}
            @Override
            public void mouseMoved(MouseEvent e) {
                update.setOpaque(true);
                update.setBackground(new Color(10, 56, 130));
            }
        });

        info.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e){}
            @Override
            public void mouseMoved(MouseEvent e) {
                info.setOpaque(true);
                info.setBackground(new Color(10, 56, 130));
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
        add.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}
            @Override
            public void mouseMoved(MouseEvent e) {
                add.setOpaque(true);
                add.setBackground(new Color(10, 56, 130));
               
            }
        });       
        report.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                updatePanel.setVisible(false);
                infoPanel.setVisible(false);
                addPanel.setVisible(false);
                addReport(reportpanel);  
            }
        }); 
        add(reportpanel);
        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              reportpanel.setVisible(false);
              infoPanel.setVisible(false);
              addPanel.setVisible(false);
              addUpdate(updatePanel);  
              
            }
        }); 
        add(updatePanel);
        info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                updatePanel.setVisible(false);
                reportpanel.setVisible(false);
                addPanel.setVisible(false);
                addInfo(infoPanel);   
                
            }
        });        
        add(infoPanel);  
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                
                updatePanel.setVisible(false);
                reportpanel.setVisible(false);
                infoPanel.setVisible(false);
                addAdd(addPanel);   
                
            }
        });        
        add(addPanel);
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                back.setBackground(Color.green);
                back.setForeground(Color.black);  
                update.setBackground(new Color(140, 184, 255));  
                info.setBackground(new Color(140, 184, 255));  
                report.setBackground(new Color(140, 184, 255)); 
                add.setBackground(new Color(140, 184, 255));
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
              Image img1=new ImageIcon("D:\\violet.jpg").getImage();
              g.drawImage(img1,0,0,490,1100,null);
              g.setColor(Color.white);
              g.fillRect(490,0,1700,1970);
              g.setColor(new Color(140, 184, 255));
              g.fillRect(600,200,1240,70);
              g.setColor(new Color(247, 207, 121));
              g.fillRect(600,270,1240,800);
              g.setColor(Color.lightGray);
              g.fillRect(650,0,1100,170);
              Image img2=new ImageIcon("D:\\admin.jpg").getImage();
              g.drawImage(img2,670,20,160,130,null);
            }
        },BorderLayout.CENTER);        
        setVisible(true);
    } 
    public void addUpdate(JPanel editPanel){
        JFrame f;boolean create=true;
        JLabel note;
        JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,uw;
        JLabel back;
        JTextField t2,t3,t4,t5,t7,t8,t9;
        JComboBox bus;
        JCheckBox jcb1;
        JButton sub,can,choose,select;
        JFileChooser fc;
        Font fo=new Font("Times New Roman",Font.BOLD,25);
        Font fi=new Font("Times New Roman",Font.BOLD,25);
        l1=new JLabel("WELCOME ADMIN! UPDATE ANY BUS DETAILS");
        l1.setBounds(210,25,800,50);
        l1.setFont(new Font("Segoe UI Black",Font.BOLD,30));
        l1.setForeground(Color.WHITE);
        l2=new JLabel("Bus Name:");l2.setFont(fo);l2.setBounds(365,100,150,35);
        l3=new JLabel("Driver's Name:");l3.setFont(fo);l3.setBounds(365,150,200,35);
        l4=new JLabel("Seats Holdable:");l4.setFont(fo);l4.setBounds(365,200,220,35);
        l5=new JLabel("Destination Place:");l5.setFont(fo);l5.setBounds(365,250,250,35);
        l6=new JLabel("Boarding Time ");l6.setFont(fo);l6.setBounds(365,300,270,35);
        l7=new JLabel("Morning(am):");l7.setFont(fo);l7.setBounds(365,350,200,35);
        l8=new JLabel("Evening(pm):");l8.setFont(fo);l8.setBounds(365,400,200,35);
        l9=new JLabel("Bus Fees(Rs):");l9.setFont(fo);l9.setBounds(365,450,250,35);
        l10=new JLabel("Upload Bus image:");l10.setFont(fo);l10.setBounds(365,507,250,35);
        uw=new JLabel("No File Choosen");uw.setFont(fi);uw.setBounds(795,507,300,35);uw.setForeground(Color.RED);
        String ss=SqlCreation.getBusDetails();
        String busdet[]=ss.split(" ");
        System.out.println(Arrays.toString(busdet));
        bus=new JComboBox(busdet);
        bus.setFont(fi);
        bus.setBounds(635,100,250,35);      
        t2=new JTextField();t2.setFont(fi);t2.setBounds(635,100,250,35);t2.setEditable(false);
        t3=new JTextField();t3.setFont(fi);t3.setBounds(635,150,250,35);
        t4=new JTextField();t4.setFont(fi);t4.setBounds(635,200,250,35);t4.setEditable(false);t4.setToolTipText("Number of seats holdable can not be edited");
        t5=new JTextField();t5.setFont(fi);t5.setBounds(635,250,250,35);   //Old-75   //425
        t7=new JTextField();t7.setFont(fi);t7.setBounds(635,350,250,35);
        t8=new JTextField();t8.setFont(fi);t8.setBounds(635,400,250,35);
        t9=new JTextField();t9.setFont(fi);t9.setBounds(635,450,250,35);  
        select=new JButton("Select");select.setFont(fi);select.setBounds(900,105,100,25);select.setBackground(Color.BLACK);select.setForeground(Color.WHITE);
        sub=new JButton("Update");sub.setFont(fi);sub.setBounds(540,550,150,50); sub.setBackground(Color.GREEN);
        sub.setFocusable(false);sub.setForeground(Color.BLACK);
        can=new JButton("Cancel");can.setFont(fi);can.setBounds(700,650,150,30); can.setBackground(Color.RED);can.setFocusable(false);
        choose=new JButton("Upload");choose.setFont(fi);choose.setBounds(635,510,150,30);choose.setBackground(Color.BLACK);
        choose.setFocusable(false);choose.setForeground(Color.WHITE);
        note=new JLabel("* Please Check that the above provided details are correct *");note.setFont(fo);note.setBounds(325,580,900,35);note.setForeground(Color.RED);
        Image i=Toolkit.getDefaultToolkit().getImage("D:\\STEPS DEGREE.jpg");
        editPanel.setLayout(null);
        editPanel.setVisible(true);
        editPanel.add(l1);editPanel.add(l2);editPanel.add(l3);editPanel.add(l4);editPanel.add(l5);editPanel.add(l6);editPanel.add(l7);editPanel.add(l8);editPanel.add(l9);//editPanel.add(note);//editPanel.add(l10);editPanel.add(uw);
        editPanel.add(t3);editPanel.add(t4);editPanel.add(t5);editPanel.add(t7);editPanel.add(t8);editPanel.add(t9);
        editPanel.add(sub);
        editPanel.add(bus);
        editPanel.setVisible(true);
        editPanel.setLayout(null);
        editPanel.setBounds(600, 270, 1240,800);  
        editPanel.setBackground(new Color(226, 121, 242));
    }    
    
    public void addInfo(JPanel editPanel){
        Font in=new Font("Calibri",Font.BOLD,18);
        JLabel info1,info2,info3,write,select,line;
        JTextArea mail;
        JComboBox bus;
        JButton back,send;
        editPanel.setLayout(null);
        info1=new JLabel("> The message typed below will be sent to all the students selected by you.");
        info2=new JLabel("> This could be used during any emergency situation where any bus can't reach the students. For example, government strike or bus breakdown.");
        info3=new JLabel("> The emergency message will be sent through mail.");
        info1.setFont(in);
        info2.setFont(in);
        info3.setFont(in);
        line=new JLabel("---------------------------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------");
        write=new JLabel("Type here -->");write.setFont(f);
        select=new JLabel("Select:");select.setFont(f);
        mail=new JTextArea();
        mail.setFont(f);
        String ss=SqlCreation.getBusDetails();
        String mails[]=ss.split(" ");
        bus=new JComboBox(mails);bus.setFont(f);
        bus.addItem("All students");
        mail.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(mail.getText());
            }
        });
        back=new JButton("Back");
        send=new JButton("Send Message");send.setFont(f);send.setBackground(Color.GREEN);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message will be sent....");
                 if(bus.getSelectedItem().equals("All students")){
                    String mails=SqlCreation.getAllMails();
                    String mms[]=mails.split(" ");
                    String send=mail.getText();
                    for(String i:mms){
                        JavaMail.sendInfo(send, i);
                    }
                    System.out.println("Sucessfully info sent to: "+mails);
                }
                else{
                    String mails=SqlCreation.getMalis((String)bus.getSelectedItem());
                    String mms[]=mails.split(" ");
                    String send=mail.getText();
                    System.out.println(Arrays.toString(mms)+"  "+send);
                    for(String i:mms){
                        JavaMail.sendInfo(send, i);
                    }
                    System.out.println("Sucessfully info sent to: "+mms);
                }
            }
        });
        info1.setBounds(50,10,900,50);
        info2.setBounds(50,50,1100,50);
        info3.setBounds(50,90,900,50);
        line.setBounds(0,150,2000,10);
        bus.setBounds(560,220,200,25);
        select.setBounds(485,220,150,25);
        write.setBounds(200,450,200,25);
        mail.setBounds(380,280,500,400);
        back.setBounds(400,480,70,25);
        send.setBounds(950,430,200,50);
        editPanel.add(info1);
        editPanel.add(info2);
        editPanel.add(info3);
        editPanel.add(line);
        editPanel.add(bus);
        editPanel.add(write);
        editPanel.add(mail);
        editPanel.add(select);
        editPanel.add(send);
        editPanel.setBounds(600, 270, 1240,800);
        editPanel.setBackground(new Color(226, 121, 242));
        editPanel.setVisible(true);
        back.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new AdminPage();
             }
         });
    }
    public void addReport(JPanel reportpanel){       
        JLabel info1,info2,info3,line,stid,bus;
        JTextField bname;
        JTextArea report;
        JComboBox id;
        JButton delete,next;
        Font fo=new Font("Times New Roman",Font.BOLD,25);
        Font in=new Font("Calibri",Font.BOLD,18);
        info1=new JLabel("> These are the reports from the students of our Sri Krishna Institutions regarding the issue they face in their transportation.");
        info2=new JLabel("> Once you view the reports you can delete it after informing about it to the SKI Transport Department.");
        info3=new JLabel("> You will not be able to edit anything here but just view from whom, which bus and what the report is.");
        line=new JLabel("---------------------------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------------");
        info1.setBounds(50,10,1000,50);info1.setFont(in);
        info2.setBounds(50,50,1100,50);info2.setFont(in);
        info3.setBounds(50,90,900,50);info3.setFont(in);
        line.setBounds(0,150,2000,10);
        stid=new JLabel("Student ID:");stid.setBounds(365,200,250,35);stid.setFont(fo);
        bus=new JLabel("Bus Name:");bus.setBounds(365,270,250,35);bus.setFont(fo);
        String ss=SqlCreation.getReported();
        report=new JTextArea();report.setBounds(200,340,850,200);report.setFont(in);report.setEditable(false);report.setToolTipText("Admin can not edit the complaint reported bu students.");
        String[] sp=ss.split(" "); id=new JComboBox(sp);
        String rep1=SqlCreation.getRepText(sp[0]);
        report.setText(rep1);
        id.setBounds(535,200,250,35);id.setFont(fo);id.setEditable(false);id.setToolTipText("Student id can not be edited by admin");
        bname=new JTextField();bname.setBounds(535,270,250,35);bname.setFont(fo);bname.setEditable(false);bname.setToolTipText("Admin can not edit the bus name here");
        String bus_no=SqlCreation.getBusNo(sp[0]);
        bname.setText(bus_no);
        delete=new JButton("Delete");delete.setBounds(200,560,100,50);delete.setFont(fo);delete.setBackground(Color.green);
        next=new JButton("Next");next.setBounds(950,560,100,50);next.setFont(fo);next.setBackground(Color.green);
        id.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String rep=SqlCreation.getRepText((String)id.getSelectedItem());
               report.setText(rep);
               String bus_no=SqlCreation.getBusNo((String)id.getSelectedItem());
               bname.setText(bus_no);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println((String)id.getSelectedItem());
                SqlCreation.deleteReport((String)id.getSelectedItem());
                JOptionPane.showMessageDialog(AdminPage.this,"Report Sucessfully Delted!","Deletion",JOptionPane.DEFAULT_OPTION); 
                id.removeItem(id.getSelectedItem());
            }
        });
        reportpanel.add(info1);
        reportpanel.add(info2);
        reportpanel.add(info3);
        reportpanel.add(line);
        reportpanel.add(stid);
        reportpanel.add(bus);
        reportpanel.add(id);
        reportpanel.add(bname);
        reportpanel.add(report);
        reportpanel.add(delete);
        reportpanel.add(next);
        reportpanel.setVisible(true);
        reportpanel.setLayout(null);
        reportpanel.setBounds(600, 270, 1240,800);  
        reportpanel.setBackground(new Color(226, 121, 242));
    }
    public void addAdd(JPanel editPanel){
        JFrame f;boolean create=true;
        JLabel note;
        JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,uw;
        JLabel back;
        JTextField t2,t3,t4,t5,t7,t8,t9;
        JComboBox jc1,jc2;
        JCheckBox jcb1;
        JButton sub,can,choose;
        JFileChooser fc;
        Font fo=new Font("Times New Roman",Font.BOLD,25);
        Font fi=new Font("Times New Roman",Font.BOLD,25);
        l1=new JLabel("WELCOME ADMIN! ADD THE NEW BUS DETAILS");
        l1.setBounds(210,25,800,50);
        l1.setFont(new Font("Segoe UI Black",Font.BOLD,30));
        l1.setForeground(Color.WHITE);
        l2=new JLabel("Bus Name:");l2.setFont(fo);l2.setBounds(365,100,150,35);
        l3=new JLabel("Driver's Name:");l3.setFont(fo);l3.setBounds(365,150,200,35);
        l4=new JLabel("Seats Holdable:");l4.setFont(fo);l4.setBounds(365,200,220,35);
        l5=new JLabel("Destination Place:");l5.setFont(fo);l5.setBounds(365,250,250,35);
        l6=new JLabel("Boarding Time ");l6.setFont(fo);l6.setBounds(365,300,270,35);
        l7=new JLabel("Morning(am):");l7.setFont(fo);l7.setBounds(365,350,200,35);
        l8=new JLabel("Evening(pm):");l8.setFont(fo);l8.setBounds(365,400,200,35);
        l9=new JLabel("Bus Fees(Rs):");l9.setFont(fo);l9.setBounds(365,450,250,35);
        l10=new JLabel("Upload Bus image:");l10.setFont(fo);l10.setBounds(365,507,250,35);
        uw=new JLabel("No File Choosen");uw.setFont(fi);uw.setBounds(795,507,300,35);uw.setForeground(Color.RED);
        t2=new JTextField();t2.setFont(fi);t2.setBounds(635,100,250,35);
        t3=new JTextField();t3.setFont(fi);t3.setBounds(635,150,250,35);
        t4=new JTextField();t4.setFont(fi);t4.setBounds(635,200,250,35);
        t5=new JTextField();t5.setFont(fi);t5.setBounds(635,250,250,35);  
        t7=new JTextField();t7.setFont(fi);t7.setBounds(635,350,250,35);
        t8=new JTextField();t8.setFont(fi);t8.setBounds(635,400,250,35);
        t9=new JTextField();t9.setFont(fi);t9.setBounds(635,450,250,35);  
        sub=new JButton("Submit");sub.setFont(fi);sub.setBounds(540,650,150,50); sub.setBackground(Color.GREEN);
        sub.setFocusable(false);sub.setForeground(Color.BLACK);
        can=new JButton("Cancel");can.setFont(fi);can.setBounds(700,650,150,30); can.setBackground(Color.RED);can.setFocusable(false);
        choose=new JButton("Upload");choose.setFont(fi);choose.setBounds(635,510,150,30);choose.setBackground(Color.BLACK);
        choose.setFocusable(false);choose.setForeground(Color.WHITE);
        note=new JLabel("* Please Check that the above provided details are correct *");note.setFont(fo);note.setBounds(325,580,900,35);note.setForeground(Color.RED);
        Image i=Toolkit.getDefaultToolkit().getImage("D:\\STEPS DEGREE.jpg");
        editPanel.setLayout(null);
        editPanel.setVisible(true);
        editPanel.add(l1);editPanel.add(l2);editPanel.add(l3);editPanel.add(l4);editPanel.add(l5);editPanel.add(l6);editPanel.add(l7);editPanel.add(l8);editPanel.add(l9);editPanel.add(note);//editPanel.add(l10);editPanel.add(uw);
        editPanel.add(t2);editPanel.add(t3);editPanel.add(t4);editPanel.add(t5);editPanel.add(t7);editPanel.add(t8);editPanel.add(t9);
        editPanel.add(sub);
        editPanel.setVisible(true);
        editPanel.setLayout(null);
        editPanel.setBounds(600, 270, 1240,800);  
        editPanel.setBackground(new Color(226, 121, 242));
        sub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(t2.getText().length()!=0 && t3.getText().length()!=0 && t4.getText().length()!=0 && t5.getText().length()!=0 && t7.getText().length()!=0 && t8.getText().length()!=0 && t9.getText().length()!=0){                    
                    String str="'"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t7.getText()+"','"+t8.getText()+"','"+t9.getText()+"'";
                    SqlCreation.insertvalues(str);
                    JOptionPane.showMessageDialog(AdminPage.this,"Sucessfull!","Completion",JOptionPane.DEFAULT_OPTION); 
                }
                else{
                    JOptionPane.showMessageDialog(AdminPage.this,"Field Empty!!","Alert",JOptionPane.WARNING_MESSAGE); 
                }
            }
        });
    }
    public static void main(String[] args) {
        new AdminPage();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}