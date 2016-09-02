package zadaci_01_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * The popularity ranking of baby names from years 2001 to 2010 is downloaded from www.ssa.gov/oact/babynames and stored in 
	 * files named babynameranking2001.txt, babynameranking2002.txt, . . . , babynameranking2010.txt. Each file contains one 
	 * thousand lines. Each line contains a ranking, a boy’s name, number for the boy’s name, a girl’s name, and number for the girl’s 
	 * name. For example, the first two lines in the file babynameranking2010.txt are as follows:  
	 * 
	 * 1 Jacob 21,875 Isabella 22,731
	 * 2 Ethan 17,866 Sophia 20,477
	 * 
	 * So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s name Ethan and girl’s name Sophia are ranked 
	 * #2. 21,875 boys are named Jacob and 22,731 girls are named Isabella. Write a program that prompts the user to enter the year, 
	 * gender, and followed by a name, and displays the ranking of the name for the year.
	 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zadatak_3 {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		//unos podataka
		System.out.println("Enter the year:");
		int year = input.nextInt();
		System.out.println("Enter the gender (M/F):");
		String gender = input.next();
		System.out.println("Enter the name:");
		String name = input.next();
		input.close();
		
		//kreiranje objekata
		File file1 = new File("D:\\babynameranking" + year + ".txt");
		File file2 = new File("D:\\Jaskio.txt");
		PrintWriter output = new PrintWriter(file2);
		Scanner read = new Scanner(file1);

		int count1 = 1;
		int count2 = 0;
		while (read.hasNext()) {
			String s = read.next();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ',') {			//zamjenjujemo zarez whitespace-om
					s = s.replace(s.charAt(i), ' ');	
				}
			}
			for (int i = 0; i < s.length(); i++) {
				if (Character.isWhitespace(s.charAt(i))) {
					int num = s.charAt(i + 1);
					if (num == 77) {		//kada dodje do M ranka u listi, otpoceti brojac ponovo od 1
						count2++;
					}
				}
			}
			if (count2 == 1) {
				count1 = count2;		//restart brojaca 1
			}
			output.println(s + " " + count1);
			count1++;
		}
		read.close();
		output.flush();
		output.close();
		Scanner reader = new Scanner(file2);		//kreiranje objekta Scanner
		boolean status = true;
		while (reader.hasNext()) {
			String s = reader.next();
			if (s.equals(name)) {		//ako su stringovi jednaki, pomaknuti za tri mjesta kako bi pronasli ranking
				s = reader.next();
				if (!s.equals(gender)) {
					continue;
				} else {
				String num = reader.next();
				String numb = reader.next();
				System.out.printf("%s is ranked #%s in year %d", name, numb, year);		//ispis rankinga
				file2.deleteOnExit();		//izbrisati pomocni fajl
				System.exit(0);
				status = false;
				}
			}
		}
		if (status) {
			System.out.printf("The name %s is not ranked in year %d", name, year);
			file2.deleteOnExit();
		}
		reader.close();
	}
}
