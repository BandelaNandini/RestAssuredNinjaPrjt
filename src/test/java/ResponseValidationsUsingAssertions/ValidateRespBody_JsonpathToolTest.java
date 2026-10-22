package ResponseValidationsUsingAssertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class ValidateRespBody_JsonpathToolTest {

	@Test
	public void validateRespBody() {

		// endpoint --> Instead of projects-paginated they have changed to project1
		Response resp = given().get("http://49.249.29.6:8084/projects1");

		resp.then().log().all();

		resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().assertThat().body("empty", Matchers.equalTo(false));
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("TY_PROJ_1233"));

		
		//To fetch all the project ids like findelements using json path
//		https://www.site24x7.com/tools/json-path-evaluator.html
		
		//Here * will not work i.e., the disadvantage of json path
//		ArrayList<String>  ids=resp.jsonPath().get("content[*].projectId");
//		System.out.println(ids);
		
		//So instead we remove * just give "content.projectId"
		ArrayList<String>  ids=resp.jsonPath().get("content.projectId");
		System.out.println(ids);
		
		ArrayList<String>  pnames=resp.jsonPath().get("content.projectName");
		System.out.println(pnames);
	}
}
