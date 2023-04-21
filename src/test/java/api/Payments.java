package api;

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
    /**
     *  Creates payment_transaction json object from PaymentTransaction POJO class
     */
    static PaymentTransaction payment_transaction = new PaymentTransaction(new PaymentTransaction__1(
            "4200000000000000",
            "123",
            "06/2019",
            "500",
            "Coffeemaker",
            "sale",
            "Panda Panda",
            "panda@example.com",
            "Panda Street, China"));

    /**
     * Sends POST request to the configured endpoint with Basic authentication. Expects status code 200
     */
    public static void validTransaction() {

        given()
                .auth().basic(user, pass)
                .body(payment_transaction)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(200);
    }

    /** /
     * Sends POST request to the configured endpoint with Basic authentication to make a transaction.
     * Get the value of "unique_id" key from the json response.
     * Sends POST request to the configured endpoint with Basic authentication to void the transaction above.
     * Asserts the parameters json response below
     * @param key the key from the json response that has to be asserted
     * @param value the expected value of the key above that has to be asserted
     */
    public static void voidTransaction(String key, String value) {

        Response response =
                given()
                        .auth().basic(user, pass)
                        .body(payment_transaction)
                        .when()
                        .post(endpoint);
        response
                .then();
        PaymentResponse responseJson = response.getBody().as(PaymentResponse.class);
                uniqueId = responseJson.getUnique_id();

        VoidTransaction void_transaction = new VoidTransaction(new VoidTransaction__1(
                uniqueId,
                "void"));
                given()
                .auth().basic(user, pass)
                .body(void_transaction)
                .when()
                .post(endpoint)
                .then().body(key, equalTo(value));

    }

    /** Sends POST request to the configured endpoint with valid username and blank password for Basic authentication.
     * Expects status code 401
     *
     */
    public static void invalidAuthentication() {
        given()
                .auth().basic(user, "")
                .body(payment_transaction)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(401);
    }

    /**
     * Sends POST request to the configured endpoint with Basic authentication and blank "reference_id" key to void the transaction above.
     * Expects status code 422
     */

    public static void nonExistingId() {
        VoidTransaction void_transaction = new VoidTransaction(new VoidTransaction__1(
                "",
                "void"));
        given()
                .auth().basic(user, pass)
                .body(void_transaction)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(422);
    }
/**
 * Sends POST request to the configured endpoint with Basic authentication to make a transaction.
 * Get the value of "unique_id" key from the json response.
 * Sends POST request to the configured endpoint with Basic authentication to void the transaction above.
 * Sends again the same POST request
 * Expects status code 422
 */
    public static void existingVoidTransaction() {
        Response response =
                given()
                        .auth().basic(user, pass)
                        .body(payment_transaction)
                        .when()
                        .post(endpoint);
        response
                .then();
        PaymentResponse responseJson = response.getBody().as(PaymentResponse.class);
        uniqueId = responseJson.getUnique_id();

        VoidTransaction void_transaction = new VoidTransaction(new VoidTransaction__1(
                uniqueId,
                "void"));
        Response voidResponse =
                given()
                        .auth().basic(user, pass)
                        .body(void_transaction)
                        .when()
                        .post(endpoint);
        voidResponse
                .then();
        VoidResponse voidJson = voidResponse.getBody().as(VoidResponse.class);
        voidUniqueId = voidJson.getUnique_id();
        given()
                .auth().basic(user, pass)
                .body(void_transaction)
                .when()
                .post(endpoint)
                .then()
                .assertThat().statusCode(422);
    }
}

