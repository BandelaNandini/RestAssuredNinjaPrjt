package TypesOfParameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParameter {

	@Test
	public void sampleQuery() {

//		 QP is used given a query[comes after resource with '?'] 
//		where it fetches multiple set of data
//		[as it is fetching we use only get api]

		given()
				.queryParam("designation", "XLrEngineer")
				.when().get("http://49.249.29.6:8084/employees")
				.then().log().all();
	}

}
