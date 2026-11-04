package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoUtility.EmployeePojoUtility;
import PojoUtility.ProjPojoClassTest;
import PojoUtility.SS_LoginPojoUtility;
import PojoUtility.SS_UserPojoUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario4_BearerTokenUsingSS {

	@Test
	public void login_ReqChainingTest() {

		// Generate random number
		Random random = new Random();
		int rnum = random.nextInt(1000);


		SS_UserPojoUtility spojo = new SS_UserPojoUtility("Hyderabad", "India", "tom" + rnum + "@gmail.com", "tom",
				"FEMALE", "sam", "tom@123", 9876543213l, "Telangana", "ALPHA");

		Response resp = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(spojo).when()
				.post("https://www.shoppersstack.com/shopping/shoppers");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201).and().assertThat().contentType(ContentType.JSON).body("message",
				Matchers.equalTo("Created"));

		String userid = resp.jsonPath().getString("data.userId");
		System.out.println(userid);

		SS_LoginPojoUtility slpojo = new SS_LoginPojoUtility("tom"+rnum+".gmail.com", "tom@123", "ADMIN");

		Response Lresp = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(slpojo).when()
				.post("https://www.shoppersstack.com/shopping/users/login");
		Lresp.then().log().all();
	}

}
