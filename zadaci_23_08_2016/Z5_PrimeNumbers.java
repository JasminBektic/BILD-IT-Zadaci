package zadaci_23_08_2016;

public class Z5_PrimeNumbers {

	public static void main(String[] args) {
		Z4_StackOfIntegers stack = new Z4_StackOfIntegers();	//kreiranje objekta klase iz zadatka4
		for (int i = 2; i < 120; i++) {
			if (isPrime(i)) {		//ako je broj prost, upisi u stack
				stack.push(i);
			}
		}
		System.out.print("Reversed prime numbers are: ");
        while (stack.size != 0) {  
	        System.out.print(stack.pop() + " ");	//ispis integera is stacka, s vrha na dole
	        }
	}
	//metoda koja provjerava da li je broj prost
	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {			// ako je broj djeljiv sa i, nije prost
				return false;
			}
		}
		return true;
	}
}
