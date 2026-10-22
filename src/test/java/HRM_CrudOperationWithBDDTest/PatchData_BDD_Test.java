package HRM_CrudOperationWithBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PatchData_BDD_Test {

	@Test
	public void partialModification() {

		JSONObject jsobj = new JSONObject();

		// Now we can use only one data which has to be updated as we are using patch()

		jsobj.put("projectName", "Ninja_dora");

		given().contentType(ContentType.JSON).body(jsobj.toJSONString()).when()
				.patch("http://49.249.29.6:8084/projects/TY_PROJ_1598").then().log().all().assertThat().statusCode(200);
	}

}
