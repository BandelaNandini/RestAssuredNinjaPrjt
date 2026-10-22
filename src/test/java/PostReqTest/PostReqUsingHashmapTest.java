package PostReqTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class PostReqUsingHashmapTest {

	@Test
	public void postDataToServer() {

		HashMap<String, Object> hmap = new HashMap<String, Object>();

		hmap.put("createdBy", "Jerry");
		hmap.put("projectName", "Ninja_Hashmap");
		hmap.put("status", "Created");
		hmap.put("teamSize", 7);

		given().contentType(ContentType.JSON).body(hmap).when().post("http://49.249.29.6:8084/addProject").then()
				.assertThat().statusCode(201).log().all();

	}
}
