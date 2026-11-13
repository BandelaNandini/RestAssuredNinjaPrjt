package DataDrivenTesting;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import io.restassured.http.ContentType;

public class CreateProjectsUsingExcelData {

	@Test(dataProvider = "projectsFromExcel")
	public void createProjects_Excel_DPTest(String prjtname, String prjtstatus) {
		String pname = prjtname;
		String status = prjtstatus;
		String reqbody = "{\r\n" + "  \"createdBy\": \"Tom\",\r\n" + "  \"projectName\": \"" + pname + "\",\r\n"
				+ "  \"status\": \"" + status + "\",\r\n" + "  \"teamSize\": 0\r\n" + "}";

		given().contentType(ContentType.JSON).body(reqbody).when().post("http://49.249.29.6:8084/addProject").then()
				.log().all();
	}

	@DataProvider
	public Object[][] projectsFromExcel() throws EncryptedDocumentException, IOException {
		ExcelFileUtility eutil = new ExcelFileUtility();
		int count = eutil.getRowCountInSheet("project");

		Object[][] obj = new Object[count][2];

		for (int i = 0; i < count; i++) {
			obj[i][0] = eutil.fetchDataFromExcel("project", i + 1, 0);
			obj[i][1] = eutil.fetchDataFromExcel("project", i + 1, 1);
		}

		return obj;
	}
}
