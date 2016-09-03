package zadaci_03_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Rewrite the Course class in Listing 10.6 to add a clone method to perform a deep copy on the students field.
	 */

public class Zadatak_5 {

	public static void main(String[] args) throws CloneNotSupportedException {
		Course c1 = new Course();
		c1.addStudent("A");
		c1.addStudent("B");
		c1.addStudent("C");
		c1.addStudent("D");
		Course c2 = (Course) c1.clone();
		
		//ispis originalne liste i kopirane
		System.out.println("Object1...");
		c1.getStudents();
		System.out.println("\n\nObject2 (cloned)...");
		c2.getStudents();
	}
}