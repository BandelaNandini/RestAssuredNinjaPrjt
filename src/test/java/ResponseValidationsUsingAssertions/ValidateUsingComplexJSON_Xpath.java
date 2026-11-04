package ResponseValidationsUsingAssertions;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class ValidateUsingComplexJSON_Xpath {

	@Test
	public void verifyDataTest() {

		Response resp = given().get("http://49.249.29.6:8084/projects1");

		// Complete response
		resp.then().log().all();

		// complex Jsonxpath
		// Convert resp to string using asString()
		List<String> projlist = JsonPath.read(resp.asString(), "content[*].projectName");
		System.out.println(projlist);

		// Capture data using some condition like print prjtid if projName is this
		List<String> listprojid = JsonPath.read(resp.asString(),
				"content[*].[?(@.projectName=='Organization1')].projectId");
		
		String actorjtid=listprojid.get(0);
		System.out.println(actorjtid);
		
		//TestNg Assertion
		Assert.assertEquals(actorjtid, "TY_PROJ_1240");

		for (String s : listprojid) {
			System.out.println(s);
		}
	}
}
