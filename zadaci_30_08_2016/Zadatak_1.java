package zadaci_30_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Write the bin2Dec(String binaryString) method to convert a binary string into a decimal number. 
	 * Implement the bin2Dec method to throw a NumberFormatException if the string is not a binary string.
	 */

public class Zadatak_1 {

	public static void main(String[] args) {
		System.out.println(bin2Dec("1100K101"));	//binarni string
	}
	
	//metoda koja pretvara binarni string u decimalni broj
	public static int bin2Dec(String binaryString) {
		int decimalValue = 0;
		try {
			decimalValue = Integer.parseInt(binaryString, 2);
		}
		catch (NumberFormatException e) {		//hvatanje greske i prikaz poruke
			throw new NumberFormatException("String is not binary string");
		}
		return decimalValue;
	}
}
