import java.util.LinkedList; 
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import 

public class OneTimePin extends OTP{
  String otpcode;
  OTP node=new otp();
  node.otp="12345";
  
  void OneTimePin(){
    
  }
  void generateOTP(){}
  
  sendOTP(){}
  
  bool verifyOTP()
  {
          System.out.println("Waiting for input...");
          
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println();
          TimeUnit.SECONDS.sleep(5);
          //recieves OTP obj
         
        System.out.println("OTP from ATM recieved. Attempting verification.");
        if(obj.otp==otpcode)//otp verified
        {
          obj.status=true;
          obj.statusMsg="Verification Successful";
        }
        else if(obj.otp==null)//otp 
            {
               obj.status=false;
              obj.statusMsg="Time Period Expired";
            }
          else if(obj.otp!=otpcode)
                {
                      obj.status=false;
                      obj.statusMsg="Incorrect OTP";
                }
    
   \\edit audit log accordingly
  }
  
  
}
 public class OTP{
      
        String clientID;
        boolean status;
        String statusMsg;
        String otp=null;
        
          
        
    }
