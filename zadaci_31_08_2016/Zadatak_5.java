package zadaci_31_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Create a data file with 1,000 lines. Each line in the file consists of a faculty member’s first name, last name, rank, and 
	 * salary. The faculty member’s first name and last name for the ith line are FirstNamei and LastNamei. The rank is randomly generated 
	 * as assistant, associate, and full. The salary is randomly generated as a number with two digits after the decimal point. The salary 
	 * for an assistant professor should be in the range from 50,000 to 80,000, for associate professor from 60,000 to 110,000, and for 
	 * full professor from 75,000 to 130,000. Save the file in Salary.txt. Here are some sample data:
	 * FirstName1 LastName1 assistant 60055.95
	 * FirstName2 LastName2 associate 81112.45
	 * . . .
	 * FirstName1000 LastName1000 full 92255.21
	 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Zadatak_5 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:\\Salary.txt");			//kreiranje objekta 
		PrintWriter output = new PrintWriter(file);	
		String[] str = {"assistant", "associate", "full"};
		for (int i = 1; i <= 1000; i++) {
			int index = (int) (Math.random() * 3);		//random index
			double salary = 0;
			switch (index) {
				//povezemo index rank sa platama
				case 0: salary = Math.random() * 30000 + 50000; break;
				case 1: salary = Math.random() * 50000 + 60000; break;
				case 2: salary = Math.random() * 55000 + 75000; break;
			}
			//upis podataka u fajl u zadanom formatu
			output.printf("FirstName%d LastName%d %s %6.2f", i, i, str[index], salary);
			output.println();	//novi red
		}
		output.close();
	}
}
