package zadaci_31_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that counts the number of words in President Abraham Lincoln’s Gettysburg address from 
	 * http://cs.armstrong.edu/liang/data/ Lincoln.txt.
	 */

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Zadatak_3 {

	public static void main(String[] args) throws MalformedURLException, IOException {
		//uzimanje teksta iz URL
		InputStream on = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt").openStream();
		int count = 0;
		Scanner read = new Scanner(on);		//kreiranje objekta Scanner
		while (read.hasNext()) {
			String s = read.next();
			if (s.contains("--")) {		//necemo racunati -- kao rijec
				continue;
			} else
			count++;
		}
		read.close();
		System.out.println("Number of words: " + count);		//ispis broja rijeci
	}
}
