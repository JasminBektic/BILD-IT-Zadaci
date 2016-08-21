package zadaci_20_08_2016;

public class Zadatak4_AccountTest {

	public static void main(String[] args) {
		Account acc = new Account(1122, 20000);	//id racuna i balans
		acc.setAnnualInterestRate(4.5);			//godisnja stopa
		acc.withdraw(2500);				//skidamo sa racuna
		acc.deposit(3000);				//dodajemo na racun
		acc.print();					//print stanja
	}
}
