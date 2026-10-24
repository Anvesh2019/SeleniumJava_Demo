package seleniumDemo.TestCases;

public class clsWeather implements infStud
{

	@Override
	public void displayInfo(int sno, String sname) 
	{
		System.out.println("Student Number: " + sno);
		System.out.println("Student Name: " + sname);	
	}

	@Override
	public void displayDeptDetails() 
	{
	   System.out.println("Department details method executed successfully.");	
	}

}
