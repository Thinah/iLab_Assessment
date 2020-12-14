package restassuredtest.java;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;


public class petstore {



	/**
	 * Unit test for simple App.
	 */
	
	    /**
	     * Rigorous Test :-)
	     */
	    //@Test
	    public void shouldAnswerWithTrue()
	    {
	        assertTrue( true );
	    }

	   // @Test
	    public void test_RetrieveDoggie()
	    {
	        given()

	                .when()
	                    .get("https://dog.ceo/api/breeds/list/all")
	                .then()
	                    .statusCode(200);
	    }

	    //Returning random image and confirming the message
	    //@Test
	    public void test_AddNewDog()
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
	    public void test_Created_Pet()
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

	

}
