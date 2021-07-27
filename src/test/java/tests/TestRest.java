package tests;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestRest {

    @Test
    public void getData(){
        given()
                .baseUri("https://swapi.dev/api")
                .basePath("/starships/9")
                .contentType(ContentType.JSON)
                .when().get()
                .then()
                .statusCode(200)
                .body("name", equalTo("Death Star"));
    }

}
