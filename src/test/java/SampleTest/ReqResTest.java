package SampleTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReqResTest {
	
	@Test
	public void getReqTest()
	{
		Response res = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(res.prettyPrint());
	}

}
