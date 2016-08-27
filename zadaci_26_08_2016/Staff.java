package zadaci_26_08_2016;

public class Staff extends Employee {
	private String title;
	//no-arg konstruktor
	public Staff() {
	}
	//setter
	void setTitle(String title) {
		this.title = title;
	}
	//metoda za ispis
	public String toString() {
		return "Staff: " + name + 
				"\nTitle: " + title;
	}
}
