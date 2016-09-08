package zadaci_08_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Implement the following method using binary search. 
	 * public static <E extends Comparable<E>> int binarySearch(E[] list, E key)
	 */

public class Zadatak_5 {

public static void main(String[] args) {
		Integer[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};		//initialize array
		
		//printing results
		System.out.println(binarySearch(list, 11));
		System.out.println(binarySearch(list, 12));
		System.out.println(binarySearch(list, 3));
	}

	/* Method used for binary search */
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
		int low = 0;
		int high = list.length;
		while (low <= high) {
			int mid = (low + high) / 2;
		if (list[mid].compareTo(key) == 0) {		//first comparing
			return mid;
		} else if (list[mid].compareTo(key) > 0) {	//second comparing
			high = mid - 1;
		} else 				//third comparing
			low = mid + 1;
		}
		return -low -1;
	}
}