package ResponseValidationsUsingAssertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidateRespBody_JsonpathTest {

	@Test
	public void validateRespBody() {

		// endpoint --> Instead of projects-paginated they have changed to project1
		Response resp = given().get("http://49.249.29.6:8084/projects1");

		resp.then().log().all();

		int projpagenum = resp.jsonPath().get("numberOfElements");
		System.out.println("Project num of elements : " + projpagenum);

		boolean data = resp.jsonPath().get("empty");
		System.out.println(data);

		boolean data2 = resp.jsonPath().get("pageable.sort.unsorted");
		System.out.println(data2);

		String projid = resp.jsonPath().get("content[0].projectId");
		System.out.println(projid);

		// Now to validate data again we have to go for TestNG assertions
		// Instead we can go for restassured assertthat()

		resp.then().assertThat().body("numberOfElements", Matchers.greaterThanOrEqualTo(20));
		resp.then().assertThat().body("empty", Matchers.equalTo(false));
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("TY_PROJ_1233"));

	}
}
