package endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EndPoints {

    public static Response doGetRequest(String sEndPoint) {
        //GET THE RESPONE AND VALIDATE THE STATUS CODE

        RestAssured.defaultParser = Parser.JSON;
        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(sEndPoint).
                        then().assertThat().statusCode(200).
                        contentType(ContentType.JSON).extract().response();
    }
}
