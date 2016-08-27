package zadaci_26_08_2016;

import java.util.Date;

public class Employee extends Person{
	private String office;
	private String salary;
	private Date dateHired = new Date();
	//no-arg konstruktor
	public Employee() {
	}
	//setter za office
	void setOffice(String office) {
		this.office = office;
	}
	//setter za salary
	void setSalary(String salary) {
		this.salary = salary;
	}
	//metoda koja vraca ispis
	public String toString() {
		return "Employee: " + name +
				"\nOffice: " + office +
				"\nSalary: " + salary +
				"\nHired : " + dateHired;
	}
}
