package resources;

//enum is special class in java which has collection of constants or  methods
//The APIResources class is an enum in Java used to represent different API endpoints along with their corresponding resource path
//This code demonstrates how to use the APIResources enum to access the resource paths for different API endpoints. When you run this code, it will print out the resource paths for each API endpoint:
//By using this enum, you can ensure type safety and avoid hardcoding API endpoint paths throughout your codebase. If the API paths ever change, you only need to update the enum definitions, and the changes will be reflected throughout your code.

public enum APIResources {
	
	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}

//Output
//AddPlaceAPI resource: /maps/api/place/add/json
//GetPlaceAPI resource: /maps/api/place/get/json
//DeletePlaceAPI resource: /maps/api/place/delete/json

