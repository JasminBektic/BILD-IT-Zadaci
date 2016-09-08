package zadaci_08_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the following method that returns a new ArrayList. The new list contains the non-duplicate elements from the original list.
	 * public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
	 */

import java.util.ArrayList;

public class Zadatak_1 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		//String inputs
	    list.add("Ned");
	    list.add("Sansa");
	    list.add("Ned");
	    list.add("Robb");
	    list.add("Robb");
	    list.add("Sansa");
	    list.add("Jon");

	    System.out.println("Original list:");
	    print(list);		//printing the original list
	    System.out.println("\nNon-duplicate list:");
	    print(removeDuplicates(list));		//printing the new list
	}
	
	/* Method used for removing duplicates from an array */
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
		ArrayList<E> listRemDup = new ArrayList<E>();
		for (E elem : list) {
			if (!listRemDup.contains(elem)) {	//if list doesn't contain element, add it
				listRemDup.add(elem);
		    }
		}
		return listRemDup;
	}
	
	/* Print array method */
	public static <E> void print(ArrayList<E> list) {
		for (E ex : list) {
			System.out.print(ex + " ");
		}
	}
}