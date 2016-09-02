package zadaci_31_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that converts the Java source code from the next-line brace style to the end-of-line brace style. For example, 
	 * the following Java source in (a) uses the next-line brace style. Your program converts it to the end-of-line brace style in (b).
	 * Your program can be invoked from the command line with the Java sourcecode file as the argument. It converts the Java source code 
	 * to a new format. For example, the following command converts the Java source-code file Test.java to the end-of-line brace style. 
	 * java Exercise12_12 Test.java
	 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadatak_1 {

	public static void main(String[] args) throws FileNotFoundException {
		String lineSeparator = System.getProperty("line.separator");
		File file = new File("D:\\Jaskio.txt");
		Scanner read = new Scanner(file);	//kreiranje objekta
		String s = "";
		while (read.hasNext()) {
			s += read.nextLine() + lineSeparator;	//stringu dodajemo red i prelazimo u novi
		}	
		s = s.replaceAll("\\s*\\{", " {");		//brisemo prazan prostor iza zagrade
		read.close();
		System.out.println(s);			//ispisujemo formatiran java kod
	} 
}
