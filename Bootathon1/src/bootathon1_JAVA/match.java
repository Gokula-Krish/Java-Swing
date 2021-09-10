package bootathon1_JAVA;
import java.util.regex.Pattern;
public class match{
    public static boolean checkName(String s){
        if(s.length()==0)
            return false;
        String p="^[A-Z][a-zA-Z ]{2,20}$";
        return p.matches(s);
    }
    public static boolean checkPhone(String ph){
        if(ph.length()==0){
            return false;
        }
        String pat="^[6-9][0-9]{9}$";
        return Pattern.matches(pat,ph);
    }
    public static boolean checkMail(String mail){
        if(mail.length()==0){
            return false;
        }
        String pat="^[A-Za-z0-9+_.-]+@(.+)$";
        return Pattern.matches(pat,mail);
    }
    public static boolean checkPassword(String pass){
        if(pass.length()==0){
            return false;
        }
        String pat="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
        return Pattern.matches(pat,pass);
    }
    public static boolean checkFees(String f,String p){
        if(p.length()==0)
            return false;
        int allot=Integer.valueOf(f);
        int paid=Integer.valueOf(p);
        if(paid>=allot/2)
            return true;
        return false;    
    }
    public static boolean checkValid(String seat){
        if(seat.length()==0)
            return false;
        try{
        int x=Integer.parseInt(seat);
        if(x>0)
            return true;
        else
            return false;
        } 
        catch (Exception ex){
          return false;
        }   
    }
    public static boolean checkTime(String time){
        if(time.length()==0)
            return false;
        String p="^(0?[1-9]|1[0-2]):[0-5][0-9]$";  //"^[6-9][0-9]{9}$"
        return time.matches(p);
    }
    public static boolean checkBus(String name){
        if(name.length()==0)
            return false;
        String p="^[0-9]([a-z]|[A-Z])$";
        return name.matches(p);
    }
}