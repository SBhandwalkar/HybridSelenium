package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.ConfigRunner;


public class ExtentReportTest extends ConfigRunner {
	
	
	@Test
	public static void checkhomepage()
	{
		
		System.out.println("Home Page");
		driver.get("https://www.oldmutual.co.za/");
		Assert.assertEquals(true, false);
		
		
	}

}
