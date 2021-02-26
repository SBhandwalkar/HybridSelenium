package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageNFR_Login {
	
	
	WebDriver driver;
	
	By username=By.xpath("//input[@data-placeholder='Username']");
	By password =By.xpath("//input[@data-placeholder='Password']");
	By submit =By.cssSelector("button[type='submit']");
	
	
	public PageNFR_Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
	}

	public  WebElement getUsername()
	{
		return driver.findElement(username);
	}
	
	public  WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public  WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	
	

}
