package testCases;

import java.util.concurrent.TimeUnit;
import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.PageNFR_Login;
import objectRepository.PageNFR_Search;
import utilities.ExcelHandler;

public class NFR_Verification {

	private static String TestData_path= "TestData\\NFR_Users.xlsx";
	private static String sheetName="NFRUsers";
	private static String fName,lName,stotalpoint,sidentifier,id;
	private static List<WebElement> closeicon;


	@Test
	public static void VerifyNFR() throws Exception
	{



		try {


			WebDriverManager.chromedriver().setup();


			WebDriver driver =new ChromeDriver();
			driver.get("https://web.comarch.nfr.za.omlac.net/clm-cc/#/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			PageNFR_Login pN= new PageNFR_Login(driver);





			pN.getUsername().sendKeys("XY58278");
			pN.getPassword().sendKeys("Password@123");
			pN.getSubmit().click();

			ExcelHandler.setExcelFile(TestData_path,sheetName);
			int iRowCount = ExcelHandler.getRowNum();
			PageNFR_Search pS=new PageNFR_Search(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			
		

			pS.getdropdown().click();

			
			js.executeScript("arguments[0].scrollIntoView(true);",pS.getfname());
		
			for(int iRowCounter=1;iRowCounter<=iRowCount;iRowCounter++)
			{
				fName=ExcelHandler.getCellData(iRowCounter, 2);
				lName=ExcelHandler.getCellData(iRowCounter, 3);
				id=ExcelHandler.getCellData(iRowCounter, 7);

				

				Thread.sleep(5000);
			

				pS.getfname().clear();
				pS.getfname().sendKeys(fName);
				pS.getlname().sendKeys(lName);
				pS.getId().sendKeys(id);
				pS.getsearch().click();
				Thread.sleep(5000);
				pS.getresult(fName.toUpperCase()+" " +lName.toUpperCase()).click();
				try 
				{
					pS.getaction().click();
				}
				catch(Exception e)
				{
					pS.getaction().click();
				}

				pS.getpointop().click();
				pS.getpointcorrc().click();
				pS.getammount().sendKeys("10000");



				pS.getpointtype().click();
				js.executeScript("arguments[0].scrollIntoView(true);",pS.getmainpoint());
				Thread.sleep(5000);
				pS.getmainpoint().click();

				pS.getprocess().click();
				
				Thread.sleep(5000);
				stotalpoint=pS.gettotalpoints().getText();
				sidentifier=pS.getidentifier().getText();
				
				
				ExcelHandler.setCellData( "Pass",iRowCounter,4);
				ExcelHandler.setCellData( stotalpoint,iRowCounter,5);
				ExcelHandler.setCellData( sidentifier,iRowCounter,6);

				driver.get("https://web.comarch.nfr.za.omlac.net/clm-cc/#/accounts/find");

				closeicon= pS.getcloseicon();

				for(int i=0;i<closeicon.size();i++) {


					closeicon.get(i).click();
				}

				pS.getdropdown().click();

				
				js.executeScript("arguments[0].scrollIntoView(true);",pS.getfname());
			}
			
			ExcelHandler.closeexcel(TestData_path);



		}

		catch(Exception e)
		{
			ExcelHandler.closeexcel(TestData_path);
		}
		
		finally
		{
			ExcelHandler.closeexcel(TestData_path);
		}

	}

//}

}
