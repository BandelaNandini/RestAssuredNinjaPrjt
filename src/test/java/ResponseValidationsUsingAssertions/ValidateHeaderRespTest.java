package ResponseValidationsUsingAssertions;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ValidateHeaderRespTest {

	@Test
	public void validateHeader() {

		Response resp = given().get("http://49.249.29.6:8084/projects");
		resp.then().log().all();

		resp.then().assertThat().statusCode(200);

		resp.then().assertThat().contentType(ContentType.JSON);

		// If there is no method for validation call header and
//		give key and value
		resp.then().assertThat().header("Transfer-Encoding", "chunked");

		resp.then().assertThat().statusLine("HTTP/1.1 200 ");
	}

}
