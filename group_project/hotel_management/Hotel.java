package group_project;

import java.util.Scanner;

public class Hotel {
	static Scanner input = new Scanner(System.in);
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Calling admin and guest class, creating log in form
	 */
	public static void main(String[] args) throws Exception {
		Admin admin = new Admin();
		Guest guest = new Guest();
		System.out.println("\t--MAIN MENU--");
		System.out.println("Log In as:");
		System.out.println("1- Admin\n2- Guest");
		int option = input.nextInt();
		switch (option) {
			case 1: 
				//Admin LogIn
				while (true) {
					System.out.println("Enter username:");
					String username = input.next();
					System.out.println("Enter password:");
					String password = input.next();
					if (!(username.equals("admin") && password.equals("admin"))) {
						System.out.println("Wrong username or password, try again.");
					} else {
						admin.adminMenu();
					}
				}  
			case 2: 
				//Guest LogIn
				guest.logIn();
				guest.guestMenu(); break;
		}
	}
}
