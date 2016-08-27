package zadaci_26_08_2016;

public class Person {
	String name, adress, phoneNumber, emailAdress;
	//no-arg konstruktor
	Person() {
	}
	//setter imena
	void setName(String name) {
		this.name = name;
	}
	//setter adrese
	void setAdress(String adress) {
		this.adress = adress;
	}
	//setter telefonskog broja
	void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	//setter email adrese
	void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	//metoda koja vraca ispis
	public String toString() {
		return "Person: " + name +
				"\nAdress: " + adress +
				"\nPhone number: " + phoneNumber +
				"\nEmail adress: " + emailAdress;
	}
}
