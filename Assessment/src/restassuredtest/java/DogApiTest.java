package restassuredtest.java;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;
import static io.restassured.RestAssured.given;

/**
 * Unit test for simple App.
 */
public class DogApiTest
{
    /**
     * Rigorous Test :-)
     */
    //@Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

   // @Test
    public void test_getAllDogs()
    {
        given()

                .when()
                    .get("https://dog.ceo/api/breeds/list/all")
                .then()
                    .statusCode(200);
    }

    //Returning random image and confirming the message
    //@Test
    public void test_getRandomDog()
    {
        Response res =
        given()

                .when()
                    .get("https://dog.ceo/api/breeds/image/random")
                .then()
                    .statusCode(200)
                    .log().body()
                    //.statusLine("Success");
                    .extract().response();
        String jsonString = res.asString();
        Assert.assertEquals(jsonString.contains("success"),true);

    }

    @Test
    public void test_getBulldogInAllBreeds()
    {

                given()

                        .when()
                        .get("https://dog.ceo/api/breeds/list/all")
                        .then()
                        .statusCode(200)
                        .log().body()
                        .body("message", hasItemInArray("bulldog=[]"));
                        //.body("message",hasItemInArray("bulldog") );

    }
}
