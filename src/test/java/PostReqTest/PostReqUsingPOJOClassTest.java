package PostReqTest;

import org.testng.annotations.Test;

import PojoUtility.ProjPojoClassTest;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostReqUsingPOJOClassTest {

	@Test
	public void postDataToServer() {

//		 Create an obj of pojo
//		 We go for pojo class to give dynamic data in run time
//		For dynamic data we can use Random number from java

		Random random = new Random();
		int rnum = random.nextInt(1000);
		ProjPojoClassTest projpojo = new ProjPojoClassTest("Ninja_pojo" + rnum + "", 10, "created", "jerry");

		given().contentType(ContentType.JSON).body(projpojo).when().post("http://49.249.29.6:8084/addProject").then()
				.assertThat().statusCode(201).log().all();

	}
}
