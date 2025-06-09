package ex_06_TestAssertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class APITesting028_TestNG_AssertJ_Assertions {

    @Test
    public void test_POST() {
        String payload = """
                {
                    "firstname": "Pramod",
                    "lastname": "Dutta",
                    "totalprice": 123,
                    "depositpaid": false,
                    "bookingdates": {
                        "checkin": "2024-01-01",
                        "checkout": "2024-01-01"
                    },
                    "additionalneeds": "Lunch"
                }""";

        Response response = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/booking")
                .contentType(ContentType.JSON)
                .body(payload)
                .log().all()
                .post();

        response.then().log().all().statusCode(200);

        int bookingId = response.path("bookingid");
        String firstname = response.path("booking.firstname");
        String lastname = response.path("booking.lastname");
        boolean depositPaid = response.path("booking.depositpaid");

        // TestNG Assertions
        Assert.assertEquals(firstname, "Pramod");
        Assert.assertEquals(lastname, "Dutta");
        Assert.assertFalse(depositPaid);
        Assert.assertNotNull(bookingId);

        // AssertJ Assertions
        assertThat(bookingId).isPositive().isNotZero();
        assertThat(firstname).isEqualTo("Pramod").isNotBlank().isAlphanumeric();
        assertThat(lastname).isEqualTo("Dutta").isNotBlank().isAlphanumeric();
    }
}
