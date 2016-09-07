package zadaci_06_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Rewrite the fib method in Listing 18.2 using iterations. Hint: To compute fib(n) without recursion, you need to obtain fib(n - 2) 
	 * and fib(n - 1) first. Let f0 and f1 denote the two previous Fibonacci numbers. The current Fibonacci number would then be f0 + f1. 
	 * The algorithm can be described as follows:
	 * f0 = 0; // For fib(0)
	 * f1 = 1; // For fib(1)
	 * for (int i = 1; i <= n; i++) {
	 * currentFib = f0 + f1;
	 * f0 = f1;
	 * f1 = currentFib;
	 * }
	 * // After the loop, currentFib is fib(n)
	 * 
	 * Write a test program that prompts the user to enter an index and displays its Fibonacci number.
	 */

import javax.swing.JOptionPane;

public class Zadatak_1 {

	public static void main(String[] args) {
		String n = JOptionPane.showInputDialog("Enter an index for the Fibonacci number:");		//Number input
		int index = Integer.parseInt(n);
		int currentFib = 0, f0 = 0, f1 = 1;
		for (int i = 1; i < index; i++) {
			currentFib = f0 + f1;		//True Fibonacci number
			f0 = f1;
			f1 = currentFib;
		}
		
		/* Show Fibonacci number */
		JOptionPane.showMessageDialog(null, "Fibonacci number at index " + index + " is " + currentFib);
	}
}
