package ex_03_TestNG_AllureReport;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class APITesting_Lab06_TestCase {

    String pincode = "110048";

    @Test
    public void test_GET_POSITIVE_TC1() {
        pincode = "110048";

                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }

    @Test
    public void test_GET_NEGATIVE_TC2() {
        pincode = "@";

                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);
    }

    @Test
    public void test_GET_NEGATIVE_TC3() {
        pincode = " ";
                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/USA/" + pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

    }
}
