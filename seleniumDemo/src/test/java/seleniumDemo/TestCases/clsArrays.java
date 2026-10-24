package seleniumDemo.TestCases;
import org.testng.annotations.Test;
public class clsArrays 
{
@Test
public void LearnSingleDimensionalArray()
{
	int[] numbers = {1, 2, 3, 4, 5};
	
	for (int i = 0; i < numbers.length; i++) 
	{
		System.out.println(numbers[i]);
	}
}
@Test
public void LearnMultiDimensionalArray()
{
	int[][] matrix = {
	    {1, 2, 3,30},
	    {4, 5, 6,60},
	    {7, 8, 9,90}
	};
	System.out.println("Multi Dimensional Array:" + matrix.length);
	for (int i = 0; i < matrix.length; i++) 
	{
	    for (int j = 0; j < matrix[i].length; j++) 
	    {
	        System.out.print(matrix[i][j] + " "); // 0,1 0,1 0,2, 0,3
	    }
	    System.out.println();
	}
}
@Test
public void LearnMultiDimensionalStringArray()
{
	String[][] matrix = {
	    {"AP","Vizag"},
	    {"TG", "HYD"},
	    {"MH", "Mumbai"}
	};
	System.out.println("Multi Dimensional Array:" + matrix.length);
	for (int i = 0; i < matrix.length; i++) 
	{
	    for (int j = 0; j < matrix[i].length; j++) 
	    {
	        System.out.print(matrix[i][j] + " "); // 0,1 0,1 0,2, 0,3
	    }
	    System.out.println();
	}
}
}