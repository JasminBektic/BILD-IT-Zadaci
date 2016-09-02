package zadaci_02_09_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Rewrite the MyStack class in Listing 11.10 to perform a deep copy of the list field.
	 */

public class Zadatak_5 {

	public static void main(String[] args) throws CloneNotSupportedException {
		MyStack stack1 = new MyStack();
		stack1.push(1);		//unos random elemenata
		stack1.push(4);
		stack1.push(3);
		stack1.push(2);
		MyStack stack2 = (MyStack) stack1.clone();	//kopiranje stack1 u stack2
		
		//ispis originalne i kopirane liste
		System.out.println(stack1);
		System.out.println(stack2);
	}
}