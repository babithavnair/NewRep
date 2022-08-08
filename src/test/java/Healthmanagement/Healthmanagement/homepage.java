package Healthmanagement.Healthmanagement;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class homepage {

	WebDriver ldriver;
	
	public homepage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		

	@FindBy(id="image-4-45696")
	WebElement imageid;
	@FindBy(id="text_block-387-45900")
	WebElement blockid;
	
	@FindBy(xpath="//a[contains(.,'Healthcare Success')]")

	WebElement branding;
	@FindBy(xpath="(//a[contains(.,'Services')])[1]")

	WebElement service;
	
	
	
	public void homepageavailable()
	{
		Boolean t=imageid.isDisplayed();
		if(t==true)
		{
			assertTrue(true,"page loaded");
			
		}
		}
	
	
	public void brandelement()
	{
	Boolean b=service.isDisplayed();
	
	{	if(b==true)
		service.click();
		//Select drp = new Select(branding);
		//drp.selectByVisibleText("Branding");
	Actions action = new Actions(ldriver);

	//Performing the mouse hover action on the target element.
	action.moveToElement(branding).click();
	System.out.println("clicked");
	boolean g=imageid.isDisplayed();
	if (g==true)
	{
		assertTrue(true, "page loaded correctly");
		//branding.click();
	}
	else
	{
		assertTrue(false, "page not loaded correctly");
		
		
	}
	}
	}
}
	
	
	