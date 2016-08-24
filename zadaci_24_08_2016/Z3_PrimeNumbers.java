package zadaci_24_08_2016;

import java.math.BigInteger;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write a program that finds five prime numbers larger than Long.MAX_VALUE.
	 * 
	 * 
	 * Many thanks to Aneesh Karayil and Luiz Arantes for their example codes!
	 * 
	 */

public class Z3_PrimeNumbers {
	
	/* 
	 * Program vjerovatno nece za kratko vrijeme pronaci proste brojeve,
	 * ali je testiran na manjim brojevima i radi
	 * 
	 */
	public static void main(String[] args) {
		BigInteger num = new BigInteger(Long.MAX_VALUE + "").add(BigInteger.ONE);	//dodajemo 1 na Long max
		int count = 0;
		while (count < 5) {			//kada pronadje svih 5 brojeva petlja ce zavrsiti
			if(isPrime(num)) {
				System.out.println(num);		//ispis prostih brojeva
				count++;
			}
			num = num.add(BigInteger.ONE);		//dodavanje jedinice na Long max
		}
	}
	//metoda koja provjerava da li je broj prost
	public static boolean isPrime(BigInteger num) {
		BigInteger halfNum = num.divide(new BigInteger("2"));		//broj dijelimo sa dva
		for (BigInteger i = new BigInteger("2"); i.compareTo(halfNum) <= 0; i = i.add(BigInteger.ONE)) {
			if (num.remainder(i).equals(BigInteger.ZERO)) {			//ako je broj djeljiv sa i, nije prost
				return false;
			}
		}
		return true;
	}
}