package ResponseValidationsUsingAssertions;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class VerifyDataUsingComplexJSON_Xpath {

	@Test
	public void verifyDataTest() {

		Response resp = given().get("http://49.249.29.6:8084/projects1");

		//Complete response
		resp.then().log().all();

		// complex Jsonxpath
		// Convert resp to string using asString()
		List<String> projlist = JsonPath.read(resp.asString(), "content[*].projectName");
		System.out.println(projlist);
		// Output :
		// ["OrangeHrm_111","AAABBB63117","Airtel1124","Airtel840","Organization1","JavaPys","Zencartopia_1202","FireFlink_57670","FireFlink_70444","FireFlink_62196","FireFlink_88127","AAABBB6344","AAABBB61570","AAABBB61747","Vodafone_03","Vodafone_04","AppleTree","OrangeTree","OrangeHRM","OrangeHRM2574"]

		for (String s : projlist) {
			System.out.println(s);
		}

		//Output : 
//		OrangeHrm_111
//		AAABBB63117
//		Airtel1124
//		Airtel840
//		Organization1
//		JavaPys
//		Zencartopia_1202
//		FireFlink_57670
//		FireFlink_70444
//		FireFlink_62196
//		FireFlink_88127
//		AAABBB6344
//		AAABBB61570
//		AAABBB61747
//		Vodafone_03
//		Vodafone_04
//		AppleTree
//		OrangeTree
//		OrangeHRM
//		OrangeHRM2574
	}
}
