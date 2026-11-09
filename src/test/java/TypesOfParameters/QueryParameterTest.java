package TypesOfParameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class QueryParameterTest {

	@Test
	public void sampleQuery() throws IOException {

//		 QP is used given a query[comes after resource with '?'] 
//		where it fetches multiple set of data
//		[as it is fetching we use only get api]
//		Response resp = given().queryParam("teamSize", 10)

		// Trail 02
		//If we use this query parameter in header we are getting the data of our query
		given().queryParam("teamSize", 10).log().all()

//		 After ? if we give projectid as path parameter it fetches Same as path parameter
//		but it is used to search specific data using filters
//		.when().get("http://49.249.29.6:8084/projects?projectId=TY_PROJ_1919");

//		 If we give teamsize=10 then it filters
//		.when().get("http://49.249.29.6:8084/projects?teamSize=10");

//		 Now dont hardcode the data we use query parameter
			.when().get("http://49.249.29.6:8084/project");
//		.then().log().all();


	}

}
