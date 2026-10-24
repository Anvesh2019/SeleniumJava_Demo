package Common;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clsCommon 
{
  
	public void ClickonElement(WebDriver driver, By locator) 
	{
	    WebElement element = driver.findElement(locator);
	    element.click();
	}
	public void ClickonElementById(WebDriver driver, String strID) 
	{
	    WebElement element = driver.findElement(By.id(strID));
	    element.click();
	}
	public void ClickonElementByXpath(WebDriver driver, String strXpath) 
	{
	    WebElement element = driver.findElement(By.xpath(strXpath));
	    element.click();
	}
	public void ClickonElementByName(WebDriver driver, String strName) 
	{
	    WebElement element = driver.findElement(By.name(strName));
	    element.click();
	}
	public void SendKeysByName(WebDriver driver, String strName, String strValue) 
	{
	    WebElement element = driver.findElement(By.name(strName));
	    element.sendKeys(strValue);
	}
	
	public void GetScreenshot(boolean isScreenshotEnabled, WebDriver dr) throws IOException
	{
		if(isScreenshotEnabled==true)
		{
			TakesScreenshot ts = (TakesScreenshot) dr;

	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String timestamp = LocalDateTime.now()
	                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));


	        //File destination = new File("screenshots/google.bmp");
	          File destination = new File("screenshots/google_" + timestamp + ".bmp");

	        Files.copy(source.toPath(), destination.toPath());
			
		}
	}
}
