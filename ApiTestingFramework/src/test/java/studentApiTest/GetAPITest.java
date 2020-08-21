package studentApiTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPITest extends BaseTest{
	
	@Test
	public void getAPITest()
	{	
		test.log(LogStatus.INFO, "Test starting..");
		//RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_USERS).then().log().all();
		Response response = RestAssured.given().when().get(APIPath.apiPath.GET_LIST_OF_USERS);
		//Assert.assertEquals(2, 3);
		APIVerification.responseCodeValidation(response, 400);
		test.log(LogStatus.INFO,"Test end");
	}

}
