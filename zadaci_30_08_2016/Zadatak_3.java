package zadaci_30_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that removes all the occurrences of a specified string from a text file. For example, 
	 * invoking java Exercise12_11 John filename removes the string John from the specified file. Your program should 
	 * get the arguments from the command line.
	 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zadatak_3 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter string so it can be removed from file:");
		String del = in.next();		//unos stringa koji cemo da brisemo
		in.close();
		String s = "";
    	File file = new File("D:\\jaskio.txt");		//kreiranje objekta
    	Scanner input = new Scanner(file);
		while (input.hasNext()) {
			s += input.nextLine();			//sav tekst iz fajla sumirati u string
		}
		input.close();
		s = s.replaceAll(del, "");		//zamijeniti odredjeni string praznim poljem
		PrintWriter output = new PrintWriter(file);	
        output.println(s);			//unijeti izmjenjeni string u fajl
        output.close();
	}
}
