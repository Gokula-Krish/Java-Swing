package bootathon1_JAVA;
import java.awt.Color;
import java.util.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
public class StudentReg implements ActionListener,MouseListener{
    JFrame f;
    JLabel fw,uw;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t2,t3,t4,t7,t10,t11,jc2;
    JComboBox jc1;
    JCheckBox jcb1,show1,show2;
    JButton b1,sub,can,choose;
    JPasswordField t5,t6;
    JFileChooser fc;
    boolean x=true,y=true;int flag=1;boolean pay=false;
    StudentReg(){
    Font fo=new Font("Eras Bold ITC",Font.BOLD,25);
    Font fi=new Font("Eras Demi ITC",Font.BOLD,20);
    Color c=new Color(255,255,0);
    l1=new JLabel("HI...WELCOME TO BUS REGISTRATION");
    l1.setBounds(610,25,800,50);
    l1.setFont(new Font("Segoe UI Black",Font.BOLD,30));
    l1.setForeground(Color.WHITE);
    l2=new JLabel("Name:");l2.setFont(fo);l2.setBounds(585,100,150,35);l2.setForeground(c);
    l3=new JLabel("Roll No:");l3.setFont(fo);l3.setBounds(585,150,150,35);l3.setForeground(c);
    l4=new JLabel("College Mail:");l4.setFont(fo);l4.setBounds(585,200,200,35);l4.setForeground(c);
    l5=new JLabel("Password:");l5.setFont(fo);l5.setBounds(585,250,200,35);l5.setForeground(c);
    l6=new JLabel("Re-Enter Password:");l6.setFont(fo);l6.setBounds(585,300,270,35);l6.setForeground(c);
    l7=new JLabel("Mobile:");l7.setFont(fo);l7.setBounds(585,350,150,35);l7.setForeground(c);
    l8=new JLabel("Pick your Destination:");l8.setFont(fo);l8.setBounds(585,400,350,35);l8.setForeground(c);
    l9=new JLabel("Select a Bus:");l9.setFont(fo);l9.setBounds(585,450,250,35);l9.setForeground(c);
    l10=new JLabel("Fees Allocated:");l10.setFont(fo);l10.setBounds(585,500,250,35);l10.setForeground(c);
    l11=new JLabel("Payable Amount:");l11.setFont(fo);l11.setBounds(585,550,250,35);l11.setForeground(c);
    l12=new JLabel("Upload your Photo:");l12.setFont(fo);l12.setBounds(585,750,300,35);l12.setForeground(c);
    uw=new JLabel("No File Choosen");uw.setFont(fi);uw.setBounds(1095,750,300,35);uw.setForeground(Color.WHITE);
    fw=new JLabel("50% fees is mandatory");fw.setFont(new Font("Eras Demi ITC",Font.BOLD,18));
    fw.setBounds(875,590,350,35);fw.setForeground(new Color(255,255,255));
    t2=new JTextField();t2.setFont(fi);t2.setBounds(935,100,250,35);
    t3=new JTextField();t3.setFont(fi);t3.setBounds(935,150,250,35);
    t4=new JTextField();t4.setFont(fi);t4.setBounds(935,200,250,35);
    t5=new JPasswordField();t5.setFont(fi);t5.setBounds(935,250,250,35);   //Old-75   //425
    t6=new JPasswordField();t6.setFont(fi);t6.setBounds(935,300,250,35);
    t7=new JTextField();t7.setFont(fi);t7.setBounds(935,350,250,35);
    t10=new JTextField();t10.setFont(fi);t10.setBounds(935,500,250,35);    
    t11=new JTextField();t11.setFont(fi);t11.setBounds(935,550,250,35);     
    String ss=SqlCreation.getBusDetails();String arr1[]=ss.split(" ");
    String s1=SqlCreation.getBusDestination();
    String arr2[]=s1.split(" ");
    String ss1=arr2[0];
    String fee=SqlCreation.getFees(ss1);
    t10.setText(fee);
    t10.setEditable(false);
    jc1=new JComboBox(arr2);jc1.setFont(fi);jc1.setBounds(935,400,250,35);
    jc2=new JTextField();jc2.setFont(fi);jc2.setBounds(935,450,250,35);   
    String id1=SqlCreation.getBusID(arr2[0]);
    jc2.setText(id1);
    jc1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String city=(String)jc1.getSelectedItem();
            String fees=SqlCreation.getFees(city);
            t10.setText(fees);
            t10.setEditable(false);
            String id=SqlCreation.getBusID((String)jc1.getSelectedItem());
            jc2.setText(id);
            jc2.setEditable(false);
        }
    });
    b1=new JButton("Pay");b1.setFont(fi);b1.setBounds(1125,595,100,30);b1.setBackground(Color.BLACK);
    b1.setFocusable(false);b1.setForeground(Color.WHITE);
    sub=new JButton("Submit");sub.setFont(fi);sub.setBounds(935,900,150,30);sub.setBackground(Color.BLACK);
    sub.setFocusable(false);sub.setForeground(Color.WHITE);
    can=new JButton("Cancel");can.setFont(fi);can.setBounds(1095,900,150,30); can.setBackground(Color.RED);can.setFocusable(false);
    choose=new JButton("Upload");choose.setFont(fi);choose.setBounds(935,755,150,30);choose.setBackground(Color.BLACK);
    choose.setFocusable(false);choose.setForeground(Color.WHITE);
    jcb1=new JCheckBox("I declare that above provided details are true");jcb1.setFont(fo);jcb1.setBounds(585,850,650,35);jcb1.setFocusable(false);
    show1=new JCheckBox("Show");show1.setFont(fi);show1.setBounds(1195,260,100,30);show1.setFocusable(false);
    show2=new JCheckBox("Show");show2.setFont(fi);show2.setBounds(1195,310,100,30);show2.setFocusable(false);
    Image i=Toolkit.getDefaultToolkit().getImage("D:\\BENZ.jpg");
    sub.setEnabled(false);fw.setVisible(false);
    f=new JFrame("Student Bus Registration");
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setContentPane(new JPanel(){
            @Override
            public void paintComponent(Graphics g){
             super.paintComponent(g);       
             g.drawImage(i,0, 0,f);
             g.setColor(new Color(0,0,0,150));
             g.fillRect(460,10,950,950);
            }
        });
    f.setLayout(null);
    f.setVisible(true);
    f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);f.add(l9);f.add(l10);
    f.add(l11);f.add(l12);f.add(fw);f.add(uw);
    f.add(t2);f.add(t3);f.add(t4);f.add(t5);f.add(t6);f.add(t7);f.add(t10);f.add(t11);
    f.add(jc1);f.add(jc2);
    f.add(jcb1);f.add(show1);f.add(show2);
    f.add(b1);f.add(sub);f.add(can);f.add(choose);
    b1.addActionListener(this);sub.addActionListener(this);can.addActionListener(this);jcb1.addActionListener(this);
    show1.addActionListener(this);show2.addActionListener(this);choose.addActionListener(this);
    t2.addMouseListener(this);t3.addMouseListener(this);t4.addMouseListener(this);t5.addMouseListener(this);
    t6.addMouseListener(this);t7.addMouseListener(this);t10.addMouseListener(this);t11.addMouseListener(this);
    }
    public static void main(String[] args) {
        new StudentReg();
    }  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            if(!match.checkFees(t10.getText(),t11.getText())){
            }
            else{
                pay=true;
                fw.setVisible(false);
                JOptionPane.showMessageDialog(f,"Payment Successful");
            }
        }
        if(e.getSource()==choose){
            fc=new JFileChooser();
            fc.showOpenDialog(null);
        }
        if(e.getSource()==sub){
            if(/*match.checkName(t2.getText()) &&*/match.checkMail(t4.getText()) && match.checkPassword(t6.getText()) 
               && match.checkPhone(t7.getText()) && t5.getText().equals(t6.getText()) && pay){
                 t2.setBackground(Color.WHITE);
                 t4.setBackground(Color.WHITE);
                 t5.setBackground(Color.WHITE);
                 t6.setBackground(Color.WHITE);
                 t7.setBackground(Color.WHITE);
                 String[] ss={t2.getText(),t3.getText(),t4.getText(),t5.getText(),t7.getText(),(String)jc1.getSelectedItem(),(String)jc2.getText(),t10.getText(),t11.getText()};
                 SqlCreation.insertusertab(ss);
                 System.out.println("Sucessfull");
                 JOptionPane.showMessageDialog(f,"Successfully Submitted");
                 String mail=t4.getText();
                 JavaMail.sendConfirmationMail("Successfully Registered for SKI-Transport Management System :"+t2.getText(),mail);
                 }
            else{
                if(match.checkMail(t4.getText())==false)
                    t4.setBackground(Color.RED);       
                else
                     t4.setBackground(Color.WHITE);  
                if(!t5.getText().equals(t6.getText())){
                     t5.setBackground(Color.RED);
                     t6.setBackground(Color.RED);
                }
                else{
                    t5.setBackground(Color.WHITE);
                    t6.setBackground(Color.WHITE); 
                }
                if(match.checkPassword(t6.getText())==false)
                     t6.setBackground(Color.RED);  
                else
                    t6.setBackground(Color.WHITE); 
                if(match.checkPhone(t7.getText())==false)
                    t7.setBackground(Color.RED);   
                else
                   t7.setBackground(Color.WHITE);
                if(pay==false)
                    fw.setVisible(true);
                else
                    fw.setVisible(false);
         }
        }
        if(e.getSource()==can){
            f.dispose();
        }
         if(e.getSource()==jcb1 && flag==1){
            sub.setEnabled(true);
            flag=0;
          }
          else if(e.getSource()==jcb1 && flag==0){
            sub.setEnabled(false);
            flag=1;
           }
        if(e.getSource()==show1 && x==true){
            t5.setEchoChar('\0');
            x=false;
          }
          else if(e.getSource()==show1&& x==false){
            t5.setEchoChar('*');
            x=true;
           }
         if(e.getSource()==show2 && y==true){
            t6.setEchoChar('\0');
            y=false;
          }
          else if(e.getSource()==show2 && y==false){
            t6.setEchoChar('.');
            y=true;
           }
    }
    Color co1=new Color(135,206,235);
    Color co2=new Color(255,255,255);
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==t2) t2.setBackground(co1);
        if(e.getSource()==t3) t3.setBackground(co1);
        if(e.getSource()==t4) t4.setBackground(co1);
        if(e.getSource()==t5) t5.setBackground(co1);
        if(e.getSource()==t6) t6.setBackground(co1);
        if(e.getSource()==t7) t7.setBackground(co1);
        if(e.getSource()==t10) t10.setBackground(co1);
        if(e.getSource()==t11) t11.setBackground(co1);
    }
    @Override
    public void mouseExited(MouseEvent e) {
         if(e.getSource()==t2) t2.setBackground(co2);
        if(e.getSource()==t3) t3.setBackground(co2);
        if(e.getSource()==t4) t4.setBackground(co2);
        if(e.getSource()==t5) t5.setBackground(co2);
        if(e.getSource()==t6) t6.setBackground(co2);
        if(e.getSource()==t7)  t7.setBackground(co2);
        if(e.getSource()==t10) t10.setBackground(co2);
        if(e.getSource()==t11)  t11.setBackground(co2);
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
}