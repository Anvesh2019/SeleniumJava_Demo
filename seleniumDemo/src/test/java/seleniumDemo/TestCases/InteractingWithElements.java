package seleniumDemo.TestCases;
import org.testng.annotations.Test;
import openqa.selenium;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class InteractingWithElements 
{
 @Test
 public void InteractWithTextbox()
 {
	 WebDriver dr = new ChromeDriver();
	 dr.get("https://www.google.com");
	 WebElement searchBox = dr.findElement(By.name("q"));
	 searchBox.sendKeys("Selenium WebDriver"); //entering text in search box
	 //searchBox.submit();
	 System.out.println("Search performed successfully.");
	 //dr.quit();
	 String strmaxlength=searchBox.getAttribute("maxlength");
	 System.out.println("attribute value: "+strmaxlength);
	 Assert.assertEquals(strmaxlength, "2050");
 }
 @Test
 public void InteractWithCheckBoxAndRadio()
 {
	 WebDriver dr = new ChromeDriver();
	   dr.get("https://www.ironspider.ca/forms/checkradio.htm");
	   WebElement chkRed = dr.findElement(By.xpath("//input[@value='red']"));
	   System.out.println("Red color is selected:" + chkRed.isSelected());
	   if (chkRed.isSelected() == false)
	   {
	        chkRed.click(); //select
	      
	   }
	   System.out.println("Red color is selected:" + chkRed.isSelected());

	   WebElement radioOpera = dr.findElement(By.xpath("(//input[@type='radio'])[3]"));
	   System.out.println("Opera is selected1:" + radioOpera.isSelected());
	   if (radioOpera.isSelected() == false)
	   {
	       radioOpera.click();
	   }
	   System.out.println("Opera is selected2:" + radioOpera.isSelected());
	    
 }
 @Test
 public void InteractWithDropdown()
 {
	 WebDriver dr = new ChromeDriver();
	 dr.get("https://www.ironspider.ca/forms/dropdowns.htm");
	 WebElement dropdown = dr.findElement(By.name("coffee"));
	 List<WebElement> options = dropdown.findElements(By.tagName("option"));
	 System.out.println("Available options in dropdown:");
	 for (WebElement option : options) 
	 {
	     System.out.println(option.getText());
	 }
 }
 @Test
 public void SelectOptionFromDropdown() throws InterruptedException
 {
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	 WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
	 Select objDD = new Select(dropdownElement);
	 objDD.selectByVisibleText("Option1");
	 Thread.sleep(2000); // Wait for 2 seconds
	 objDD.selectByValue("option2");  //select by value
	 Thread.sleep(2000); // Wait for 2 seconds
	 objDD.selectByIndex(3); //select by index
	 
	 System.out.println(objDD.isMultiple());
 }
 @Test
		 public void InteractWithListbox() throws InterruptedException
		 {
	 		 WebDriver dr = new ChromeDriver();
		     dr.get("https://output.jsbin.com/osebed/2");
		     Thread.sleep(20000);
		     WebElement fruitsLB = dr.findElement(By.xpath("//select[@id='fruits']"));
		     Select objSelect = new Select(fruitsLB);
		     System.out.println("Multi select allowed:" + objSelect.isMultiple());
		     objSelect.selectByIndex(0);
		     objSelect.selectByValue("apple");
		     objSelect.selectByVisibleText("Grape");
		     System.out.println("Selected options count before:" + objSelect.getAllSelectedOptions().size());
		     objSelect.deselectByVisibleText("Apple");
		     
		      System.out.println("Selected options count after:" + objSelect.getAllSelectedOptions().size());
			   
		 }
 @Test
 public void Listbox2() throws InterruptedException
 {
	 WebDriver dr = new ChromeDriver();
	 dr.get("https://www.w3.org/WAI/ARIA/apg/patterns/listbox/examples/listbox-rearrangeable/");
	 Thread.sleep(10000);
	 WebElement opt5 = dr.findElement(By.xpath("//li[@id='ss_opt5']"));
	 opt5.click();
	 
	 List<WebElement> optList=dr.findElements(By.xpath("//ul[@id='ss_imp_list']/li"));
	 System.out.println("Available options in listbox:" + optList.size());
	 for(int i=0;i<optList.size();i++)
	 {
		 System.out.println(optList.get(i).getText());
	 }
    	 
 }
 @Test
 public void InteractwithWebtable() throws InterruptedException
 {
	 
	 WebDriver dr = new ChromeDriver();
	 dr.get("https://www.cricinfo.com/series/ipl-2026-1510719/points-table-standings");
	 Thread.sleep(20000);
	 List<WebElement> rows = dr.findElements(By.xpath("//tbody[@class='ds-text-center']/tr"));
	 System.out.println("Total rows in table: " + rows.size());
	 for (int i = 0; i < rows.size(); i++) 
	 {
	     List<WebElement> teamNames = rows.get(i).findElements(By.xpath(".//td[1]"));
	   
	     for (int j = 0; j < teamNames.size(); j++) 
	     {
	         System.out.println(teamNames.getFirst().getText());
	     }
	 }
}
 @Test
public void VerifyTopTeam() throws InterruptedException
{
	 
		 String topTeam = GetTopTeam();
		 System.out.println("Top team in IPL 2026: " + topTeam);
	
}
 public String GetTopTeam() throws InterruptedException
 {
	 WebDriver dr = new ChromeDriver();
	 dr.get("https://www.cricinfo.com/series/ipl-2026-1510719/points-table-standings");
	 Thread.sleep(20000);
	 List<WebElement> rows = dr.findElements(By.xpath("//tbody[@class='ds-text-center']/tr"));
	 String topTeam = rows.get(8).findElement(By.xpath(".//td[1]")).getText();
	 return topTeam;
 }
}
