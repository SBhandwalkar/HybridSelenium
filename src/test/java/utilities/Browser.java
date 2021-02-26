package utilities;

import java.net.URL;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



import baseTest.ConfigRunner;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends ConfigRunner {

	private static Logger logger=Logger.getLogger("Browser");
	//public static WebDriver wDriver;
	
	



	public static WebDriver openBrowser(String sBrowserName,String sPathOfDriver)
	{
		if(sBrowserName.equalsIgnoreCase("chrome")){
			logger.info("The Browser has been invoked successfully in Google Chrome");
			return openChromeBrowser(sPathOfDriver);
		}
		else if(sBrowserName.equalsIgnoreCase("BrowserStack")){
			
			
			return driver;
		}
		else if(sBrowserName.equalsIgnoreCase("ff")){
			return driver;
		}
		else {

			return driver;
		}	
	}





	private static WebDriver openChromeBrowser(String sPathOfDriver )
	{

		try{
			//System.setProperty("webdriver.chrome.driver",sPathOfDriver);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			logger.info("Chrome browser is opened successfully");
			System.out.println("Chrome browser is opened successfully");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return driver;
	}
	public static WebDriver openBrowserStack(String UserName, String passkey,String OS,String OSVersion,String BrowserName, String sBrowserVersion) 
	{
		String URL = "https://" + UserName + ":" + passkey + "@hub-cloud.browserstack.com/wd/hub";
		
		try {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("os", OS);
			caps.setCapability("os_version", OSVersion);
			caps.setCapability("browser", BrowserName);
			caps.setCapability("browser_version", sBrowserVersion);
			caps.setCapability("browserstack.local", "false");
			//caps.setCapability("browserstack.selenium_version", sSeleniumVersion);

			driver = new RemoteWebDriver(new URL(URL), caps);
			driver.manage().window().maximize();
			System.out.println("Browserstack browser is opened successfully");
			logger.info("Browserstack browser is opened successfully");
			
			//return wDriver;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		return driver;
	}
	





	public static boolean closeCurrentBrowser(WebDriver wDriver)
	{
		try{
			if(wDriver != null)
			{
				String sFocusedWindow = wDriver.getWindowHandle();
				Set<String> windows = wDriver.getWindowHandles();
				int iSize = windows.size();
				if(iSize > 1)
				{
					wDriver.close();
					for (String handle : windows) 
					{
						if(!sFocusedWindow.equalsIgnoreCase(handle))
						{
							wDriver.switchTo().window(handle);
						}
					}
				}	
				wDriver.close();
				logger.info("The current browser has been closed successfully");
				Runtime.getRuntime().exec("taskkill /T /F /IM chromedriver.exe");
				Runtime.getRuntime().exec("taskkill /T /F /IM IEDriverServer.exe");
				Runtime.getRuntime().exec("taskkill /T /F /IM geckodriver.exe");
				return true;
			}
			logger.warn("The current browser could not be closed");
			return false;

		}
		catch(Exception e){

			return false;
		}
	}
	
	
	
	
	public static void navigateBack(WebDriver wDriver)
	{
		wDriver.navigate().back();
		logger.info("Successfully navigated back to previous web page");
	}
	
	public static void navigateForward(WebDriver wDriver)
	{
		wDriver.navigate().forward();
		logger.info("Successfully navigated forward to next web page");
	}
	
	public static void reloadPage(WebDriver wDriver)
	{
		wDriver.navigate().refresh();
		logger.info("The web page has been refreshed");
	}

	public static void deleteAllCookies(WebDriver wDriver)
	{
		wDriver.manage().deleteAllCookies();
		logger.info("Successfully deleted all the browser cookies");
	}
	
	public static void deleteCookie(WebDriver wDriver, String sCookieName)
	{
		wDriver.manage().deleteCookieNamed(sCookieName);
		logger.info("Successfully deleted the browser cookie"+sCookieName);
	}
	
	public static String getCurrentURL()
	{
		return driver.getCurrentUrl();
	}
	
	public static void navigateTo(WebDriver wDriver,String sUrl)
    {
           wDriver.navigate().to(sUrl);;
           logger.info("Successfully navigated to  web page");
    }
	
	public static void getUrl(WebDriver wDriver,String sUrl)
    {
           wDriver.get(sUrl);;
           logger.info("Successfully oepned the  web page");
    }

}
