/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.OTPclient;
import java.io.*; 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
/**
 *
 * @author User
 */
class OTP {
    public String otpcode;
    void OTP(){
        otpcode="";
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
        //edit
    }

    /** Communicate with ATM
     * @param obj */
   public void verifyOTP(OTPclient obj) throws IOException, Exception
  {
          System.out.println("Waiting for input...");
          
          System.out.println();
          System.out.println();
          System.out.println();
          System.out.println();
        try {
            TimeUnit.SECONDS.sleep(5);
            //recieves OTP obj
        } catch (InterruptedException ex) {
            Logger.getLogger(OTP.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        System.out.println("OTP from ATM recieved. Attempting verification.");
        if(otpcode==obj.otp)//otp verified
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
        usingBufferedWritter(obj);//adds info to audit log
        audit();//perform audit log check to push
   //edit audit log accordingly
     //open audit log file
       //enter current date and time
       //enter status update//
        //close file
       //call check function to see if log is full or tie expired
       
       
  }
   public void usingBufferedWritter(OTPclient obj) throws IOException
{
    String date=getDate();
    String fileContent ="<"+date+">"+"<"+obj.clientID+">"+"<"+obj.status+">"+"<"+obj.statusMsg+">"+"<"+obj.otp+">"+"<"+otpcode+">" ;//\t for tab if needed
     
    BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/User/Documents/2019/301/test/test.txt",true));
    writer.write(fileContent);
    writer.close();
}
  public void audit()throws Exception
  {
      int start = 0;
      int end=0;
      String place=null;
      int count=0;
      File file = new File("C:\\Users\\User\\Documents\\2019\\301\\test\\test.txt"); 
       BufferedReader br = new BufferedReader(new FileReader(file)); 
     String st; 
    while ((st = br.readLine()) != null){
        count++;
        if(count ==2)
        {
            start =Integer.parseInt(st.substring(15,17 ));
        }
        place=st;
    }
    end=Integer.parseInt(place.substring(15,17 ));
    //check if file full 
    if(count==50)
    {
        //send to people at reports
        clearTheFile();
    }else//check if time is overdue
    {
        if((end-start)>=15||(end-start)<=0)
        {
            clearTheFile();
        }
    }
    br.close();
   
      
  }
  public static void clearTheFile() throws Exception{
      
      //clears file
        FileWriter fwOb = new FileWriter("C:\\Users\\User\\Documents\\2019\\301\\test\\test.txt", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        
        //adds headers to top of file to understand contents better
        String fileContent="<Date><clientID><Status><StatusMessage><OTP><GenOTP>";
         BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/User/Documents/2019/301/test/test.txt"));
    writer.write(fileContent);
    writer.close();
        
    }
  public String getDate()
  {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
   return dtf.format(now);  
  }

    public String getAuthenticationStatus(){
        return "";
    } 
}
