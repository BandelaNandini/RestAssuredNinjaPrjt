package HRM_CrudOperationWithoutBDDTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ReadDataTest {

	@Test
	public void getDataFromServer() {

		// To get in json format used baseurl+get end point
		Response res = get("http://49.249.29.6:8084/projects");
//		 res.prettyPrint();

		// To get it in string format
//		String res = get("http://49.249.29.6:8084/projects").asString();
//		System.out.println(res);

		// To give basic validations
		// If we give 201 validation fails and 200 it will pass
//	as	the request got status code as 200 --> successful
		res.then().assertThat().statusCode(200);

		// To see logs with the status code
		res.then().log().all();

	}
}
