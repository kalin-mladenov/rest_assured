package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;
import pojo.*;
import utils.ConfigFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Payments {

    static String user = ConfigFile.getUserName();
    static String pass = ConfigFile.getPassword();
    static String endpoint = ConfigFile.getEndpoint();

    static String uniqueId;
    static String voidUniqueId;
    static String paymentTransaction;

    /**
     * Creates paymentTransaction json object from PaymentTransaction POJO class
     */

    static PaymentTransaction payment = new PaymentTransaction(
            "4200000000000000",
            "123",
            "06/2019",
            "500",
            "Coffeemaker",
            "sale",
            "Panda Panda",
            "panda@example.com",
            "Panda Street, China"
    );
    static ObjectMapper mapper = new ObjectMapper();


    static {
        try {
            paymentTransaction = mapper.enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(payment);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Sends POST request to the configured endpoint with Basic authentication. Expects status code 200
     */
    public static PaymentResponse paymentResponse() {


        Response response =
                given()
                        .auth().basic(user, pass)
                        .body(paymentTransaction)
                        .when()
                        .post(endpoint);
        response
                .then();
        return response.getBody().as(PaymentResponse.class);
//        given()
//                .auth().basic(user, pass)
//                .body(paymentTransaction)
//                .when()
//                .post(endpoint)
//                .then()
//                .assertThat().statusCode(200);
    }
    public static void validPaymentTransaction(){
        paymentResponse();
        given().then().body("message", equalTo("Your transaction has been approved."));
    }
    /**
     * /
     * Sends POST request to the configured endpoint with Basic authentication to make a transaction.
     * Get the value of "uniqueId" key from the json response.
     * Sends POST request to the configured endpoint with Basic authentication to void the transaction above.
     * Asserts the parameters json response below
     *
//     * @param key   the key from the json response that has to be asserted
//     * @param value the expected value of the key above that has to be asserted
     */
    public static VoidResponse voidTransactionResponse() throws JsonProcessingException {


                    uniqueId = paymentResponse().getUniqueId();
        ObjectMapper mapper = new ObjectMapper();
                   VoidTransaction voidT = new VoidTransaction(
                uniqueId,
                "void");

        String voidTransaction;
        voidTransaction =  mapper.enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(voidT);
        Response response =
        given()
                .auth().basic(user, pass)
                .body(voidTransaction)
                .when()
                .post(endpoint);
              response
                      .then();

        return response.getBody().as(VoidResponse.class);
//                .then().body(key, equalTo(value));

    }
    public static void voidPaymentTransaction(String key, String value) throws JsonProcessingException {
       voidTransactionResponse();
        given()
        .then().body(key, equalTo(value));
    }

    /**
     * Sends POST request to the configured endpoint with valid username and blank password for Basic authentication.
     * Expects status code 401
     */
    public static void invalidAuthentication() {
        given()
                .auth().basic(user, "")
                .body(paymentTransaction)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(401);
    }

    /**
     * Sends POST request to the configured endpoint with Basic authentication and blank "referenceId" key to void the transaction above.
     * Expects status code 422
     */

    public static void nonExistingId() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        VoidTransaction voidT = new VoidTransaction(
                "",
                "void");

        String nonExistingId;
        nonExistingId =  mapper.enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(voidT);

        given()
                .auth().basic(user, pass)
                .body(nonExistingId)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(422);
    }

    /**
     * Sends POST request to the configured endpoint with Basic authentication to make a transaction.
     * Get the value of "uniqueId" key from the json response.
     * Sends POST request to the configured endpoint with Basic authentication to void the transaction above.
     * Sends again the same POST request
     * Expects status code 422
     */
    public static void existingVoidTransaction() throws JsonProcessingException {

        voidUniqueId = voidTransactionResponse().getUniqueId();
        ObjectMapper mapper = new ObjectMapper();
        VoidTransaction voidT = new VoidTransaction(
                voidUniqueId,
                "void");

        String voidTransaction;
        voidTransaction =  mapper.enable(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(voidT);

                given()
                        .auth().basic(user, pass)
                        .body(voidTransaction)
                        .when()
                        .post(endpoint)

                .then()

                .assertThat().statusCode(422);
    }
}

