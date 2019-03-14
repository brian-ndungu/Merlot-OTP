import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class OTP {

    public static void main(String[] args) {
        OTP test = new OTP();

        test.sendAuthenticationStatus("123", "Success", "Success");
    }

    public void sendAuthenticationStatus(String clientID, String status, String statusMessage) {
        /*
            Construction of the JSON object will be done here to be sent back to
            the authentication module to determine whether the client ID and the appropriate
            OTP are a match
            Possible encryption could be performed on variables within the JSON object with a dual key system to
            avoid interception to authentication module.
        */

        String[] JSONObject = {clientID,
                status,
                statusMessage};
        for (int i = 0; i < JSONObject.length; i++) {
            System.out.println(JSONObject[i]);
        }
        /*
            The status of the verification that will be sent to the authentication subsystem will be
            added to the audit logs with a time and dat or the success/failure
         */
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String filename = "auditLog.txt";
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter(filename,true));
            output.write(format.format(date) + " " + statusMessage);
            output.close();
        } catch (IOException e) {
            System.out.println("Exception occurred " + e);
        }
    }
}
