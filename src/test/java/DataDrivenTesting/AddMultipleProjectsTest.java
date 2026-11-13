package DataDrivenTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddMultipleProjectsTest {

	@Test(dataProvider = "data")
	public void addProjectTest(String prjtname, String prjtstatus) {
//		String pname = "GooglePrjt5678";
//		String status = "Created";

		String pname = prjtname;
		String status = prjtstatus;
		String reqbody = "{\r\n" + "  \"createdBy\": \"Tom\",\r\n" + "  \"projectName\": \"" + pname + "\",\r\n"
				+ "  \"status\": \"" + status + "\",\r\n" + "  \"teamSize\": 0\r\n" + "}";

		given().contentType(ContentType.JSON).body(reqbody).when().post("http://49.249.29.6:8084/addProject").then()
				.log().all();
	}

	@DataProvider
	public Object[][] data() {
		Object[][] obj = new Object[3][2];

		obj[0][0] = "RestPrjt01";
		obj[0][1] = "Created";

		obj[1][0] = "RestPrjt02";
		obj[1][1] = "Created";

		obj[2][0] = "RestPrjt03";
		obj[2][1] = "Created";

		return obj;
	}
}
