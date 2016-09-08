package zadaci_08_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Implement the following method that returns the maximum element in an array.
	 * public static <E extends Comparable<E>> E max(E[] list)
	 */

public class Zadatak_3 {

	public static void main(String[] args) {
		Integer[] list = {4, 9, 2, 10, 8};	//initialize array
		System.out.println("Max number in array: " + max(list));		//print max number
	}
	
	/* Method finding max number in array list */
	public static <E extends Comparable<E>> E max(E[] list) {
		for (int i = 0; i < list.length; i++) {
			if (list[0].compareTo(list[i]) < 0) {
				list[0] = list[i];
			}
		}
		return list[0];
	}
}