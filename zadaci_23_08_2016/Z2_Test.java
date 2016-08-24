package zadaci_23_08_2016;

public class Z2_Test {

	public static void main(String[] args) {
		char[] ch = {'1', '2', '3', '4', '5'};
		Z2_MyInteger myInt = new Z2_MyInteger(10);
		
		//test svih metoda
		System.out.println("Number: " + myInt.getValue());
		System.out.printf("Even number: %b, %b, %b\n", myInt.isEven(), Z2_MyInteger.isEven(5), Z2_MyInteger.isEven(5));
		System.out.printf("Odd number: %b, %b, %b\n", myInt.isOdd(), Z2_MyInteger.isOdd(5), Z2_MyInteger.isOdd(5));
		System.out.printf("Prime number: %b, %b, %b\n", myInt.isPrime(), Z2_MyInteger.isPrime(5), Z2_MyInteger.isPrime(5));
		System.out.printf("Equals number: %b, %b\n", myInt.equals(5), myInt.equals(5));
		System.out.println("Int value of char array: " + Z2_MyInteger.parseInt(ch));
		System.out.println("Int value of 12345 string: " + Z2_MyInteger.parseInt("12345"));
	}
}
