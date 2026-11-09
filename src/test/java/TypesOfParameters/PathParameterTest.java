package TypesOfParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParameterTest {

	@Test
	public void pathpara() {

		// Path parameter is used to pass the data dynamically instead of hardcoding in the url
		// It is like the resource path to fetch only one set of data
//		[as it is fetching we use only get api]
		//adv : No need to attach the data in url, same can be used for multiple scripts
		
		given().pathParam("projectId", "TY_PROJ_1919")
		.when().get("http://49.249.29.6:8084/projects/{projectId}")
		.then().log().all();
	}

}
