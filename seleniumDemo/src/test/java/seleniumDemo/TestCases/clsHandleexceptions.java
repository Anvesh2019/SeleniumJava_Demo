package seleniumDemo.TestCases;
import org.testng.annotations.Test;

public class clsHandleexceptions 
{
@Test		
	public void divide() 
	{
		try 
		{
			int a=20;
			int b=0;
			int result = a / b;
			System.out.println("Result: " + result);
		} 
		catch (ArithmeticException e) 
		{
			System.out.println("Error: Division by zero is not allowed.");
		}
	}

}
