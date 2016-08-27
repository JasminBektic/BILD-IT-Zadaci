package zadaci_26_08_2016;

public class Faculty extends Employee {
	private String officeHours;
	private String rank;
	//no-arg konstruktor
	public Faculty() {
	}
	//setteri
	void setOfficeHours(String officeHours) {
		this.officeHours = officeHours;
	}
	
	void setRank(String rank) {
		this.rank = rank;
	}
	//metoda koja vraca ispis
	public String toString() {
		return "Faculty member: " + name +
				"\nOffice hours: " + officeHours +
				"\nRank: " + rank;
	}
}
