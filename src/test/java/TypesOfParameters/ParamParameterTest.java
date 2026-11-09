package TypesOfParameters;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

public class ParamParameterTest {

	@Test
	public void sampleQuery() throws IOException {

		// Param parameter acts as both query and form parameter
		// when used with get acts query parameter and when used with post acts as a
		// form parameter

		given().param("projectId", "TY_PROJ_1919").log().all()

				.when().get("http://49.249.29.6:8084/projects");

		// To avoid huge response data
//		resp.then().log().all();

	}
}
