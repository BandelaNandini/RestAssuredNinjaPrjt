package ResponseValidationsUsingAssertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidateTimeRespTest {

	@Test
	public void validateHeader() {

		Response resp = given().get("http://49.249.29.6:8084/projects");
		resp.then().log().all();

		resp.then().assertThat().statusCode(200);

		// To get in milli seconds
		long time = resp.time();
		System.out.println("Time taken in millisec : " + time);

		// To get in sec
		long timesec = resp.timeIn(TimeUnit.SECONDS);
		System.out.println("Time taken in sec : " + timesec);

		// To give an assertion i.e., time should be less than
		resp.then().assertThat().time(Matchers.lessThan(900L));

		// To give an assertion i.e., time should be greater than
		resp.then().assertThat().time(Matchers.greaterThan(300L));

		// To give both the conditions
//		ValidatableResponse timeboth = resp.then().assertThat()
//				.time(Matchers.both(Matchers.lessThan(900L)).and(Matchers.greaterThan(300L)));

//		System.out.println(timeboth.toString()); //address is printed

		resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900L))
				.and(Matchers.greaterThan(300L)));
	}

}
