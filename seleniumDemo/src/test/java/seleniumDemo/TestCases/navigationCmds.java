package seleniumDemo.TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class navigationCmds 
{
	private String city="Hyderabad";
	WebDriver dr = new ChromeDriver();
@Test
	public void NavigateCommands() 
	{
		
		dr.navigate().to("https://www.google.com/");
		dr.navigate().to("https://www.bing.com/");
		dr.navigate().back();
		dr.navigate().forward();
		dr.navigate().refresh();
		//dr.quit();
		dr.get("https://www.google.com/");
	}
@Test
public void getTileandURL()
{
	System.out.println("my city is: " + city);
	dr.get("https://www.google.com/");
	System.out.println("Page Title: " + dr.getTitle());
	Assert.assertEquals(dr.getTitle(), "Google");
	System.out.println("Current URL: " + dr.getCurrentUrl());
	dr.get("https://www.bing.com/");
	//Assert.assertEquals(dr.getCurrentUrl(), "https://www.google.com/"); //hard assertion
	if(dr.getCurrentUrl()=="https://www.google.com/") //soft assertion
	{
		System.out.println("URL is correct");
	}
	else
	{
		System.out.println("URL is incorrect");
	}
	dr.close();
}
}
