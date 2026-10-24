package seleniumDemo.TestCases;

import openqa.selenium;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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

public class clsBrowserOptions {
	WebDriver dr;

	@BeforeTest
	public void setup() throws IOException {
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications"); // Disable browser notifications
		 //options.addArguments("--start-maximized"); // Start the browser maximized
		 options.addArguments("--incognito"); // Open the browser in incognito mode
		 //options.addArguments("--headless");
		// Create a new instance of the ChromeDriver
		// Disable notifications
		options.addArguments("--disable-notifications");

		// Disable popups
		options.addArguments("--disable-popup-blocking");

		// Start with specific window size
		options.addArguments("--window-size=800,1000");

		// Ignore SSL certificate errors
		// options.addArguments("--ignore-certificate-errors"
		dr = new ChromeDriver(options);

	}

	@Test
	public void LearnBrowserOptions() throws InterruptedException {

		// Navigate to a website
		dr.get("https://www.google.com");
        //dr.manage().window().maximize();
		// Perform any additional actions or assertions as needed
           Thread.sleep(5000); // Wait for 5 seconds to observe the browser behavior
		
	}

	@Test
	public void OpenGoogle() {
		dr.get("https://google.com/");
	}

	@Test(enabled = false)
	public void OpenAmazon() {
		dr.get("https://amazon.in/");

	}

	@AfterTest
	public void tearDown() 
	{
		dr.quit(); // Close the browser after the test
	}
}