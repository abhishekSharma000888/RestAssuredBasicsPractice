package ex_06_TestAssertions;

import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
//import io.qameta.allure.SeverityLevel;

public class APITesting025_RestAsssured_Assertions {

    //assertion is used to validate the expected vs actual result

    /* Types of Assertions
    1. status code assertion
    2. response body assertion
    3. header assertions.
    4. response time assertions.
    5. Cookie and Session assertions.
    6. Schema validation assertions.
     */
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;


    @Owner("Abhishek")
//    @Severity(SeverityLevel.CRITICAL)

    @Description("TC#1 - Verify that the Create Booking is working fine, booking ID is not null")
    @Test
    public void test_createBooking_POST(){

        // String Payload
        String payload = "{\n" +
                "    \"firstname\" : \"Abhishek\",\n" +
                "    \"lastname\" : \"Sharma\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        // Rest Assured.
        validatableResponse.statusCode(200);

        // firstname == Abhishek , Last Name = Sharma
        // Booking ID shouldn't null


        validatableResponse.body("booking.firstname", Matchers.equalTo("Abhishek"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Sharma"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(true));
        validatableResponse.body("bookingid",Matchers.notNullValue());


    }
}
