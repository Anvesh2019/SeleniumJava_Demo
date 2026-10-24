package seleniumDemo.TestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class clsHandlingCookies 
{

	@Test
	public void ReadAllCookies()
	{
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
       
		Cookie cookie1 = new Cookie("username", "anvesh");
		driver.manage().addCookie(cookie1);
		
		//driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("username");
        Set<Cookie> cookies = driver.manage().getCookies();

        System.out.println("Total Cookies: " + cookies.size());
        
        for (Cookie cookie : cookies) {
            System.out.println("Name: " + cookie.getName());
            System.out.println("Value: " + cookie.getValue());
            System.out.println("Domain: " + cookie.getDomain());
            System.out.println("Path: " + cookie.getPath());
            System.out.println("Expiry: " + cookie.getExpiry());
            System.out.println("----------------------");
        }

        driver.quit();

	}
	@Test
	public void AddCookie()
	{
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");

		Cookie cookie = new Cookie("username", "anvesh");
		driver.manage().addCookie(cookie);

		Set<Cookie> cookies = driver.manage().getCookies();

		for (Cookie c : cookies) {
			System.out.println("Name: " + c.getName());
			System.out.println("Value: " + c.getValue());
			System.out.println("----------------------");
		}
		
		driver.quit();
	}
}
