package practiceRestAssured;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import static org.hamcrest.Matchers.*;

import org.apache.http.util.Asserts;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

public class Rest1_Post {

	public static void main(String[] args) {
		  RestAssured.baseURI = "https://rahulshettyacademy.com/";
		    String response = given()
		            .log().all()
		            .queryParam("key", "qaclick123")
		            .header("Content-Type", "application/json")
		            .body("{\r\n" +
		                    "    \"location\": {\r\n" +
		                    "        \"lat\": -38.383494,\r\n" +
		                    "        \"lng\": 33.427362\r\n" +
		                    "    },\r\n" +
		                    "    \"accuracy\": 50,\r\n" +
		                    "    \"name\": \"Frontline house\",\r\n" +
		                    "    \"phone_number\": \"(+91) 983 893 3937\",\r\n" +
		                    "    \"address\": \"29, side layout, cohen 09\",\r\n" +
		                    "    \"types\": [\r\n" +
		                    "        \"shoe park\",\r\n" +
		                    "        \"shop\"\r\n" +
		                    "    ],\r\n" +
		                    "    \"website\": \"http://google.com\",\r\n" +
		                    "    \"language\": \"French-IN\"\r\n" +
		                    "}")
		            .when()
		            .post("maps/api/place/add/json?key=qaclick123")
		            .then()
		            .assertThat()
		            .statusCode(200)
		            .body("scope", equalTo("APP"))
		            .header("Server", "Apache/2.4.52 (Ubuntu)")
		            .extract().response().asString();
		    System.out.println(response);
		    JsonPath js=new JsonPath(response);
		    String placeId=js.getString("place_id");
		    System.out.println(placeId);
		//-------------------------------------------------   
		    RestAssured.baseURI = "https://rahulshettyacademy.com";
	        String putResponse = given()
	                .log().all()
	                .queryParam("key", "qaclick123")
	                .header("Content-Type", "application/json")
	                .body("{\r\n" +
	                        "\"place_id\":\""+placeId+"\",\r\n" +
	                        "\"address\":\"70 Summer walk, USA\",\r\n" +
	                        "\"key\":\"qaclick123\"\r\n" +
	                        "}\r\n"
	                        + "")
	                .when().put("/maps/api/place/update/json")
	                .then().assertThat().statusCode(200)
	                .extract().response().asString();
	        System.out.println(putResponse);
	        //----------------------------------------------
	        
	        RestAssured.baseURI="https://rahulshettyacademy.com";
	      String getResponse=given().log().all().queryParam("key", "qaclick123")
	        .queryParam("place_id", placeId)
	        .when().get("/maps/api/place/get/json")
	        .then().assertThat().statusCode(200)
	        .extract().response().asString();
	      
	      JsonPath js1= new JsonPath(getResponse);
	    		  String actualAddress=js1.getString("address");
	    		  System.out.println(actualAddress);
	    		  Assert.assertEquals(actualAddress, "70 Summer walk, USA");
	   
	    		  //---------------------------------------------------------------
		

	}
}



