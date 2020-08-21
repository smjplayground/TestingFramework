package studentApiTest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.PostAPIPojo;
import utils.JavaUtils;

public class PostAPITest extends BaseTest {

	@Test
	public void validPostAPITest()
	{
		test.log(LogStatus.INFO, "Test Starting...");
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();
		Response response = RestAssured.given().when().headers(header.defaultHeaders()).body(builder.postRequestBody(JavaUtils.randomNumber(), JavaUtils.randomString(), JavaUtils.randomString())).when().post(APIPath.apiPath.CREATE_POST);
		APIVerification.responseKeyValidationFromJsonObject(response, "title");
		APIVerification.responseCodeValidation(response, 201);
		//System.out.println(response.getBody().asString());
		test.log(LogStatus.INFO, "Test Ended...");
	}
	
	@Test
	public void testUsingSer()
	{
		HeaderConfigs header = new HeaderConfigs();
		PostAPIPojo pojo = new PostAPIPojo(JavaUtils.randomNumberInt(), JavaUtils.randomString(), JavaUtils.randomString());
		Response response = RestAssured.given().when().headers(header.defaultHeaders()).body(pojo).when().post(APIPath.apiPath.CREATE_POST);
		APIVerification.responseCodeValidationWithoutCatch(response, 200);
		//System.out.println("Pojo: "+ response.getBody().asString());
	}
	
}
