package zadaci_30_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Suppose that a text file contains an unspecified number of scores separated by blanks. 
	 * Write a program that prompts the user to enter the file, reads the scores from the file, 
	 * and displays their total and average.
	 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zadatak_5 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Do u want to open this file? \n0 - No\n1 - Yes");
		int option = input.nextInt();
		if (option == 0) {
			System.exit(0);
		}
		input.close();
		try {
			displayScore();
		} catch (FileNotFoundException e) {		//hvatanje greske ako fajl ne postoji
			System.out.println("File does not exist!");
		}
	}
	//metoda koja prikazuje sumu i srednju vrijednost brojeva
	public static void displayScore() throws FileNotFoundException {
		double sum = 0, countAverage = 0;
		Scanner input = new Scanner(new File("D:\\scores.txt"));	
		while (input.hasNext()) {
			int score = input.nextInt();
			sum += score;				//suma brojeva
			countAverage++;	
			System.out.print(score + " ");		//prikaz brojeva
	}
		input.close();
		double average = sum / countAverage;		//srednja vrijednost
		System.out.print("\nScore sum: " + sum + "\nScore average: " + average);
	}
}
