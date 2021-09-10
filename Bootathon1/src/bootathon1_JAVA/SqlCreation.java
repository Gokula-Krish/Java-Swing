package bootathon1_JAVA;
import static bootathon1_JAVA.StudentPage.mail;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
public class SqlCreation {
    static String rollNo;
    static String bus;
    public static String getAllMails(){
        String ss="";
         try{
             System.out.println("Hello MAILS");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select mail from StudentDetails");                 
            while(rs.next()){
                ss+=rs.getString("mail")+" ";
                System.out.println(rs.getString("mail"));
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Bus Details added: ");
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    public static String getBusID(String des){
        String ss="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select name from BusTable where destination='"+des+"'");            
            while(rs.next()){
                ss+=rs.getString("name")+" ";
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Bus Details added: ");
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    public static String getFromStudent(String destin){
        String ss="";
         try{            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
             System.out.println("select * from StudentDetails where destin='"+destin+"'");
            ResultSet rs=st.executeQuery("select * from StudentDetails where destin='"+destin+"'");            
            while(rs.next()){
                System.out.println(rs.getString("mail")+"mail");
                ss+=rs.getString("mail")+" ";
            }            
             System.out.println("From:::: "+ss);
            System.out.println("Bus Details added: "+ss);
            con.setAutoCommit(true);
            con.close();            
        }
        catch(Exception e){System.out.println("Info: "+e);}
        return ss;
    }
    public static String getMalis(String bus){
        String ss="",ans="";
         try{            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from BusTable where name='"+bus+"'");            
            while(rs.next()){
                ss+=rs.getString("destination");
            }            
            System.out.println("Bus Details added: "+ss);
            con.setAutoCommit(true);
            con.close();
            ans=getFromStudent(ss);
        }
        catch(Exception e){System.out.println("Info: "+e);}
        return ans;
    }
    public static String getBusDestination(){
        String ss="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from BusTable");            
            while(rs.next()){
                ss+=rs.getString("destination")+" ";
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Bus Details added: "+ss);
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    public static String getFees(String dest){
         String ss="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select fees from BusTable where destination='"+dest+"'");            
            while(rs.next()){
                ss+=rs.getString("fees");
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Bus Details added: "+ss);
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    public static String getBusDetails(){
        String ss="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from BusTable");
            
            while(rs.next()){
                ss+=rs.getString("name")+" ";
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Bus Details added: "+ss);
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    public static void sendReport(String mail,String report){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from StudentDetails where mail='"+mail+"'");
            while(rs.next()){
                rollNo=rs.getString("rollno");
                bus=rs.getString("bus");
            }                                 
            con.setAutoCommit(true);
            con.close();
            String s="'"+rollNo+"','"+bus+"','"+report+"'";
            insertvaluesReport(s);
        }
        catch(Exception e){System.out.println(e);}
    }
    static void createReportTable(){
        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement  st = con.createStatement();
            String q="create table reporttable(rollno varchar(10),bus varchar(3),report varchar(100))";
            st.executeUpdate(q);
            con.setAutoCommit(true);
            con.close();
            System.out.println("Table created");
        }
        catch(Exception e){
             System.out.println(e);
        }
    }
    static void insertvaluesReport(String s){
        try{
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement  st = con.createStatement();
            String q="insert into ReportTable values("+s+")";
            System.out.println(q);
           st.executeUpdate(q);
           con.setAutoCommit(true);
           con.close();
           System.out.println("Values inserted");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
      static void createBusTable(){
        try{
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement  st = con.createStatement();
            String q="create table BusTable(name varchar(5),driver varchar(25),seats varchar(10),destination varchar(25),mor varchar(5),eve varchar(5),fees varchar(10),fill varchar(10))";
            int t=st.executeUpdate(q);
            System.err.println("Success: "+t);
            con.setAutoCommit(true);
            con.close();
            System.out.println("Table created");
        }
        catch(Exception e){
             System.out.println(e);
        }
    }
    static void insertvalues(String s){
        try{
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement  st = con.createStatement();
            String q="insert into BusTable values("+s+")";
            System.out.println(q);
           int t=st.executeUpdate(q);
           con.setAutoCommit(true);
           con.close();
           System.out.println("Values inserted");
           
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static String[] extractDestinations() throws Exception{
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","xxx","yyy");
        Statement  st = con.createStatement();
        ResultSet rs=st.executeQuery("select distinct destination from bustable");
        ArrayList<String> a=new ArrayList<>();
            a.add("Select");
            while(rs.next()){
            String xx=rs.getString("destination");
            a.add(xx);
            }
            String res[]=new String[a.size()];
            for(int i=0;i<a.size();i++){
                res[i]=a.get(i);
            }
            return res;
    }
    static String[] extractBus(String s) throws Exception{
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","xxx","yyy");
        Statement  st = con.createStatement();
        String q="select name from bustable where destination='"+s+"'";
        ResultSet rs=st.executeQuery(q);
        ArrayList<String> a=new ArrayList<>();
            a.add("Select");
            while(rs.next()){
            String xx=rs.getString("name");
            a.add(xx);
            }
            String res[]=new String[a.size()];
            for(int i=0;i<a.size();i++){
                res[i]=a.get(i);
            }
            return res;
    }
    static String extractFees(String s) throws Exception{
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","xxx","yyy");
        Statement  st = con.createStatement();
        String q="select fees from bustable where name='"+s+"'";
        ResultSet rs=st.executeQuery(q);
        rs.next();
        return rs.getString("fees");
    }
    static public void createtable(){
        try{          
        Class.forName("oracle.jdbc.driver.OracleDriver"); 
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
        Statement st=con.createStatement();
        String q="create table StudentDetails(name varchar2(20),rollno varchar2(15),mail varchar2(50),pw varchar2(15),bus varchar2(10),mob varchar2(10),dest varchar2(15),fees varchar2(10),paid varchar2(10))";
        int t=st.executeUpdate(q);
        con.setAutoCommit(true);
        System.out.println("Success or not: "+t);       
        con.close();}
        catch(Exception e){System.out.println(e);}
    }   
    static public void insertusertab(String[] ss){
        try{
            System.out.println("Hello SQL");
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            String q1="insert into StudentDetails values('"+ss[0]+"','"+ss[1]+"','"+ss[2]+"','"+ss[3]+"','"+ss[4]+"','"+ss[5]+"','"+ss[6]+"','"+ss[7]+"','"+ss[8]+"')";
            System.out.print(q1);
            int t=st.executeUpdate(q1);
            System.out.println("Sucess or not: "+t);
            System.out.println(Arrays.toString(ss));
            con.setAutoCommit(true);
            con.close();
        }
        catch(Exception e){System.out.println(e);}
    }
    public static String getRepText(String rollno){
        String ss="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from ReportTable where rollno='"+rollno+"'");            
            while(rs.next()){
                ss+=rs.getString("report");
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Report is: "+ss);
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    public static void deleteReport(String roll){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            String query="delete from reporttable where rollno='"+roll+"'";   
            int t=st.executeUpdate(query);
            con.setAutoCommit(true);
            con.close();
            System.out.println("Report Successfully Deleted");
        }
        catch(Exception e){System.out.println(e);}
    }
    public static String getBusNo(String roll){
        String ss="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from reporttable where rollno='"+roll+"'");            
            while(rs.next()){
                ss+=rs.getString("bus")+" ";
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Received Reported Mails: "+ss);
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    public static String getReported(){
        String ss="";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from reporttable");            
            while(rs.next()){
                ss+=rs.getString("rollno")+" ";
            }                                 
            con.setAutoCommit(true);
            con.close();
            System.out.println("Received Reported Mails: "+ss);
        }
        catch(Exception e){System.out.println(e);}
        return ss;
    }
    static boolean checkLogin(String mail,String pass){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","krish","Gokul10");
            Statement st=con.createStatement();
            String query="select rollno from StudentDetails where mail='"+mail+"' and password='"+pass+"'";
            int t=st.executeUpdate(query);
            if(t==1){
                return true;
            }
            System.out.println("Successfully Logged In: "+t);
            return false;
        }
        catch(Exception e){System.out.println(e);}
        return false;
    }
}