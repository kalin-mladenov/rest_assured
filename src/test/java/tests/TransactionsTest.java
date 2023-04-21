package tests;
import api.Payments;
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
        Payments.validTransaction();
    }

    @Test
    public static void voidPaymentTransaction() {
        Payments.voidTransaction("message", "Your transaction has been voided successfully");
    }

    @Test
    public static void invalidAuthentication() {
        Payments.invalidAuthentication();
    }

    @Test
    public static void nonExistingId() {
        Payments.nonExistingId();
    }

    @Test
    public void voidExistingVoidTransaction() {
        Payments.existingVoidTransaction();
    }
}
