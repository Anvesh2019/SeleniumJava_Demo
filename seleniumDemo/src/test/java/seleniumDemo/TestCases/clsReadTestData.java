package seleniumDemo.TestCases;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import dev.failsafe.internal.util.Assert;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class clsReadTestData 
{
@Test
public void ReadJsonFile() throws InterruptedException
{
	String filePath = "src/test/resources/testdata/searchData1.json";
    ObjectMapper mapper = new ObjectMapper();
    
    try {
    	WebDriver driver = new ChromeDriver();
        // Parse JSON file into a Map
        Map<?, ?> testData = mapper.readValue(new File(filePath), Map.class);
        
        // Retrieve values using keys from your JSON file
        String url = testData.get("url").toString();
        String searchKeyword = testData.get("searchKeyword").toString();
        String expectedTitle = testData.get("expectedTitle").toString();
        String mytvLinkText = testData.get("myTVName").toString();
        
        System.out.println("Navigating to: " + url);
        System.out.println("Searching for: " + searchKeyword);
        
        // Your Selenium code goes here:
         driver.get(url);
         Thread.sleep(5000); // Wait for 2 seconds to ensure the page loads
         driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchKeyword);
         driver.findElement(By.id("nav-search-submit-button")).click();
         String actualTitle = driver.getTitle();
         System.out.println("Actual Title: " + actualTitle);
         Assert.isTrue(actualTitle.contains(expectedTitle), "Title does not match expected value.");
         Thread.sleep(3000); // Wait for 2 seconds to observe the result
         WebElement mytvLink = driver.findElement(By.xpath("(//span[text()='"+mytvLinkText +"'])[1]"));
         mytvLink.click();
    } 
    catch (IOException e) 
    {
        System.err.println("Failed to read JSON file: " + e.getMessage());
        e.printStackTrace();
    }
}

@Test
public void ReadExcelFile() {
    // Path to your excel file placed in src/test/resources
    String filePath = "src/test/resources/testdata/Countries.xlsx";
    //C:\Users\anand\eclipse-workspace1\seleniumDemo\src\test\resources\testdata\Countries.xlsx
    
    try (FileInputStream fis = new FileInputStream(new File(filePath));
         Workbook workbook = new XSSFWorkbook(fis)) {
        
        // Get the first sheet (index 0) or by name: workbook.getSheet("Sheet1")
        //Sheet sheet = workbook.getSheetAt(1);
    	Sheet sheet = workbook.getSheet("marks");
        
        System.out.println("Rows count: " + sheet.getPhysicalNumberOfRows());
        
        // Loop through all rows
//        for (Row row : sheet) 
//        {
//            // Loop through all cells in the row
//            for (Cell cell : row) 
//            {
//                
//                // Format cell data as a String regardless of type (Numeric, String, Boolean)
//                DataFormatter formatter = new DataFormatter();
//                String cellValue = formatter.formatCellValue(cell);
//                
//                System.out.print(cellValue + "\t");
//            }
//            System.out.println(); // New line after each row
//        }
        
        for(int i=1;i<sheet.getPhysicalNumberOfRows();i++)
		{
			Row row=sheet.getRow(i);
			for(int j=0;j<row.getPhysicalNumberOfCells();j++)
			{
				Cell cell=row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String cellValue = formatter.formatCellValue(cell);
				System.out.print(cellValue + "\t");
			}
			System.out.println();
		}
    } 
    catch (IOException e) 
    {
        System.err.println("Error reading Excel file: " + e.getMessage());
        e.printStackTrace();
    }
}
@DataProvider(name = "loginData")
public Object[][] getLoginData() {

    return new Object[][] {
        {"anvesh", "pass1"},
        {"asha", "pass2"},
        {"anand", "pass3"}
    };
}

@Test(dataProvider = "loginData")
public void loginTest(String username, String password) 
{
   WebDriver driver = new ChromeDriver();
   driver.get("https://google.com/");
   driver.findElement(By.name("q")).sendKeys(username + " " + password);
   // System.out.println("Username: " + username);
   // System.out.println("Password: " + password);
}
}
