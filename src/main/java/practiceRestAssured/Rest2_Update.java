package practiceRestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;



public class Rest2_Update {
	
	public static void main (String [] args )
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
        String putResponse = given()
                .log().all()
                .queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\r\n" +
                        "\"place_id\":\"0760439582b42e74b3116e3f2c5024a6\",\r\n" +
                        "\"address\":\"70 Summer walk, USA\",\r\n" +
                        "\"key\":\"qaclick123\"\r\n" +
                        "}\r\n"
                        + "")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        System.out.println(putResponse);
		
	}

}
