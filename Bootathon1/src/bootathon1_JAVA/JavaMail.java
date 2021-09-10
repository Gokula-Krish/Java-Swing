package bootathon1_JAVA;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class JavaMail {
    public static void sendInfo(String info,String TOthe){
        final String  userName="gokul10test@gmail.com";
        final String password="GokulVg@19";
        final String from="gokul10test@gmail.com";
        final String to=TOthe;
        Properties prs=new Properties();
        prs.put("mail.smtp.host","smtp.gmail.com");
        prs.put("mail.smtp.socketFactory.port","465");
        prs.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        prs.put("mail.smtp.auth", "true");
        prs.put("mail.smtp.port", "465");
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,password);
            }            
        };
        Session ses=Session.getInstance(prs, auth);
        try{
            Message msg=new MimeMessage(ses);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            msg.setSubject("Transport Management System");
            msg.setText(info);
            Transport.send(msg);
            System.out.println("Message sent successfully");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void sendConfirmationMail(String subject,String mail){
        final String  userName="gokul10test@gmail.com";
        final String password="GokulVg@19";
        final String from="gokul10test@gmail.com";
        final String to=mail;
        Properties prs=new Properties();
        prs.put("mail.smtp.host","smtp.gmail.com");
        prs.put("mail.smtp.socketFactory.port","465");
        prs.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        prs.put("mail.smtp.auth", "true");
        prs.put("mail.smtp.port", "465");
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,password);
            }            
        };
        Session ses=Session.getInstance(prs, auth);
        try{
            Message msg=new MimeMessage(ses);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText("Hi there \n You've been successfully registered for SKI-Transport Management System. \n Further Details will be conveyed through later \n Thank you.");
            Transport.send(msg);
            System.out.println("Message sent successfully");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public static void sendMail(){
        final String  userName="gokul10test@gmail.com";
        final String password="GokulVg@19";
        final String from="gokul10test@gmail.com";
        final String to="19euec045@skcet.ac.in";
        Properties prs=new Properties();
        prs.put("mail.smtp.host","smtp.gmail.com");
        prs.put("mail.smtp.socketFactory.port","465");
        prs.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        prs.put("mail.smtp.auth", "true");
        prs.put("mail.smtp.port", "465");
        Authenticator auth=new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,password);
            }            
        };
        Session ses=Session.getInstance(prs, auth);
        try{
            Message msg=new MimeMessage(ses);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
            msg.setSubject("Transport Management System");
            msg.setText("Java mail testing \n Hi there, \n Good evening.Glad to announce \n Thank you");
            Transport.send(msg);
            System.out.println("Message sent successfully");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
