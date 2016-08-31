package zadaci_30_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that will count the number of characters, words, and lines in a file. Words are separated by 
	 * whitespace characters.
	 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadatak_4 {

	public static void main(String[] args) throws FileNotFoundException {
		int charCount = 0, wordCount = 0, lineCount = 0;
		Scanner input = new Scanner(new File("D:\\jaskio.txt"));
		while (input.hasNextLine()) {
			String s = input.nextLine();
			lineCount++;		//brojac linija
			charCount += s.length();		//brojac karaktera
			
			/*
			 * Posto u zadatku nije tacno navedeno da li treba brojati whitespace u karaktere
			 * sledeca linija koda navedena u komentaru daje broj karaktera bez whitespace
			 * 
			 * for (int i = 0; i < s.length(); i++) {
				if (Character.isWhitespace(s.charAt(i))) {
					continue;
				} else
					charCount++;
			}
			 */
			
			wordCount += s.split(" ").length;	//brojac rijeci
		}
		input.close();
		//ispis broja karaktera, rijeci i linija u fajlu
		System.out.println("Number of characters: " + charCount);
		System.out.println("Number of words: " + wordCount);
		System.out.println("Number of lines: " + lineCount);
	}
}
