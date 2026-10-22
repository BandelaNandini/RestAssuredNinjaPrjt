package HRM_CrudOperationWithoutBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PutDataTest {

	@Test
	public void completeModification() {

		JSONObject jsobj = new JSONObject();

		// Here we have to give entire data and modification data also
//		bcz it removes entire old data and gives new updated data as we are using put
		jsobj.put("createdBy", "Tom");
		jsobj.put("projectName", "Ninja_Tom");
		jsobj.put("status", "Created");
		jsobj.put("teamSize", 10);

//		If we use only updated data i.e., jsobj.put("projectName", "Ninja_Tom");
//		it will remove created by,status and teamsize i.e., complete modification

		Response res = given().contentType(ContentType.JSON).body(jsobj.toJSONString())
				.put("http://49.249.29.6:8084/projects/TY_PROJ_1596");
		res.then().log().all();

		// As we are inserting data it should be successfull msg do code is 200
		res.then().assertThat().statusCode(200);
	}

}
