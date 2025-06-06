package ex_04_RestAssured_HTTP_Methods.GET;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class APITesting008_GET_BDDStyle {

    @Test
    public void test_GET_Positive(){
        String pin_code = "388620";

                given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pin_code)
                .when()
                .log()
                .all()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

}
