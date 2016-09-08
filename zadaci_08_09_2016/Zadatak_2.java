package zadaci_08_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Implement the following generic method for linear search. 
	 * public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
	 */

public class Zadatak_2 {

	public static <E> void main(String[] args) {
		Integer[] list = {5, 6, 9, 2, 3, 1, 0, 7};	//initialize array
		
		//test method
		System.out.println(linearSearch(list, 9));
		System.out.println(linearSearch(list, 4));
	}
	
	/* Method used for linear search */
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		for (int i = 0; i < list.length; i++) {
			if (key.compareTo(list[i]) == 0) {		//if key compared to list with specified index is zero, than that is our number
				return i;
			}
		}
		return -1;
	}
}