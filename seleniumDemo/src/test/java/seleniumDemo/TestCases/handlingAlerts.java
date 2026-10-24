package seleniumDemo.TestCases;
import org.testng.annotations.Test;
import openqa.selenium;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class handlingAlerts 
{
	@Test
	public void HandleAlert() throws InterruptedException
	{
		WebDriver dr = new ChromeDriver();
		dr.get("http://demo.guru99.com/test/delete_customer.php");
		dr.findElement(By.name("cusid")).sendKeys("523190");
		dr.findElement(By.name("submit")).click();
		Alert alert = dr.switchTo().alert();
		System.out.println("Alert text is: " + alert.getText());
		if(alert.getText().contains("Do you really want to delete this Customer?"))
		{
			System.out.println("Alert text is correct.");
			alert.accept(); //click on cancel button
		}
		else
		{
			System.out.println("Alert text is incorrect.");
			alert.dismiss();
		}
		
		Thread.sleep(2000);
		Alert alert1 = dr.switchTo().alert();
		System.out.println("Alert text is: " + alert1.getText());
		alert1.accept(); //click on OK button
	}

}
