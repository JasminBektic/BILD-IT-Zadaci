package zadaci_26_08_2016;

import java.util.ArrayList;
import java.util.Date;

public class Zadatak_4Test {

	public static void main(String[] args) {
		
		//kreiranje objekata
		ArrayList<Object> list = new ArrayList<>();
		Loan loan = new Loan();
		Circle circle = new Circle();
		Date date = new Date();
		
		//dodavanje objekata u listu
		list.add(loan);
		list.add(circle);
		list.add(date);
		
		//invoke toString i ispis 
		for (Object o : list) {
			System.out.println(o);
		}
	}
}
