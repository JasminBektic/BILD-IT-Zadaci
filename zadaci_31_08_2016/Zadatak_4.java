package zadaci_31_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Suppose that the text file on the Web http://cs.armstrong.edu/liang/data/Scores.txt contains an unspecified number of scores. 
	 * Write a program that reads the scores from the file and displays their total and average. Scores are separated by blanks.
	 */

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Zadatak_4 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//uzimanje podataka sa URL
		InputStream on = new URL("http://cs.armstrong.edu/liang/data/Scores.txt").openStream();
		double sum = 0, average = 0;
		int count = 0;
		Scanner read = new Scanner(on);		//kreiranje objekta
		while (read.hasNext()) {
			sum += read.nextInt();		//svaki broj dodajemo sumi
			count++;
		}
		read.close();
		average = sum / count;		//izracun prosjeka
		
		//ispis sume i prosjeka
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + average);
	}
}
