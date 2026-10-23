package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoUtility.ProjPojoClassTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario1_DeleteProjTest {

	@Test
	public void deleteProj_ReqChainingTest() {

		// Generate random number
		Random random = new Random();
		int rnum = random.nextInt(1000);

//	API 01 -->	 Using pojo class create a project
		ProjPojoClassTest projpojo = new ProjPojoClassTest("Ninja_reqChain" + rnum + "", 10, "created", "jerry");

		Response resp = given().contentType(ContentType.JSON).body(projpojo).when()
				.post("http://49.249.29.6:8084/addProject");
		resp.then().assertThat().statusCode(201).and().assertThat().body("msg", Matchers.equalTo("Successfully Added"))
				.log().all();

		// Capture projectid[Using id only we can delete the proj] from the response
		String projectId = resp.jsonPath().get("projectId");
		System.out.println(projectId);

		// API 02 --> Delete the project
		given().delete("http://49.249.29.6:8084/projects/" + projectId).then().log().all();
	}

}
