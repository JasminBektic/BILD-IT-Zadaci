package zadaci_26_08_2016;

public class Student extends Person{
	private static final String s1 = "Freshman";
	private static final String s2 = "Sophomore";
	private static final String s3 = "Junior";
	private static final String s4 = "Senior";
	String status;
	//no-arg konstruktor
	public Student() {
	}
	//setter statusa
	void setStatus(int status) {
		switch (status) {
			case 1: this.status = s1; break;
			case 2: this.status = s2; break;
			case 3: this.status = s3; break;
			case 4: this.status = s4; break;
		}
	}
	//metoda koja vraca ispis
	public String toString() {
		return "Student: " + name +
				"\nStatus: " + status;
	}
}
