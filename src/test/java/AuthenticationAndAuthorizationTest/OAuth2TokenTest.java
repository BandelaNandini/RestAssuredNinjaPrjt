package AuthenticationAndAuthorizationTest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OAuth2TokenTest {

	@Test
	public void sampleAuthTest() {
		Response resp = given()
				.formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew50MccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client-credentials").log().all()
				.when().get("http://49.249.29.6:8084/auth/realms/ninza/protocol/openid-connect/token");

	
//		redirecturl --> http://49.249.29.6:8084/auth/realms/ninza/protocol/openid-connect/token

		resp.then().log().all();

		// Fetch data/token from the resp
		String token = resp.jsonPath().getString("access_token");
	}
}
