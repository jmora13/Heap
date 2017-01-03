//Jose Mora
//Project 6 
//4-26-2016
import java.util.*;
public class Driver {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("How many names would you like to alhpabetize? ");
		int numNames = keyboard.nextInt(); //reads in number of names
		Heap names = new Heap(numNames);
		
		for( int i = 0; i < numNames; i++) { //loops for amount of names user enters 
		System.out.println("Enter Name " + i + ":");
		names.add(keyboard.next());
		}
	
	    for( int i = 0; i < numNames; i++) {
	    	System.out.println(names.remove()); //prints out the names as they are removed 
	    }
	}  
}

