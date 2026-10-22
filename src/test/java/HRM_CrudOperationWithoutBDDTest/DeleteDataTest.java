package HRM_CrudOperationWithoutBDDTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteDataTest {

	@Test
	public void getDataFromServer() {

		Response res = delete("http://49.249.29.6:8084/projects/TY_PROJ_1595");

//		We got status code as 204 --> successfully deleted no content
		res.then().assertThat().statusCode(204);

		// To see logs with the status code
		res.then().log().all();

	}
}
