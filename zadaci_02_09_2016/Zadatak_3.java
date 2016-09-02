package zadaci_02_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Define a class named ComparableCircle that extends Circle and implements Comparable. Draw the UML diagram and implement 
	 * the compareTo method to compare the circles on the basis of area. Write a test class to find the larger of two instances 
	 * of ComparableCircle objects.
	 */

public class Zadatak_3 {

	public static void main(String[] args) {
		ComparableCircle com1 = new ComparableCircle();		//kreiranje prvog kruga sa datom vrijednosti
		com1.setRadius(27);
		ComparableCircle com2 = new ComparableCircle();		//kreiranje drugog kruga i njegova vrijednost
		com2.setRadius(26);
		
		//ispis rezultata u odnosu na komparaciju
		System.out.print("Larger of two circles is: ");
		if (com1.compareTo(com2) == 1) {
			System.out.print("Object2");
		} else if (com1.compareTo(com2) == -1) {
			System.out.println("Object1");
		} else if (com1.compareTo(com2) == 0)
			System.out.println("They are equal!");
	}
}
