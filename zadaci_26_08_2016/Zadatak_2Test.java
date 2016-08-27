package zadaci_26_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Design a class named Person and its two subclasses named Student and Employee. Make Faculty and Staff subclasses of Employee. 
	 * A person has a name, address, phone number, and email address. A student has a class status (freshman, sophomore, junior, or senior). Define the status as 
	 * a constant. An employee has an office, salary, and date hired. Use the MyDate class defined in Programming Exercise 10.14 to create an object for date hired. 
	 * A faculty member has office hours and a rank. A staff member has a title. Override the toString method in each class to display the class name and the person’s 
	 * name. Draw the UML diagram for the classes and implement them. Write a test program that creates a Person, Student, Employee, Faculty, and Staff, and invokes 
	 * their toString() methods.
	 */

public class Zadatak_2Test {

	public static void main(String[] args) {
		
		//kreiranje objekta person klase
		Person person = new Person();
		person.setName("Jon Snow");
		person.setAdress("Castle Black, 82");
		person.setEmailAdress("castle.black@hotmail.com");
		person.setPhoneNumber("061/666-666");
		System.out.println(person);
		
		//kreiranje objekta staff klase
		Staff staff = new Staff();
		System.out.println();
		staff.setName("Ned Stark");
		staff.setTitle("King of North");
		System.out.println(staff);
		
		//kreiranje objekta faculty klase
		Faculty faculty = new Faculty();
		System.out.println();
		faculty.setName("Zdravko");
		faculty.setOfficeHours("40h");
		faculty.setRank("Profesor");
		System.out.println(faculty);
		
		//kreiranje objekta employee klase
		Employee employee = new Employee();
		System.out.println();
		employee.setName("Nedim");
		employee.setOffice("Post Office");
		employee.setSalary("2000 KM");
		System.out.println(employee);
		
		//kreiranje objekta student klase
		Student student = new Student();
		System.out.println();
		student.setName("Ljubisa");
		student.setStatus(2);
		System.out.println(student);
	}
}
