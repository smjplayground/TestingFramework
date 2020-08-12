package baseTest;

import org.testng.annotations.Test;

import utils.FileandEnv;

public class BaseTest {
	
	@Test
	public void utilsTest()
	{
		System.out.println(FileandEnv.envAndFile());
	}
}
