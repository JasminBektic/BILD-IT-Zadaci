package zadaci_01_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * A university posts its employees’ salaries at http:// cs.armstrong.edu/liang/data/Salary.txt. Each line in the file consists of a faculty 
	 * member’s first name, last name, rank, and salary (see Programming Exercise 12.24). Write a program to display the total salary for assistant professors, 
	 * associate professors, full professors, and all faculty, respectively, and display the average salary for assistant professors, associate professors, full 
	 * professors, and all faculty, respectively.
	 */

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Zadatak_1 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//uzimanje podatak iz URL
		InputStream url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt").openStream();
		Scanner read = new Scanner(url);		//kreiranje objekta Scanner
		BigDecimal sum = new BigDecimal(0);		
		BigDecimal sum1 = new BigDecimal(0);
		BigDecimal sum2 = new BigDecimal(0);
		BigDecimal sum3 = new BigDecimal(0);
		int count = 0, sum1Count = 0, sum2Count = 0, sum3Count = 0;
		while (read.hasNextLine()) {
			String s = read.next();
			if (read.hasNext("assistant")) {
				s = read.nextLine().replaceAll("assistant", "").trim();		//racuna se odredjena rijec + broj
				BigDecimal num = new BigDecimal(s);							//zato brisemo rijec i cistimo whitespace oko broja
				sum1 = sum1.add(num);			//svaki novi broj dodajemo sumi
				count++;				//brojac za ukupni
				sum1Count++;			//i pojedinacni prosjek
			}
			if (read.hasNext("associate")) {
				s = read.nextLine().replaceAll("associate", "").trim();		
				BigDecimal num = new BigDecimal(s);
				sum2 = sum2.add(num);			//upis novog broja u sumu
				count++;
				sum2Count++;
			}
			if (read.hasNext("full")) {
				s = read.nextLine().replaceAll("full", "").trim();
				BigDecimal num = new BigDecimal(s);
				sum3 = sum3.add(num);			//upis novog broja u sumu
				count++;
				sum3Count++;
			}
		}
		read.close();
		sum = sum.add(sum1).add(sum2).add(sum3);		//ukupna suma
		//ispis svih suma i prosjeka
		System.out.println("Total salary for assistant professors: " + sum1);
		System.out.println("Total salary for associate professors: " + sum2);
		System.out.println("Total salary for full professors: " + sum3);
		System.out.println("Total salary for full faculty: " + sum);
		System.out.println("Average salary for assistant professors: " + sum1.divide(new BigDecimal(sum1Count), 2, BigDecimal.ROUND_UP));
		System.out.println("Average salary for associate professors: " + sum2.divide(new BigDecimal(sum2Count), 2, BigDecimal.ROUND_UP));
		System.out.println("Average salary for full professors: " + sum3.divide(new BigDecimal(sum3Count), 2, BigDecimal.ROUND_UP));
		System.out.println("Average salary for full faculty: " + sum.divide(new BigDecimal(count), 2, BigDecimal.ROUND_UP));
	}
}
