package AuthenticationAndAuthorizationTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PreEmptiveAuthTest {

	@Test
	public void sampleBATest() {
		given()
		.relaxedHTTPSValidation().auth()
		.preemptive().basic("rohithlakkapaka@gmail.com", "Rohith@4444")
		.log().all()
		.when().get("https://www.shoppersstack.com/shopping/users/login");

	}

}
