package seleniumDemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
public class GooglePage 
{
    WebDriver driver;
    
	public GooglePage(WebDriver outsidedriver) 
	{
		this.driver = outsidedriver;
		
		
	}
	
	 public WebElement txtSrch() 
	 {
	        return driver.findElement(By.name("q"));
	 }
	 public WebElement linkGmail() 
	 {
	        return driver.findElement(By.linkText("Gmail"));
	 }
	 
	 public void NavigateToGoogle() 
	 {
	        driver.get("https://www.google.com/");
	 }
	 
	 
}
