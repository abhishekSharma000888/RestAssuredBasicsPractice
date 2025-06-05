package ex_01_ra_basics;

import java.util.Scanner;
import static io.restassured.RestAssured.*;
public class Lab02_RA {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the pincode!");

        String pincode = sc.next();

        given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then().log().all()
                .statusCode(200);
    }
}
