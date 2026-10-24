package seleniumDemo.TestCases;

public class clsKiran 
{
 int age=25;
 String name="Kiran";
 String city="Vizag";
 private int salary=25000;
 String state="AP";
 
 public static String country="India";
 
 public void displayDetails()
 {
 	System.out.println("Name is: "+name);
 	System.out.println("Age is: "+age);
 	System.out.println("City is: "+city);
 	System.out.println("Salary is: "+salary);
 	System.out.println("State is: "+state);
 }
 
 public int getAge()
 {
 	return age;
 }
 
 public String getStudName()
 {
	  	return "Anvesh";
 }
 public String getSnameBysno(int sno)
 {
    String sname="";
    if(sno==10)
    {
      sname="Anand";
    }
    else if(sno==20)
    {
     sname="Kiran";
    }
    else if(sno==30)
    {
     sname="Anvesh";
    }
    else if(sno==40)
    {
     sname="Asha";
    }
    else
    {
     sname="unknown";
    }

    return sname;
 }
 public void DisplayName()
 {
    System.out.println("My name is Anand");
 }

 public void DisplayName(int sno)
 {
	 System.out.println("Student number is:" + sno);
 }
 public void DisplayName(String sname)
 {
	 System.out.println("Student name is:" + sname);
 }

}


