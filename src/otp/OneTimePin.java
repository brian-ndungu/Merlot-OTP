/** 
 * Provides one time pin function to FNB app
*/
import java.util.*;

public class OneTimePin{

    void OneTimePin(){

    }

    /**Random Generator for the OTP  */
    public char[] generateOTP( int len ){
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
    private void verifyOTP(){

    }

    public String getAuthenticationStatus(){
        return "";
    }
}