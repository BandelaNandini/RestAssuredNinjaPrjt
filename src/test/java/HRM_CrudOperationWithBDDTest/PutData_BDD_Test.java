package HRM_CrudOperationWithBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PutData_BDD_Test {

	@Test
	public void completeModification() {

		JSONObject jsobj = new JSONObject();
		jsobj.put("createdBy", "John");
		jsobj.put("projectName", "Ninja_cat");
		jsobj.put("status", "Created");
		jsobj.put("teamSize", 10);

		given().contentType(ContentType.JSON).body(jsobj.toJSONString()).when()
				.put("http://49.249.29.6:8084/projects/TY_PROJ_1598").then().assertThat().statusCode(200).log().all();
	}

}
