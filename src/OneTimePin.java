/** 
 * Provides one time pin function to FNB app
*/
import java.util.*;

public class OneTimePin{
    void OneTimePin(){

    }

    /**Random Generator for the OTP  */
    private char[] generateOTP( int len ){
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return otp;
    }

    /** Communicate with Notification */
    private void sendOTP(){

    }

    /** Communicate with ATM */
   bool verifyOTP(OTP obj)
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
        else if(obj.otp==null)//otp not entered and so is null
            {
               obj.status=false;
              obj.statusMsg="Time Period Expired";
            }
          else if(obj.otp!=otpcode)// otp code not the code sent
                {
                      obj.status=false;
                      obj.statusMsg="Incorrect OTP";
                }
    
   \\edit audit log accordingly
  }

    public String getAuthenticationStatus(){

    }
}
public class OTPclient{
        String clientID;
        boolean status;
        String statusMsg;
        String otp=null; 
    }
