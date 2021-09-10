package bootathon1_JAVA;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class HomePage extends JFrame{
    public HomePage(){
        super("Transport Management System");
        setLayout(null);
        setBounds(0,0,1900,1400);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        JLabel label0=new JLabel("Transport Management System");
        label0.setBounds(350,30,2000,150);
        label0.setForeground(Color.white);
        add(label0);      
        label0.setFont(new Font("Segoe UI Black",12,90)); 
        ImageIcon icon=new ImageIcon("D:\\skcet.png");
        Image img = icon.getImage();
        Image newimg = img.getScaledInstance(230,200,java.awt.Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(newimg);
        JButton jb=new JButton(newIcon);  
        jb.setBounds(0,0,250,200);
        add(jb,BorderLayout.CENTER);
        jb.setBackground(Color.white);
        JTabbedPane jtab=new JTabbedPane();
        jtab.setBounds(960, 250, 670,540);
        jtab.setForeground(Color.red);
        add(jtab);
        jtab.setFont(new Font("Segoe UI Black",13,19));
        jtab.addTab("ADMIN",makeLoginPanel());
        jtab.addTab("STUDENT", makeStudent()); 
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String link="http://www.skcet.ac.in/";
                    java.awt.Desktop.getDesktop().browse(java.net.URI.create(link));                   
                }
                catch(Exception ee){}
            }
        });    
        
        setLayout(new BorderLayout());
        add(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
              super.paintComponent(g);                    
              Image img=new ImageIcon("D:\\be.png").getImage();
              g.drawImage(img,0, 0,null);      
              Image img0=new ImageIcon("D:\\gg.jpg").getImage();
              g.setColor(new Color(255, 190, 79));
              g.fillRect(340, 278, 793,512);
              Image img1=new ImageIcon("D:\\trop.png").getImage();
              g.drawImage(img1,390, 288, 550,450,null);
              g.setColor(new Color(79, 237, 255,100));
              g.fillRect(320,30,1450,150);
            }
        },BorderLayout.CENTER);        
        setVisible(true);
        setResizable(true);
    }
    public JPanel makeStudent(){
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(0, 29, 143));
        JLabel wel=new JLabel("___________________STUDENT LOGIN___________________");
        wel.setBounds(20,30,900,90);
        wel.setFont(new Font("Segoe UI Black",12,26));
        wel.setForeground(Color.white);
        p.add(wel);        
        JTextField x = new JTextField();
        x.setBounds(120,190,340,50);
        p.add(x);
        x.setFont(new Font("Segoe UI Black",12,19));
        JPasswordField x1 = new JPasswordField();
        x1.setBounds(120,290,340,50);
        x1.setFont(new Font("Segoe UI Black",12,19));
        p.add(x1);   
        JLabel username=new JLabel("UserName");
        username.setBounds(120,150,340,50);
        username.setForeground(Color.white);
        username.setFont(new Font("Verdana",Font.BOLD,16));
        p.add(username);
        JLabel password=new JLabel("Password");
        password.setBounds(120,250,340,50);
        password.setForeground(Color.white);
        password.setFont(new Font("Verdana",Font.BOLD,16));
        p.add(password);
        JButton j3=new JButton("SignIn");
        j3.setBounds(80,390,200,70);
        j3.setBackground(new Color(34, 153, 189));
        j3.setFont(new Font("Segoe UI Black",12,27));
        j3.setForeground(Color.white);
        p.add(j3);
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail=x.getText();
                String pass=x1.getText();
                System.out.println(mail+"  "+pass);
                if(SqlCreation.checkLogin(mail,pass)){                   
                    new StudentPage(mail,pass);
                }
            }
        });
        x.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                x.setForeground(Color.black);
            }
        });
        x1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                x1.setForeground(Color.black);
            }
        });
        JButton j4=new JButton("Register");
        j4.setBounds(370,390,200,70);
        j4.setBackground(new Color(34, 153, 189));
        j4.setForeground(Color.white);
        j4.setFont(new Font("Segoe UI Black",12,27));
        p.add(j4);
        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentReg();
            }
        });
        JLabel jlab=new JLabel("Don't have an account?");
        jlab.setBounds(390,350,180,30);
        jlab.setForeground(Color.white);
        p.add(jlab);
        JLabel j1=new JLabel("OR");
        j1.setBounds(305,390,200,70);
        j1.setForeground(Color.white);
        j1.setFont(new Font("Segoe UI Black",13,20));
        p.add(j1);
        return p;
    }
    private JPanel makeLoginPanel(){
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.black);
        JTextField x = new JTextField();
        x.setBounds(120,190,340,50);
        p.add(x);
        JLabel wel=new JLabel("___________________ADMIN LOGIN___________________");
        wel.setBounds(20,30,900,90);
        wel.setFont(new Font("Segoe UI Black",12,26));
        wel.setForeground(Color.white);
        p.add(wel);
        JLabel username=new JLabel("UserName");
        username.setBounds(120,150,340,50);
        username.setForeground(Color.white);
        username.setFont(new Font("Verdana",Font.BOLD,16));
        p.add(username);
        x.setFont(new Font("Segoe UI Black",12,19));
        JPasswordField x1 = new JPasswordField();
        x1.setBounds(120,290,340,50);
        x1.setFont(new Font("Segoe UI Black",12,19));
        p.add(x1);        
        JLabel password=new JLabel("Password");
        password.setBounds(120,250,340,50);
        password.setForeground(Color.white);
        password.setFont(new Font("Verdana",Font.BOLD,16));
        p.add(password);
        JButton j3=new JButton("SignIn");
        j3.setBounds(200,390,200,70);
        j3.setBackground(new Color(163, 252, 151));
        j3.setFont(new Font("Segoe UI Black",12,27));
        p.add(j3);
        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x.getText().equals("gokulkrish.elangovan10@gmail.com") && x1.getText().equals("AdminGokul@skcet")){
                    new AdminPage();
                }
                else if((x.getText()!="UserName" && x1.getText()!="Password")||(x.getText()=="" && x1.getText()=="")||(x.getText()=="" || x1.getText()=="")){
                    JOptionPane.showMessageDialog(HomePage.this,"Field Empty!!","Alert",JOptionPane.WARNING_MESSAGE); 
                }
            }
        });
        return p;
    }
    public static void main(String[] args) {
        new HomePage();
    }
}