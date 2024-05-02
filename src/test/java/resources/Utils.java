package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	//The Utils class contains utility methods for setting up request specifications and extracting values from JSON responses.
	//Here's a breakdown of the class:

	public static RequestSpecification req;
	//requestSpecification(): This method sets up the request specification using RestAssured. It initializes a RequestSpecBuilder, sets the base URI to a global value obtained from getGlobalValue(),
	//adds query parameters, logging filters for request and response, sets content type to JSON, and builds the request specification. It returns the request specification.
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(getGlobalValue( )).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
		
		
	}
	
	
	/*
	 * public static String getGlobalValue(String key) throws IOException {
	 * Properties prop =new Properties(); FileInputStream fis =new FileInputStream(
	 * "C:\\Users\\Dell\\eclipse-workspace\\RestAssuredPractice\\src\\test\\java\\resources"
	 * ); prop.load(fis); return prop.getProperty(key);
	 * 
	 * 
	 * 
	 * }
	 */
	
	 public static String getGlobalValue() {
	        return "https://rahulshettyacademy.com";
	        //getGlobalValue(): This method returns the base URI for the API requests. Currently, it returns a hardcoded value "https://rahulshettyacademy.com". 
	        //You can modify this method to read the base URI from a properties file or any other configuration source if needed.
	    }
	
	public String getJsonPath(Response response,String key)
	{
		//This method extracts a value from the JSON response using the specified key. It converts the response to a string, creates a JsonPath object,
		//and retrieves the value corresponding to the given key.
		
		  String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get(key).toString();
	}
}
