package seleniumDemo.TestCases;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
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

import Common.clsCommon;


public class clsGetScreenshot 
{
	WebDriver dr;
	boolean isScreenshotEnabled = false; // Flag to track if a screenshot has been taken
@Test
public void LearnGetScreenshot() throws IOException 
{
	try
	{
	 dr = new ChromeDriver();
	 dr.get("https://www.google.com");
	 dr.findElement(By.name("q123")).sendKeys("Selenium WebDriver");
	// Perform any additional actions or assertions as needed
	// Close the browser
	//dr.quit();
//	int x=20;
//		int y=0;
//		int z=x/y;
	}
	catch(Exception ex)
	{
		
		clsCommon objCommon = new clsCommon();
		objCommon.GetScreenshot(isScreenshotEnabled, dr);
		System.out.println("Error: " + ex.getMessage());
	}
}
}