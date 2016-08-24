package zadaci_23_08_2016;

	/*
	 * @author Jasmin Bektic
	 */

import java.util.Scanner;

public class Z4_PrimeFactors {
	static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		Z4_StackOfIntegers stack = new Z4_StackOfIntegers();
		System.out.print("Enter a positive number: ");
	    int num = check();
	    
	    // provjera prime faktora za dati broj i njihovi upisi u stack
	    for (int i = 2; i <= num; i++) {
	    	int counter = 0;
	    	while (num % i == 0) {
	    		num /= i;
	    		counter++;
	            if (counter != 0) {
	            	stack.push(i);
	                }
	            }
	    	}
	    	System.out.print("Prime factors are: ");
	        while (stack.size != 0) {  
		        System.out.print(stack.pop() + " ");	//ispis integera is stacka, s vrha na dole
		        }
	}
	//metoda za provjeru unosa
	static int check() {
		int num = 0;
		while (true) {
			try {	
				num = input.nextInt();	//unos
				break;
			}
			catch (Exception e) {		//hvatanje greske
				System.out.println("Wrong input, try again;");
				input.nextLine();
			}
		}
		return num;
	}
}
