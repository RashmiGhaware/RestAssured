package practiceRestAssured;

import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	public static void main(String [] args)
	{
		
			JsonPath js=new JsonPath(Payload.CoursePrice());
			
			int count=js.getInt("courses.size()");
			System.out.println(count);
		
	}

}
