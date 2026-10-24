package seleniumDemo.TestCases;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
public class clsWebtable 
{
@Test
public void LearnWebtable() throws InterruptedException
{
	WebDriver dr = new ChromeDriver();
	dr.get("https://www.moneycontrol.com/stocks/marketinfo/marketcap/bse/index.html");
	Thread.sleep(10000);
	List<WebElement> listRows= dr.findElements(By.xpath("//table[@class='Topfilter_web_tbl_indices__Wa1Sj undefined']/tbody/tr"));
    System.out.println("Number of rows in the table: "+listRows.size());
    
    for(int i=1; i<=listRows.size(); i++)
	{
		WebElement companyName = dr.findElement(By.xpath("//table[@class='Topfilter_web_tbl_indices__Wa1Sj undefined']/tbody/tr["+i+"]/td[1]"));
		WebElement marketCap = dr.findElement(By.xpath("//table[@class='Topfilter_web_tbl_indices__Wa1Sj undefined']/tbody/tr["+i+"]/td[2]"));
		System.out.println("Company Name: "+companyName.getText()+" | Market Cap: "+marketCap.getText());
	}
    
    //WebElement topCompany = dr.findElement(By.xpath("//table[@class='Topfilter_web_tbl_indices__Wa1Sj undefined']/tbody/tr[1]/td[1]"));
    //System.out.println("Top Company: "+topCompany.getText());
}
}
