package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;



public class TestConfig {
    /**
     * Setups Base URI, Port, Content Type and Header
     */
    public static void setup(){

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost")
                .setPort(3001)
                .setContentType("application/json")
                .addHeader("Accept", "application/json")
                .addFilter(new RequestLoggingFilter())
                .build();

    }
}
