package seleniumDemo.TestCases;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class clsAlerts 
{
	WebDriver dr = new ChromeDriver();
	
  @Test
  public void LearnAlerts() throws InterruptedException
	{
		
		dr.get("https://demoqa.com/alerts");
		dr.manage().window().maximize();
		Thread.sleep(2000);
		dr.findElement(By.id("alertButton")).click(); // Click on the alert button
		Thread.sleep(2000);
		Alert alert = dr.switchTo().alert(); // Switch to the alert
		alert.accept(); // Accept the alert
		Thread.sleep(2000);
		dr.quit(); // Close the browser
	}
  @Test
  public void LearnConfirmAlert() throws InterruptedException
  {
	// Alert Message handling
	  dr.get("http://demo.guru99.com/test/delete_customer.php");
	  //dr.FindElement(By.Name("cusid")).SendKeys("53920");
	  Actions action = new Actions(dr);
	  WebElement custID = dr.findElement(By.name("cusid"));
	  String custId = "523190";
	  custID.sendKeys(custId);
	             
	  dr.findElement(By.name("submit")).click();
	  // Switching to Alert        
	  Alert alert = dr.switchTo().alert(); //switch to 1st popup
	  System.out.println("1st alert text:" + alert.getText());
	  Thread.sleep(3000);
	  alert.accept(); //click on OK button
	  //alert.dismiss();

	  Alert deleteAlert = dr.switchTo().alert(); //Switch to delete popup
	  
	  System.out.println("2nd alert text:" + deleteAlert.getText());
	  Assert.assertEquals(deleteAlert.getText(), "Customer Successfully Delete!"); //Assertion
	  Thread.sleep(3000);
	  deleteAlert.accept(); //Click on OK
  }
}
