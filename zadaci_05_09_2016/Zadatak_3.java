package zadaci_05_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program similar to Listing 7.9, Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10a. 
	 * You will need to use the split method in the String class, introduced in Section 10.10.3, Replacing and Splitting Strings, to retrieve 
	 * the numerator string and denominator string, and convert strings into integers using the Integer.parseInt method.
	 * (a) The program takes three arguments (operand1, operator, and operand2) from the command line and displays the expression and 
	 * the result of the arithmetic operation. (b) A complex number can be interpreted as a point in a plane.
	 */

import java.util.ArrayList;

public class Zadatak_3 {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<>(breaking(args[0]));
		ArrayList<String> list2 = new ArrayList<>(breaking(args[2]));
		
		//Finding integer of lowest common denominator and 2 numerators
		int lci = lci(Integer.parseInt(list1.get(1)), Integer.parseInt(list2.get(1)));
		int n1 = lci / Integer.parseInt(list1.get(1)) * Integer.parseInt(list1.get(0));
		int n2 = lci / Integer.parseInt(list2.get(1)) * Integer.parseInt(list2.get(0));
		String answer = "";
		
		//Finding proper operator and do some calculations
		switch (args[1]) {
			case "+": answer = n1 + n2 + "/" + lci; break;
			case "-": answer = n1 - n2 + "/" + lci; break;
			case "*": answer = Integer.parseInt(list1.get(0)) * Integer.parseInt(list2.get(0)) + "/" +
         					   Integer.parseInt(list1.get(1)) * Integer.parseInt(list2.get(1)); break;
			case "/": answer = Integer.parseInt(list1.get(0)) * Integer.parseInt(list2.get(1)) + "/" +
							   Integer.parseInt(list1.get(1)) * Integer.parseInt(list2.get(0)); break;
		}
		
		//Result of a hard effort :)
		 System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + answer);
	}
	
	/* Method for breaking string and eliminating slash */
	public static ArrayList<String> breaking(String s) {
		ArrayList<String> list = new ArrayList<>();
		String sum = "";
		for(int i = 0; i < s.length(); i++) {
		  if (s.charAt(i) != '/') {
			  sum = sum + s.charAt(i);
		  	} 
		  if (s.charAt(i) == '/') {		//First number in list
			  list.add(sum);
			  sum = "";
		  	} 
	  	}
		list.add(sum);		//Add second number to list
		return list;
	}
	
	/* Lowest common denominator */
	public static int lci(int num1, int num2) {
		int num = 0;
		for (int i = (num1 * num2); i >= num2; i--) {	
			if (i % num1 == 0 && i % num2 == 0) {		//If i is divisible with first and second number, return it
				num = i;
			}
		}
		return num;	
	}
}