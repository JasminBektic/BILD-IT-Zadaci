package zadaci_25_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * The split method in the String class returns an array of strings consisting of the substrings split by the delimiters. 
	 * However, the delimiters are not returned. Implement the following new method that returns an array of strings consisting of the substrings 
	 * split by the matching delimiters, including the matching delimiters.
	 * public static String[] split(String s, String regex)
	 * For example, split("ab#12#453", "#") returns ab, #, 12, #, 453 in an array of String, and split("a?b?gf#e", "[?#]") returns a, b, ?, b, gf, #, and e in an array of String.
	 */

import java.util.ArrayList;
import java.util.Arrays;

public class SplitString {

	public static void main(String[] args) {
		//ispis substringova
		System.out.println(Arrays.toString(split("ab#12#453", "#")));
		System.out.println(Arrays.toString(split("a?b?gf#e", "[?#]")));
	}
			
	//metoda koja vraca vise substringa razdvojenog stringa delimetrom
	public static String[] split(String s, String regex) {
		ArrayList<String> list = new ArrayList<>();
		String chars = "";
		for (int i = 0; i < s.length(); i++) {
			chars += s.charAt(i) + "";			//dodajemo prvi substring privremenom stringu
			for (int j = 0; j < regex.length(); j++) {
				if (s.charAt(i) == regex.charAt(j)) {		//ako je karakter stringa isti kao jedan od regex, dodajemo substring listi
					chars = chars.substring(0, chars.length() - 1);		//oduzimamo regex iz privremenog stringa
					String reg = regex.charAt(j) + "";		//pretvaramo regex karakter u string
					list.add(chars);	//dodajemo substring i regex
					list.add(reg);
					chars = "";		//brisemo privremeni string
				}
			}
		}
		list.add(chars);	//dodajemo ostatak stringa iz petlje
		String[] newList = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			newList[i] = list.get(i);
		}
		return newList;
	}
}
