package objectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageNFR_Search {

	WebDriver driver;
	
	By dropdown =By.xpath("//mat-icon[contains(text(),'keyboard_arrow_down ')]");
	
	By fname=By.xpath("//input[@data-placeholder='First name']");
	By lname =By.xpath("//input[@data-placeholder='Last name']");
	By id =By.xpath("//input[@data-placeholder='ID Document']");
	By search =By.xpath("//span[contains(text(),'search')]");
	
	//Run time xpath Creation
	public By result(String strResult) {
	By result =By.xpath("//span[contains(text(),'"+strResult+"')]");
	return result;
	}
	
	By actions =By.xpath("//span[text()='Actions']");
	By pointop =By.xpath("//span[text()='Points Operations']");
	By pointcorrec =By.xpath("//button[text()=' Points Correction ']");
	
	By ammount=By.xpath("//input[@data-placeholder='Amount']");
	By pointtype =By.xpath("//span[text()='Point type']");
	By mainpoints =By.xpath("//mat-option//span[text()='Main Points']");
	By process =By.xpath("//span[text()='Process']");
	
	By closeicon =By.xpath("//mat-icon[@svgicon='cc:CANCEL_REVERSE']//*[@fill='none']");
	
	By totalpoints =By.xpath("//item-info[contains(text(),'Main Points')]//..//following-sibling::div");
	By identifier =By.xpath("//item-info[contains(text(),'Main identifier')]//..//following-sibling::div");
	
	
	
	
	
	
		
	
	
	
	
	public PageNFR_Search(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver=driver;
	}

	
	public  WebElement getdropdown()
	{
		return driver.findElement(dropdown);
	}
	
	public  WebElement getfname()
	{
		return driver.findElement(fname);
	}
	
	public  WebElement getlname()
	{
		return driver.findElement(lname);
	}
	
	public  WebElement getId()
	{
		return driver.findElement(id);
	}
	
	public  WebElement getsearch()
	{
		return driver.findElement(search);
		
		
	}
	
	public  WebElement getresult(String strResult)
	{
		return driver.findElement(result(strResult));
	}
	
	public  WebElement getaction()
	{
		return driver.findElement(actions);
	}
	
	
	public  WebElement getpointop()
	{
		return driver.findElement(pointop);
	}
	
	public  WebElement getpointcorrc()
	{
		return driver.findElement(pointcorrec);
	}
	
	public  WebElement getammount()
	{
		return driver.findElement(ammount);
	}
	
	public  WebElement getpointtype()
	{
		return driver.findElement(pointtype);
	}
	
	
	public  WebElement getmainpoint()
	{
		return driver.findElement(mainpoints);
	}
	
	
	public  WebElement getprocess()
	{
		return driver.findElement(process);
	}
	
	public List< WebElement> getcloseicon()
	{
		return driver.findElements(closeicon);
	}
	
	public  WebElement gettotalpoints()
	{
		return driver.findElement(totalpoints);
	}
	
	
	public  WebElement getidentifier()
	{
		return driver.findElement(identifier);
	}
	
	
	
	






}
