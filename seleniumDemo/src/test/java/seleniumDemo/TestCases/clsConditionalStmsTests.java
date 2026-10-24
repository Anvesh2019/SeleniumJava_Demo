package seleniumDemo.TestCases;
import org.testng.annotations.Test;

public class clsConditionalStmsTests 
{
@Test
public void testDemo()
{
	System.out.println("Demo test case executed successfully.");
	test1();
}

public void test1()
{
	System.out.println("Test 1 executed successfully.");
}

@Test
public void LearnIfStatement()
{
	int x=25;
	if(x<18)
	{
		System.out.println("Student is minor");
	}
	else if(x>18)
	{
		System.out.println("Student is major");
		
	}
	else
	{
		System.out.println("Student is exactly 18 years old");
	}
	
}
@Test
public void LearnIfelse()
{
	String state = "MP";
	if(state=="TG")
	{
		System.out.println("Telangana");
	}
	else 
	{
		System.out.println("Unknown state");
		
	}
}
@Test
public void LearnSwitchcase()
{
    int day = 4;

    switch (day) 
    {
        case 1:
            System.out.println("Monday");
            break;

        case 2:
            System.out.println("Tuesday");
            break;

        case 3:
            System.out.println("Wednesday");
            break;
        case 4:
            System.out.println("Thursday");
            break;
        case 5:
            System.out.println("Friday");
            break;

        default:
            System.out.println("Invalid day");
    
   }
}
@Test
public void LearnSwitchcase1()
{
    String state = "AP";

    switch (state) 
    {
        case "TG":
            System.out.println("Telangana");
            break;

        case "MH":
            System.out.println("Maharastra");
            break;

        case "AP":
            System.out.println("Andhra Pradesh");
            break;

        default:
            System.out.println("Invalid state");
    
   }
}

/*@Test
public void ModernSwitchcase()
{
	int day = 2;

	String dayName = switch (day) {
	    case 1 -> "Monday";
	    case 2 -> "Tuesday";
	    case 3 -> "Wednesday";
	    default -> "Invalid day";
	};

	System.out.println(dayName);
}
*/
@Test
public void LearnForLoop()
{
	
	int i=0;
	for (i = 0; i < 5; i++) 
	{
		System.out.println("I am Anand: " + i);
	}	
	System.out.println(" i value when exited from loop: " + i);
}
@Test
public void PrintEvenNumbers()
{
	
	int i;
	for ( i = 0; i <= 10; i=i+2) 
	{
		System.out.println("I am Anand: " + i);
	}	
	System.out.println(" i value when exited from loop: " + i);
}
@Test
public void LearnWhileLoop()
{
	int i=0;
	while (i < 5) 
	{
		System.out.println("Iteration: " + i);
		i++;  // i=i+1
	}
	System.out.println(" i value when exited from while loop: " + i);
}
@Test
public void LearnDoWhileLoop()
{
	int i=10;
	do 
	{
		System.out.println("Iteration: " + i);
		i++;
	} while (i < 5);
}
}