package HRM_CrudOperationWithoutBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PatchDataTest {

	@Test
	public void partialModification() {

		JSONObject jsobj = new JSONObject();

		// Now we can use only one data which has to be updated as we are using patch()
		jsobj.put("projectName", "Ninja_cat");

		Response res = given().contentType(ContentType.JSON).body(jsobj.toJSONString())
				.patch("http://49.249.29.6:8084/projects/TY_PROJ_1596");
		res.then().log().all();

		// As we are inserting data it should be successfull msg do code is 200
		res.then().assertThat().statusCode(200);
	}

}
