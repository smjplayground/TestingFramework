package baseTest;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import utils.ExtentReportListener;
import utils.FileandEnv;

public class BaseTest extends ExtentReportListener {
	
	@Test
	public void utilsTest()
	{
		test.log(LogStatus.INFO, "Starting Test");
		//test.log(LogStatus.PASS,"test Pass");
		System.out.println(FileandEnv.envAndFile().get("ServerUrl"));
	}
}
