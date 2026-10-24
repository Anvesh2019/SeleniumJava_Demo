package seleniumDemo.TestCases;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;
public class clsSynchronization 
{
@Test
public void LearnImplicitWait()
{
	
	try
	{
	 WebDriver driver = new ChromeDriver();

     driver.manage().timeouts()
           .implicitlyWait(Duration.ofSeconds(10));

     driver.get("https://www.google.com");

     driver.findElement(By.name("q1")).sendKeys("Selenium Java");
	}
	catch(Exception ex)
	{
		System.out.println("Error: " + ex.getMessage());
	}
}
@Test
public void LearnExplicitWait()
{
	 WebDriver driver = new ChromeDriver();
     driver.get("https://www.google.com");

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement txtSrch=   (WebElement) wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("q1")));
      txtSrch.sendKeys("Selenium Java");
     
}
}
