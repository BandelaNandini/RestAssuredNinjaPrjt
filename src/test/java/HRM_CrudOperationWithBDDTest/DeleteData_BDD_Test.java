package HRM_CrudOperationWithBDDTest;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteData_BDD_Test {

	@Test
	public void getDataFromServer() {

		given().delete("http://49.249.29.6:8084/projects/TY_PROJ_1598")
		.then().assertThat().statusCode(204).log().all();

	}
}
