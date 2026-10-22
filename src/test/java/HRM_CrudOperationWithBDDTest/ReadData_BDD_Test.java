package HRM_CrudOperationWithBDDTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ReadData_BDD_Test {

	@Test
	public void getDataFromServer() {

		given().get("http://49.249.29.6:8084/projects").then().assertThat().statusCode(200).log().all();

	}
}
