package seleniumDemo.TestCases;

public class clsStud
{
	String name;
	int age;
	String course;
	private String cname="VRSEC";
	public static String collegeAddress="Vijayawada";
	
	public clsStud() 
	{
	  System.out.println("Default constructor called");
	}
	public clsStud(String name, int age, String course) 
	{
		this.name = name;
		this.age = age;
		this.course = course;
		
		System.out.println("Parameterized constructor called");
	}
	
	public void displayInfo() 
	{
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Course: " + course);
	}

	public void displayInfo(int sno)
	{
		
		System.out.println("Student Number: " + sno);
	}
	public void displayInfo(int sno, String sname)
	{
		
		System.out.println("Student Number: " + sno);
		System.out.println("Student Name: " + sname);
	}	
	 private void displayCollegeName()
	 {
		 System.out.println("College Name: " + cname);
	 }
	 
	 public void displayDeptDetails()
	 {
		 System.out.println("Department details method executed successfully.");
	 }
	 public void displayDeptDetails1(String deptName)
	 {
		 System.out.println("Department details method executed successfully for department: " + deptName);
	 }
	
}
