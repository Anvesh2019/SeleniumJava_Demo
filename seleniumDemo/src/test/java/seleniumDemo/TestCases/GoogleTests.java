package seleniumDemo.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.clsCommon;
import seleniumDemo.Pages.GooglePage;


import dev.failsafe.internal.util.Assert;

public class GoogleTests 
{
	WebDriver dr = new ChromeDriver();
	clsCommon _common=new clsCommon();
	GooglePage googlePage=new GooglePage(dr);
	
	@Test
	public void OpenGoogle() 
	{
		dr.get("https://google.com/");
	}
	
@Test
public void SearchGoogle() 
{
	
	
	googlePage.NavigateToGoogle();
	_common.SendKeysByName(dr, "q", "Selenium WebDriver");
	//googlePage.txtSrch().sendKeys("Selenium WebDriver");
	googlePage.txtSrch().submit();
	
	
}
@Test
public void ClickGmailLink() 
{
	
	googlePage.NavigateToGoogle();
	//_common.ClickonElement(dr, By.linkText("Gmail"));
	googlePage.linkGmail().click();
}

}