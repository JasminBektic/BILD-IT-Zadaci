package zadaci_02_08_2016;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Zadatak3 {
	
	public static void main(String[] args) throws IOException {
		
		String path = "D:\\Jaskio.txt"; 
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("File ne postoji.");
			System.exit(0);
		}
		Scanner input = new Scanner(file);
		int numChars = 0;
		int numWords = 0;
		int numLines = 0; 
		while(input.hasNext()) { 
			String line = input.nextLine(); 
			numChars += line.length();  // broji karaktere
			numWords += line.split(" ").length;  // broji rijeci
			numLines++;  // broji linije
		}
		input.close();
		System.out.println("Broj karaktera: " + numChars + "\nBroj rijeci: " + numWords + "\nBroj linija: " + numLines);
	}
}