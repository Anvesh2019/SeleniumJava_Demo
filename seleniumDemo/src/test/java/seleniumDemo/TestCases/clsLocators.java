package seleniumDemo.TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class clsLocators 
{

	@Test
	public void LearnLocators()
	{
		
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.google.com/");
		//WebElement txtSearch=dr.findElement(By.name("q"));
		WebElement txtSearch=dr.findElement(By.id("ti6dpd"));
		txtSearch.sendKeys("Selenium WebDriver");
		txtSearch.submit();
		//dr.quit();
	}
	@Test
	public void LearnCssSelector() throws InterruptedException
	{
		
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.google.com/");
		WebElement txtSearch=dr.findElement(By.cssSelector("textarea[name='q']"));
		txtSearch.sendKeys("Selenium WebDriver");
		txtSearch.submit();
		Thread.sleep(2000);
		Assert.assertTrue(dr.getCurrentUrl().contains("q=Selenium+WebDriver"), "URL does not contain expected text");
		Assert.assertTrue(dr.getTitle().contains("Selenium WebDriver"), "Page title does not match expected value");
	    dr.close();
	}
	@Test
	public void LearnLinktext() throws InterruptedException
	{
		
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.google.com/");
		
		WebElement linkGmail=dr.findElement(By.linkText("Gmail"));
		linkGmail.click();
		Thread.sleep(2000);
		Assert.assertTrue(dr.getCurrentUrl().contains("gmail"), "URL does not contain expected text");
		Assert.assertTrue(dr.getTitle().contains("Gmail"), "Page title does not match expected value");
	    dr.close();
	}
	@Test
	public void LearnPartialLinktext() throws InterruptedException
	{
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.techtutorialz.com/");
		WebElement linkInterviewQuestions=dr.findElement(By.partialLinkText("Interview"));
		linkInterviewQuestions.click();
	}
	@Test
	public void LearnXpath() throws InterruptedException
	{
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.google.com/");
		WebElement txtSrch=dr.findElement(By.xpath("//textarea[@id='ti6dpd']"));
		
		//textarea[@class='gLFyf']
		//textarea[@name='q']
		txtSrch.sendKeys("India");
	}
	
}
