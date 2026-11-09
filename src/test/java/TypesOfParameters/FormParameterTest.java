package TypesOfParameters;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

public class FormParameterTest {

	@Test
	public void sampleQuery() throws IOException {

		// Form param is same as query parameter
//		But for QP we get query parameter in request so can be hacked so i want to put in body [that can be encrypted]
		// as we want in body we have to use post req bcz get will not have body
		// show any search in google to show query param
		//In auth client id and client secret is also passed in form parameter 
		given().formParam("teamSize", 10).log().all()

				.when().post("http://49.249.29.6:8084/projects").then().log().all();

	}

}
