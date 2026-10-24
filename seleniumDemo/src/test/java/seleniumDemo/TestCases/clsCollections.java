package seleniumDemo.TestCases;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
public class clsCollections 
{
@Test
public void LearnArrayList()
{
	ArrayList<String> list = new ArrayList<>();
	list.add("Apple");
	list.add("Banana");
	list.add("Orange");
	list.add("Grapes");
   
	list.add(Integer.toString(250));
	//System.out.println("ArrayList: " + list);
	System.out.println("ArrayList Size before delete: " + list.size());
	//list.remove(2);
	//list.clear();
	System.out.println(list.contains("Orange"));
	System.out.println("ArrayList Size after delete: " + list.size());
	
	ArrayList<Integer> ranks = new ArrayList<>();
	ranks.add(1);
	
}
@Test
public void LearnHashset()
{
	Set<Integer> set = new HashSet<>();
    set.add(10);
    set.add(20);
    set.add(10); // duplicate ignored
    set.add(500);
    set.add(600);
    System.out.println(set);
    System.out.println("HashSet Size before deleting: " + set.size());
    //set.clear();
    set.remove(20);
    System.out.println("HashSet Size after removing 2nd element: " + set.size());
}
@Test
public void LearnQueue()
{
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);
    System.out.println("Queue size: " + queue.size());
    System.out.println(queue.poll()); // removes first element
    System.out.println(queue.poll()); // removes 2nd element
    System.out.println("Queue size: " + queue.size());

}
}
