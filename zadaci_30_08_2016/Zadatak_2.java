package zadaci_30_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that causes the JVM to throw an OutOfMemoryError and catches and handles this error.
	 */

public class Zadatak_2 {

	public static void main(String[] args) {
		try {
			int[] m = new int[Integer.MAX_VALUE];	//kreiranje novog objekta
		}
		catch (OutOfMemoryError e) {		//hvatanje greske i ispis
			System.out.println("Cannot allocate an object because it is out of memory!");
		}
	}
}
