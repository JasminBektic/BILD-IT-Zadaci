package zadaci_08_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a generic method that returns the maximum element in a two-dimensional array. 
	 * public static <E extends Comparable<E>> E max(E[][] list)
	 */

public class Zadatak_4 {

	public static void main(String[] args) {
		//initialize 2D array
		Integer[][] list = {
				{5, 6, 4},
				{2, 9, 5},
				{8, 7, 1}
		};
		//printing max number
		System.out.println("Max number in 2D array: " + max(list));
	}
	
	/* Method used for finding max number in 2D array */
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i].length; j++) {
				if (list[i][j].compareTo(max) > 0) {		//if list number is larger than max, max is equal that number
					max = list[i][j];
				}
			}
		}
		return max;
	}
}