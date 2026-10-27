package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoUtility.EmployeePojoUtility;
import PojoUtility.ProjPojoClassTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Scenario3_GetPayRollInfoTest {

	@Test
	public void payroll_ReqChainingTest() {

		// API -02 WITHOUT AUTHENTICATION
		// Sample execution of payroll without using authentication
		// We dont access to payroll
//		given().get("http://49.249.29.6:8084/admin/payrolls").then().log().all();
		// This execution actually gives 401 status code i.e., Unauthorized

		// API 01 get Auth --> Token --> AUTH protocol
		// Before giving API we have give some pre conditions [formparam]
		// Get the formparam from developer
		// example : auth protocol --> info :
		// clientid,clientsecret,granttype,redirecturl
		// By using this it will check whether you are a valid user if valid it will
		// some token[otp] so that we can execute api
		Response resp = given().formParam("client_id", "ninza-client")
				.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
				.formParam("grant_type", "client_credentials")
				// Here we have only get api in swagger but use post as we are giving api to
				// fetch the token
				// Here Post will return 200 [as it used for creation usually it return 201]
//		.when().get("http://49.249.29.6:8084/login").then().log().all();

				.when().post("http://49.249.29.6:8084/auth/realms/ninza/protocol/openid-connect/token");
		resp.then().log().all();

		// Capture the token from the reponse
		String token = resp.jsonPath().get("access_token");

		// API -02 WITH AUTHENTICATION
		// We dont access to payroll
		given().auth().oauth2(token).get("http://49.249.29.6:8084/admin/payrolls").then().log().all();

	}

}
