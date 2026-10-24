package seleniumDemo.TestCases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class clsActions 
{
	WebDriver dr = new ChromeDriver();
	@Test
	public void LearnRightClick()
	{
		
		dr.get("https://techtutorialz.com");
		WebElement btnTutlibrary = dr.findElement(By.xpath("//a[contains(text(),'VIDEO TUTORIAL LIBRARY')]"));
		Actions actions = new Actions(dr);
		actions.contextClick(btnTutlibrary).perform(); // Perform right-click action
	}
	@Test
	public void LearnRightClick1()
	{
		
		dr.get("https://google.com");
		WebElement linkGmail = dr.findElement(By.linkText("Gmail"));
		Actions actions = new Actions(dr);
		actions.contextClick(linkGmail).perform(); // Perform right-click action
	}
	@Test
	public void ScrollToElement()
	{
		dr.get("https://amazon.in");
		
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Privacy Notice']")));
		
		WebElement linkPrivacy=dr.findElement(By.xpath("//a[text()='Privacy Notice']"));
		Actions actions = new Actions(dr);
		actions.scrollToElement(linkPrivacy).perform(); // Scroll to the element
		
		linkPrivacy.click(); // Click on the element after scrolling
	}
	@Test
	public void LearnMouseOver() throws InterruptedException
	{
		dr.get("https://amazon.in");
		dr.manage().window().maximize();
		Thread.sleep(2000);
		WebElement linkBestSellers=dr.findElement(By.xpath("(//a[text()='Bestsellers'])[1]"));
		Actions actions = new Actions(dr);
		actions.moveToElement(linkBestSellers).perform(); // Perform mouse over action
	}
	@Test
	public void LearnDragAndDrop() throws InterruptedException
	{
		dr.get("http://demo.guru99.com/test/drag_drop.html");
		dr.manage().window().maximize();
		Thread.sleep(2000);
		//Element which needs to drag.    		
		WebElement From = dr.findElement(By.xpath("//*[@id='credit2']/a"));

		//Element on which need to drop.		
		WebElement To = dr.findElement(By.xpath("//*[@id='bank']/li"));

		//Using Action class for drag and drop.		
		Actions action = new Actions(dr);

		//Dragged and dropped.		
		action.dragAndDrop(From, To).build().perform();
		Thread.sleep(5000); // Perform drag and drop action
	}
	
	@Test
	public void learnKeydown()
	{
		dr.get("https://www.google.com/");
		dr.manage().window().maximize();
		WebElement linkGmail = dr.findElement(By.linkText("Gmail"));
		Actions actions = new Actions(dr);
		actions.keyDown(linkGmail, Keys.ENTER).build().perform(); // Perform key down and key up action
	
		dr.get("https://www.google.com/");
		WebElement txtSrch = dr.findElement(By.name("q"));
		Actions actions1 = new Actions(dr);
		String str1="I LOVE INDIA";
		char[] arrChar=str1.toCharArray();
		for(int i=0;i<arrChar.length;i++)
		{
			 actions1.keyDown(txtSrch, String.valueOf(arrChar[i])).perform();
			//actions1.keyDown(txtSrch, arrChar[i].ToString()).build().perform(); // Perform key down and key up action
		}
		
	}
	@Test
	public void learnKeydown1() throws InterruptedException
	{
		dr.get("https://www.amazon.in/");
		dr.manage().window().maximize();
		Thread.sleep(3000);
		WebElement linkBestSellers=dr.findElement(By.xpath("(//a[text()='Bestsellers'])[1]"));
		Actions actions = new Actions(dr);
		actions.keyDown(linkBestSellers,Keys.ENTER).perform(); // Perform mouse over action
			
	}
}
