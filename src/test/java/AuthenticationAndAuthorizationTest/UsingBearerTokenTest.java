package AuthenticationAndAuthorizationTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UsingBearerTokenTest {
	
	@Test
	public void tokenAuthTest()
	{
		//Api 01 login and fetch the bearer token
		Response resp = given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when().get("http://49.249.29.6:8084/login");
		resp.then().log().all();
		
		String token=resp.jsonPath().get("jwtToken");
		
		//Fetch all the projects using bearer token
		
		given()
		.auth().oauth2(token)
		.when().get("http://49.249.29.6:8084/projects").then().log().all();
		
		
		
	}

}
