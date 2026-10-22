package HRM_CrudOperationWithoutBDDTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PostDataTest {

	@Test
	public void postDataToServer() {

		// Create obj of jsonobj from json.simple package
		JSONObject json = new JSONObject();

		// Get the project model from swagger and use put()
//		createdBy	string
//		projectName	string
//		status	    string
//						allowEmptyValue: false
//						Status Values Can Be = “On Going","Completed","Created”
//		teamSize	integer($int32)

		json.put("createdBy", "Tom");
		json.put("projectName", "hrm_002");
		json.put("status", "Created");
		json.put("teamSize", 0);

		// From RestAssured we are calling given method
		// This is used to create the project in the appln
		RequestSpecification req = given();
		// Set the content type to json
		req.contentType(ContentType.JSON);
		// Then give body to the req in json obj format --> converted to string
		req.body(json.toJSONString());

		// Then the given data has to be posted using post() --> given new data to database
//		Make sure endpoint is given properly
		Response resp = req.when().post("http://49.249.29.6:8084/addProject");

		// print resp logs and validate
		resp.then().log().all();
		// 201-> created
		resp.then().assertThat().statusCode(201);

//		Response res=given().contentType(ContentType.JSON).body(json.toJSONString()).post("http://49.249.29.6:8084/addProject");
//		res.then().log().all();
	}
}
