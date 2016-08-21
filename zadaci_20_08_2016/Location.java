package zadaci_20_08_2016;

	/*
	 * Design a class named Location for locating a maximal value and its location in a two-dimensional array. The class contains 
	 * public data fields row, column, and maxValue that store the maximal value and its indices in a two-dimensional array with row and 
	 * column as int types and maxValue as a double type. Write the following method that returns the location of the largest element 
	 * in a two-dimensional array: public static Location locateLargest(double[][] a)
	 * The return value is an instance of Location. Write a test program that prompts the user to enter a two-dimensional array and displays 
	 * the location of the largest element in the array.
	 */

public class Location {
	public int row;
	public int column;
	public double maxValue;
	//konstruktor
	Location(int row, int column, double maxValue) {
		this.row = row;
		this.column = column;
		this.maxValue = maxValue;
	}
		//metoda koja pronalazi najveci element i njegovu poziciju
	public static Location locateLargest(double[][] a) {
		double max = 0;
		double[] temp;						
		int column = 0, row = 0;			//pocetna pozicija
		for (int i = 0; i < a.length; i++) {
			temp = a[i];				
			for (int j = 0; j < a.length; j++) {
				if (max < temp[j]) {			//ako je max manji od sledeceg broja, dodjeli maxu taj broj
					max = temp[j];		//novi max
					column = j;			//novi index kolone
					row = i;			//novi index reda
				}
			}
		}
		return new Location(row, column, max);		//vracanje instance klase
	}
}