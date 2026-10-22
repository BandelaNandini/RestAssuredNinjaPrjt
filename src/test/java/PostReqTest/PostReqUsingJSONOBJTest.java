package PostReqTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PostReqUsingJSONOBJTest {

	@Test
	public void postDataToServer() {

		// Create obj of jsonobj from json.simple package
		JSONObject json = new JSONObject();

		json.put("createdBy", "Jerry");
		json.put("projectName", "Ninja_Jerry2");
		json.put("status", "Created");
		json.put("teamSize", 7);

		given().contentType(ContentType.JSON).body(json.toJSONString()).when()
				.post("http://49.249.29.6:8084/addProject").then().assertThat().statusCode(201).log().all();

	}
}
