package stepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.PageNFR_Login;


@RunWith(cucumber.api.junit.Cucumber.class)
public class LoginSetps {
	
	public static WebDriver driver;
	
	
	@Given("^User is on login page$")
	public static void user_is_on_login_page()
	{
		System.out.println("Login Page");
		
		WebDriverManager.chromedriver().setup();


		driver =new ChromeDriver();
		driver.get("https://web.comarch.nfr.za.omlac.net/clm-cc/#/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@When("User enters {string} and {string}")
	public static void user_enters_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		PageNFR_Login pN= new PageNFR_Login(driver);





		pN.getUsername().sendKeys(string);
		pN.getPassword().sendKeys(string2);
		pN.getSubmit().click();

		System.out.println(string);
		System.out.println(string2);
		
	}

	@Then("^User gets logged into application$")
	public static void user_on_login_page()
	{
		System.out.println("Logged In");
	}


}
