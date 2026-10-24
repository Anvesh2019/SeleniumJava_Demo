package seleniumDemo.TestCases;
import openqa.selenium;
import seleniumDemo.TestCases.clsDept;
import seleniumDemo.TestCases.clsStud;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
public class DemoTests 
{
		WebDriver dr;
	@BeforeMethod
    public void setup() throws IOException 
	{
		/*
		Properties prop;
		
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop = new Properties();
        prop.load(fis);
        System.out.println("Browser: " + prop.getProperty("browser"));
        
        // Launch Chrome browser
        dr = new ChromeDriver();
        String appURL=prop.getProperty("url");
        // Open URL
        dr.get(appURL); //get application URL from properties file
        */
    }
	@Test
	public void OpenGoogle()
	{
	  WebDriver dr = new ChromeDriver();
	  dr.get("https://google.com/");
	  dr.findElement(By.name("q")).sendKeys("Selenium WebDriver");
	}
	@Test
	public void ReadFromPropertiesFile() throws IOException
	{
        Properties prop;
		
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop = new Properties();
        prop.load(fis);
        System.out.println("Browser: " + prop.getProperty("browser"));
        
	}
	
	@Test
	public void SearchInGoogle() 
	{
		// Print title
        System.out.println("Page Title: " + dr.getTitle());
        
        String strTitle=dr.getTitle();
        Assert.isTrue(strTitle.contains("Google"),"page title is not matching");
        System.out.println("Page Url: " + dr.getCurrentUrl());
        WebElement searchBox = dr.findElement(By.name("q"));
        String maxlength=searchBox.getAttribute("maxlength"); //get attribute value of maxlength
        System.out.println("Max length of search box is: "+maxlength);
        Assert.isTrue(searchBox.isDisplayed(), "Search box is not displayed");
        if(searchBox.getSize().getHeight()>0 && searchBox.getSize().getWidth()>0)
        	{
        	 System.out.println("Search box is displayed1");
        	}
        List<WebElement> txtSrch=dr.findElements(By.name("q"));
        if(txtSrch.size()>0) //check element is present in DOM
		{
			System.out.println("Search box is displayed2");
		}
		else
		{
			System.out.println("Search box is not displayed");
		}
        dr.findElement(By.name("q")).sendKeys("Selenium WebDriver");
		dr.findElement(By.name("q")).submit();
		
	}
	@Test
	public void LearnLinkText()
	{
	   dr.findElement(By.linkText("Gmail")).click();	
	   Assert.isTrue(dr.getTitle().contains("Gmail"), "Gmail page is not displayed");
	}
	@Test
	public void LearnPartialLinkText() throws InterruptedException
	{
		WebDriver dr = new ChromeDriver();
		Thread.sleep(3000);
	   dr.get("https://google.com/");
	   dr.findElement(By.partialLinkText("Images")).click();	
	   
	}
	@Test
	public void DisplayStudDetails()
	{
		clsStud objstud=new clsStud("Anand", 30, "Selenium Testing");
		//objstud.displayInfo();
		clsDept objdept=new clsDept();
		objdept.displayInfo();
		//System.out.println(objdept.cname);//not accessible as it is private in parent class
		//objDept.displayCollegeNambe(); //not accessible as it is private in parent class
		System.out.println(clsStud.collegeAddress); //static variable can be accessed by class name
		objdept.displayDeptDetails(); //Overloaded method without parameter
	}
	@Test
	public void GetStudDetails()
	{
		clsKiran objk=new clsKiran();
		//System.out.println(objk.salary);
		objk.displayDetails();
		System.out.println(objk.country); //static variable can be accessed by class name
		
	int studAge=objk.getAge();
	System.out.println("Student Age is: "+studAge);
	
	String sname=objk.getStudName();
	System.out.println("Student Name is: "+sname);
	System.out.println(objk.getSnameBysno(50));
	objk.DisplayName(20);
	objk.DisplayName("Anvesh");
	}
	
	public void Test2()
	{
		clsDept objdept=new clsDept();
		
	}
	@AfterMethod
	public void tearDown() 
	{
		if (dr != null) {
			dr.quit();
		}
	}
}
