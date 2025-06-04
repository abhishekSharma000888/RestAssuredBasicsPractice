package ex_01_ra_basics;

import static io.restassured.RestAssured.*;

public class APITesting_Lab01_RA {
    public static void main(String[] args) {
        given()  // No need for RestAssured. prefix when using static import
                .baseUri("https://restful-booker.herokuapp.com")
                .when()
                .get("/ping")  // Moved endpoint path here
                .then()
                .log().all()
                .statusCode(201);  // This endpoint returns 201, not 200
    }
}