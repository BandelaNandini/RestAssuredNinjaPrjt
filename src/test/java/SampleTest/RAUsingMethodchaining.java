package SampleTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
//import io.restassured.response.Response;

public class RAUsingMethodchaining {
	
	@Test
	public void demoResReq()
	{
		//Without using method chaining and static import
//		Response res = RestAssured.get("https://reqres.in/api/users/2");
//		System.out.println(res.prettyPrint());
		
		//Without using static import using method chaining
//		RestAssured.get("https://reqres.in/api/users/2").prettyPrint();
		
		//Using static import and method chaining
		//It prints logs and body
		get("https://reqres.in/api/users/2").then().log().all();
		
	}

}
