package zadaci_29_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that prompts the user to read two integers and displays their sum. Your program should prompt the 
	 * user to read the number again if the input is incorrect.
	 */
	
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadatak_3 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter 2 integers: ");
		int num1 = check();		//unos 2 integera
		int num2 = check();
		System.out.println("Sum is: " + (num1 + num2));	//ispis sume
	}
	//metoda koja provjerava unos
	public static int check() {
		int num = 0;
		while (true) {
			try {
				num = input.nextInt();		//unos
				break;
			}
			catch (InputMismatchException e) {		//hvatanje greske
				System.out.println("Wrong input, try again:");
				input.nextLine();		//ciscenje inputa
			}
		}
		return num;		//vracanje broja
	}
}
