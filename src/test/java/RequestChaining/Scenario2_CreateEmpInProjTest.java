package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import PojoUtility.EmployeePojoUtility;
import PojoUtility.ProjPojoClassTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Scenario2_CreateEmpInProjTest {

	@Test
	public void createEmp_ReqChainingTest() {

//		Response response=given().when()
//		.get("http://49.249.29.6:8084/login");
//		response.then().log().all();
		// Generate random number
		Random random = new Random();
		int rnum = random.nextInt(1000);

//	API 01 -->	 Using pojo class create a project
		ProjPojoClassTest projpojo = new ProjPojoClassTest("Ninja_reqChain" + rnum + "", 10, "created", "jerry");

		Response resp = given().contentType(ContentType.JSON).body(projpojo).when()
				.post("http://49.249.29.6:8084/addProject");
		resp.then().assertThat().statusCode(201).and().assertThat().body("msg", Matchers.equalTo("Successfully Added"))
				.log().all();

		// Capture project name from the response
		String projectName = resp.jsonPath().get("projectName");
		System.out.println(projectName);

		// API 02 --> Add an employee to the project [get the format from empapi's
		// endpoits execution]
//	empPojo(String designation, String dob[check the format in schema], String email, String empName, double experience, String mobileNo,
//				String project, String role[DD - get from schema], String username) 

		EmployeePojoUtility employeepojo = new EmployeePojoUtility("Testeng", "24/04/1989", "tom@gmail.com",
				"tom_" + rnum, 4, "9876543210", projectName, "ROLE_EMPLOYEE", "tom_" + rnum);

		given().auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJybWd5YW50cmEiLCJleHAiOjE3OTM2NjE4OTksImlhdCI6MTc5MzYyNTg5OX0.kQDqbKJ_N1RGOUCEOS1G_XXjwguNNaNDfsrooZuOvHg").contentType(ContentType.JSON).body(employeepojo).when().post("http://49.249.29.6:8084/employees").then().log().all();
//				.assertThat().statusCode(201).log().all();
	}

}
