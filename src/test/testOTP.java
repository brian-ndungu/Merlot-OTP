import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;

public class testOTP {

    @Test
    public void testOTPgenerator(){
        OneTimePin obj = new OneTimePin();

        //Test that otp generates of the given length..
        assertEquals(4,obj.generateOTP(4).length ,"The size of the otp must be equal to that specified.");

        //Test that otp consist of only digits ........
    }
}