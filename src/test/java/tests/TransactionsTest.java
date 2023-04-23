package tests;
import api.Payments;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.annotations.BeforeClass;
import utils.TestConfig;
import org.testng.annotations.Test;





public class TransactionsTest extends TestConfig {

    @BeforeClass
    public static void setup() {
        TestConfig.setup();
    }

    @Test
    public static void validPaymentTransaction() {
        Payments.validPaymentTransaction();
    }

    @Test
    public static void voidPaymentTransaction() throws JsonProcessingException {

        Payments.voidPaymentTransaction("message", "Your transaction has been voided successfully");
    }

    @Test
    public static void invalidAuthentication() {
        Payments.invalidAuthentication();
    }

    @Test
    public static void nonExistingId() throws JsonProcessingException {
        Payments.nonExistingId();
    }

    @Test
    public void voidExistingVoidTransaction() throws JsonProcessingException {
        Payments.existingVoidTransaction();
    }
}
