package PostReqTest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.io.File;

public class PostReqUsingJSONFileTest {

	@Test
	public void postDataToServer() {

		File fileobj = new File("./projt.json");

		given().contentType(ContentType.JSON)
		.body(fileobj)
		.when().post("http://49.249.29.6:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();

	}
}
