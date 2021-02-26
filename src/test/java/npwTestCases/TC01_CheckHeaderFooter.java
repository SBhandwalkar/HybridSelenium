package npwTestCases;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



import baseTest.ConfigRunner;
import io.restassured.response.Response;
import objectRepository.PageNPW_Home;
import utilities.Browser;
import utilities.ExcelHandler;

public class TC01_CheckHeaderFooter extends ConfigRunner {

	private static String TestData_path= "TestData\\NPW_SmokePack_TestData.xlsx";
	private static String sheetName="Sites";
	private static String sUrl;
	private static List<WebElement> headerLinks;
	private static String sHeaderUrl;


	@Test
	public static void CheckHerderFooter() throws Exception
	{



		try {
			ExcelHandler.setExcelFile(TestData_path,sheetName);

			int iRowCount = ExcelHandler.getRowNum();
			for(int iRowCounter=1;iRowCounter<=iRowCount;iRowCounter++)
			{
				sUrl=ExcelHandler.getCellData(iRowCounter,0);
				Browser.navigateTo(driver,sUrl);
				PageNPW_Home nhome= new PageNPW_Home(driver);
				headerLinks=nhome.getHeaderMenu();
				//footerLinks=


				for(int i=0;i<headerLinks.size()-1;i++) 
				{
					sHeaderUrl=headerLinks.get(i).getAttribute("href");
					Response res= when().get(sHeaderUrl);
					System.out.println(sHeaderUrl);
					System.out.println(res.getStatusCode());
				}
			}
		}

		catch(Exception e) 
		{

		}




	}

}
