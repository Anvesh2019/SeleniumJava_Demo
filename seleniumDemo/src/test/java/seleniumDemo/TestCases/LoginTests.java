package seleniumDemo.TestCases;
import org.testng.annotations.Test;

import seleniumDemo.*;

public class LoginTests 
{
public static void main(String[] args) 
{
//	LoginPage loginPage = new LoginPage();
	//loginPage.login("testuser", "testpassword");
	System.out.println("Login test executed successfully.");
}


@Test
public void testLogin2()	
{

	clsStud s1=new clsStud("John Doe", 20, "Computer Science");
	s1.displayInfo(10,"karthik");
}

@Test
public void LearnOverriding()
{
	
	        clsAnimal obj = new clsDog();
	        obj.sound();   // Output: Dog barks
	    
	
}
}