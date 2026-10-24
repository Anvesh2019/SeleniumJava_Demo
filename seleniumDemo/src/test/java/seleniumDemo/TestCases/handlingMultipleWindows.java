package seleniumDemo.TestCases;
import org.testng.annotations.Test;
import openqa.selenium;
import java.util.Properties;
import java.util.Set;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class handlingMultipleWindows 
{

	@Test
	public void HandleMultipleWindows() throws InterruptedException
	{
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		System.out.println("main Window Title: " + dr.getTitle());
		dr.switchTo().frame("iframeResult");
		dr.findElement(By.xpath("//button[text()='Try it']")).click();
		
		String mainWindowHandle = dr.getWindowHandle();
		
		System.out.println("Main Window Handle: " + mainWindowHandle);
		
		/*
		for (String handle : dr.getWindowHandles()) 
		{
			if (!handle.equals(mainWindowHandle)) 
			{
				dr.switchTo().window(handle);
				System.out.println("Switched to new window.");
				System.out.println("New Window Title: " + dr.getTitle());
				dr.close(); // Close the new window
				System.out.println("New window closed.");
			}
		}*/
		
	Set<String> listHandles=	dr.getWindowHandles();
	System.out.println("Number of windows opened: "+listHandles.size());
	dr.switchTo().window(listHandles.toArray()[1].toString()); //2nd window handle
	System.out.println("New Window Title: " + dr.getTitle());
	dr.close();
		dr.switchTo().window(mainWindowHandle); //1st window handle
		System.out.println("Switched back to main window.");
		System.out.println("Main Window Title: " + dr.getTitle());
		
		dr.quit();
	}
	@Test
	public void HandleMultipleWindows1() throws InterruptedException
	{
		long Starttime=System.currentTimeMillis();
		WebDriver dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		dr.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		
		dr.switchTo().frame("iframeResult");
		//dr.findElement(By.xpath("//button[text()='Try it']")).click();
		
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

		WebElement btnTryit = wait.until(
		    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Try it']"))
		);
		btnTryit.click();
		
		Set<String> arrHandles= dr.getWindowHandles();
		System.out.println("1st handle: "+arrHandles.toArray()[0].toString());
		System.out.println("2nd handle: "+arrHandles.toArray()[1].toString());
		
		System.out.println("Number of windows opened: "+arrHandles.size());
		dr.switchTo().window(arrHandles.toArray()[1].toString());
		dr.findElement(By.xpath("//a[text()='JAVASCRIPT']")).click();
		dr.switchTo().window(arrHandles.toArray()[0].toString());
		
		dr.get("https://www.google.com");
		long Endtime= System.currentTimeMillis();
		
		 long runTime = (Endtime - Starttime) / 1000;
		 System.out.println("Total time taken to run the test: " + runTime + " seconds");
	}
}
