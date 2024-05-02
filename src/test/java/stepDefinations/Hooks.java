package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	//The Hooks class contains Cucumber hooks, which are methods annotated with @Before, @After, etc., and are executed before or after scenarios in your feature files.
	//In this case, the @Before hook is used to execute certain steps before scenarios tagged with @DeletePlace.

	@Before("@DeletePlace")
	//@Before("@DeletePlace"): This annotation indicates that the method should be executed before scenarios tagged with @DeletePlace.
	public void beforeScenario() throws IOException
	{		//execute this code only when place id is null
		//write a code that will give you place id
		
		//beforeScenario(): This method contains the logic to be executed before scenarios tagged with @DeletePlace. It first checks if the place_id is null. If it's null, it creates a new place using the add_Place_Payload_with() method from the StepDefination class.
		//Then it calls the user_calls_with_http_request() method to make a POST request to the AddPlaceAPI, and finally verifies the created place ID using the verify_place_Id_created_maps_to_using() method.
		
		StepDefination m =new StepDefination();
		if(StepDefination.place_id==null)
		{
		
		m.add_Place_Payload_with("Shetty", "French", "Asia");
		m.user_calls_with_http_request("AddPlaceAPI", "POST");
		m.verify_place_Id_created_maps_to_using("Shetty", "getPlaceAPI");
		}
		
		

	}
}
