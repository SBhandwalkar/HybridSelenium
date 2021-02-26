package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Elements;

public class PageNPW_Home {
	
	WebDriver driver;

	
	By headerMenu=By.xpath("//om-main-navigation-menu[@slot='main-navigation-items-desktop']//ul[@slot='navigation-menu']//li//a");
	By footerMenu =By.xpath("//*[@class='theme-default om-footer-container']//a");
	By omicon=By.xpath("//div[contains(@class,'desktop')]//om-icon[@icon-name='old_mutual_logo']");
	
	
	
	
	public PageNPW_Home(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
	}

	public List<WebElement> getHeaderMenu()
	{
		//return Elements.getWebElements(headerMenu);
		return driver.findElements(headerMenu);
	}
	
	public List<WebElement> getFooterMenu()
	{
		return Elements.getWebElements(footerMenu);
	}
	
	public WebElement getOmIcon()
	{
		
		return driver.findElement(omicon);
	}

}
