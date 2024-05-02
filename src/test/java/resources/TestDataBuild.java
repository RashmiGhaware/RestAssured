package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	//The TestDataBuild class is a utility class for generating payloads to be used in testing APIs related to place management. 
	//It provides methods to create payloads for adding a place (addPlacePayLoad()) and deleting a place (deletePlacePayload()).
	//deletePlacePayload(String placeId): This method generates a JSON string representing the payload for deleting a place with the specified place ID. It returns the JSON string.

	
	
	public AddPlace addPlacePayLoad(String name, String language, String address)
	{
		//addPlacePayLoad(String name, String language, String address): This method creates an AddPlace object with the specified name, language, and address, 
		//along with some predefined values for other fields such as accuracy, phone number, website, and types. It returns the constructed AddPlace object.

		AddPlace p =new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName(name);
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
		//deletePlacePayload(String placeId): This method generates a JSON string representing the payload for deleting a place with the specified place ID. 
		//It returns the JSON string
	}
}


