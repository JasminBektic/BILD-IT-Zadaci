package group_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import com.sun.xml.internal.ws.util.StringUtils;

public class Admin {
	public int id, age, roomNum;
	long diffDays;
	public String firstName, lastName, gender, identityCard, userName, password, roomType, checkInDate, esDateUpdate, roomDateUpdate, dateTime;
	final int[] extraService = {10, 10, 20, 10, 10};
	final int[] room = {20, 40, 60};
	Scanner input = new Scanner(System.in);
	ArrayList<String> list = new ArrayList<>();
	ArrayList<String> orderNewRoom = new ArrayList<>();
	ArrayList<String> orderNewES = new ArrayList<>();
	ArrayList<String> checkOut = new ArrayList<>();
	
	public Admin() {
		
	}
	
	/*
	 * @author Kada Okic
	 * 
	 * Getters and setters
	 */
	public String getCheckInDate() throws SQLException {
		String query = "SELECT CheckInDate FROM information WHERE information.UserName = ?";
		PreparedStatement statement = getConnection().prepareStatement(query);
		statement.setString(1, userName);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			checkInDate = rs.getString(1);
		}
		return checkInDate;
	}
	
	public int getId() throws SQLException {
		String query = "SELECT ID FROM information WHERE information.UserName = ?";
		PreparedStatement s = getConnection().prepareStatement(query);
		s.setString(1, userName);
		ResultSet rs = s.executeQuery();
		if (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}
	
	public ArrayList<String> getList() {
		return list;
	}
	
	public void setList(String s) {
		list.add(s);
	}

	/* 
	 * @author Jasmin Bektic
	 * 
	 * Method confirms connection 
	 */
	public Connection getConnection() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/hotel";
			String user = "root";
			String pass = "";
			Class.forName(driver);
			
			//Connecting with provided url,userName and pass
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (Exception e) {		//Catch errors
			System.out.println(e);
		}
		return null;
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method checking if data is already stored in archive
	 */
	public String checkArchive(int id) throws Exception {
		
		//Get data from archive and save it in a string
		String query = "SELECT FirstName, LastName, Gender, IdentityCard, Age FROM archive WHERE ID = ?";
		PreparedStatement s = getConnection().prepareStatement(query);
		s.setInt(1, id);
		ResultSet result = s.executeQuery();
		String stat = "";
		String s0 = "'";
		while (result.next()) {
			String s1 = result.getString(1);
			String s2 = result.getString(2);
			String s3 = result.getString(3);
			String s4 = result.getString(4);
			String s5 = result.getString(5);
			stat = s0+s1+s0 + ", " + s0+s2+s0 + ", " + s0+s3+s0 + ", " + s0+s4+s0 + ", " + s0+s5+s0;
		}
		return stat;
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Admin main menu
	 */
	public void adminMenu() throws Exception {
		System.out.println("\t--MENU--");
		System.out.println("1- Register new guest\n2- View pending requests\n3- Print bill\n4- Search guest\n5- System information\n6- Exit");
		int option = input.nextInt();
		switch (option) {
			case 1: enterInfo(); break;
			case 2: pendingRequest(); break;
			case 3: adminCheckOut(); break;
			case 4: System.out.println("Enter first name/identity card/username to search for a guest:");
					String search = input.next();
					searchDatabase("information", search); break;
			case 5: checkOnlineStatus(); break;
			case 6: Hotel.main(null); break;
		}
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method allows admin to check out guest and print bill
	 */
	public void adminCheckOut() throws Exception {
		System.out.println("1- Pending requests\n2- Guest check out and print bill\n3- Back to menu");
		int option = input.nextInt();
		switch (option) {
			case 1: 
				if (checkOut.size() == 0) {
					System.out.println("There is no requests!\n");
				} else {
				//Split string from array
				System.out.println("ID\tName");
				System.out.println("______________");
				String[] temp;
				for (int i = 0; i < checkOut.size(); i++) {
					temp = checkOut.get(i).split("#");
					System.out.println(temp[0] + "\t" + temp[1]);
				}
				System.out.println("---------------\n");
				System.out.println("Enter guest ID to check him out:");
				int guestID = input.nextInt();
				printInvoice(guestID);
				System.out.println("\nGuest is checked out!\n");
				String sql = "";
				for (int i = 0; i < checkOut.size(); i++) {
					sql = checkOut.get(i);
					String[] split = sql.split("#");
					
					//Find sql statement match with ID from same string
					if (split[2].equals(sql.substring(0, split[2].length()))) {
						sql = split[2];
					}
				}
				//Transfer basic information to archive table and delete user from information table
				PreparedStatement stInsert =  getConnection().prepareStatement(sql);
				stInsert.execute();
				PreparedStatement stSelect = getConnection().prepareStatement("DELETE FROM information WHERE ID = "+guestID+ "");
				stSelect.executeUpdate();
				}
				adminCheckOut(); break;
			case 2:
				System.out.println("Enter First name/identity card/username to search for a guest:");
				String search = input.next();
				int result = searchDatabase("information", search);
				if (result == 0) {
					System.out.println("Guest not found!\n");
					adminCheckOut();
				} else {
					System.out.println("\nEnter guest ID to print bill:");
					int id = input.nextInt();
					System.out.println();
					printInvoice(id);
					System.out.println("\nGuest is checked out!\n");
					
					//Select data from information and copy to archive table
					PreparedStatement statement = getConnection().prepareStatement("SELECT FirstName, LastName, Gender, IdentityCard, Age FROM information WHERE ID = "+id+"");
					ResultSet rs = statement.executeQuery();
					while (rs.next()) {
						firstName = rs.getString("FirstName");
						lastName = rs.getString("LastName");
						gender = rs.getString("Gender");
						identityCard = rs.getString("IdentityCard");
						age = rs.getInt("Age");
					}
					PreparedStatement stInsert =  getConnection().prepareStatement("INSERT INTO archive (FirstName, LastName, Gender, IdentityCard, Age) VALUES ('"+firstName+"', '"+lastName+"', '"+gender+"', '"+identityCard+"', "+age+")");
					stInsert.execute();
					PreparedStatement stSelect = getConnection().prepareStatement("DELETE FROM information WHERE ID = "+id+ "");
					stSelect.executeUpdate();
					adminCheckOut();
				} break;
			case 3: adminMenu(); break;
		}
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method checking for guest requests
	 */
	public void pendingRequest() throws Exception {
		if (orderNewES.size() + orderNewRoom.size() == 0) {
			System.out.println("There are no requests!\n");
			adminMenu();
		}
		System.out.println("\t\t--PENDING REQUESTS--\n");
		for (int i = 2; i < orderNewES.size() + 2; i++) {
			if (i % 2 == 0) {
				System.out.println(orderNewES.get(i - 2));
			}
		}
		System.out.println("\t\t--Room change--\n");
		System.out.println("Name\t\t\tFrom\t\tTo");
		System.out.println("______________________________________________________");
		for (int i = 2; i < orderNewRoom.size() + 2; i++) {
			if (i % 2 == 0) {
				System.out.println(orderNewRoom.get(i - 2));
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("0- Back to menu\n1- Approve all\n");
		System.out.println("Choose number to proceed:");
		int option = input.nextInt();
		
		//Update extra service and room table
		if (option == 1) {
			for (int i = 2; i < (orderNewRoom.size() + orderNewES.size() / 2 + 2); i ++) {
				if (i % 2 != 0) {
					PreparedStatement s = getConnection().prepareStatement(orderNewES.get(i - 2));
					s.executeUpdate();
				}
				if (i % 2 != 0) {
					PreparedStatement s = getConnection().prepareStatement(orderNewRoom.get(i - 2));
					s.executeUpdate();
				}
			}
			System.out.println("All requests approved!");
			adminMenu();
		} else if (option == 0) {
			adminMenu();
		}
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method used for calculating total balance for certain number of days
	 */
	public int balance(String s, int sum) throws Exception {
		//Current date and time
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String orderDate = df.format(date);
		Date d1 = df.parse(s);
		Date d2 = df.parse(orderDate);
		
		//Number of days between current date and checkIn date (time is default, 12:00:00)
		long diff = d2.getTime() - d1.getTime();
		diffDays = diff / (24 * 60 * 60 * 1000);
		dateTime = orderDate.substring(0, 10) + " 12:00:00";
		int balance = 0;
		if (diffDays == 0) {
			balance = sum;
		} else {
			balance = (int) (diffDays * sum);
		}
		return balance;
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method importing extra service and room values during registration
	 */
	public void importServices(int id) throws SQLException {
		//Insert data into extra_service table
		String sql1 = "INSERT INTO extra_service (ID, Gym, Cinema, Restaurant, Pool, Sauna, Balance, DateUpdate) VALUES ("+id+", "+0+", "+0+", "+0+", "+0+", "+0+", "+0+", '"+checkInDate+"')";
		PreparedStatement statement = getConnection().prepareStatement(sql1);
		statement.executeUpdate();
		statement.close();
		
		int[] room = new int[3];
		int balance = 0;
		switch (roomType) {
			case "Single Room": room[0] = this.room[0];room[1] = 0;room[2] = 0;balance = this.room[0]; break;
			case "Double Room": room[1] = this.room[1];room[0] = 0;room[2] = 0;balance = this.room[1]; break;
			case "Apartment": room[2] = this.room[2];room[0] = 0;room[1] = 0;balance = this.room[2]; break;
		}
		//Insert data into room table
		String sql2 = "INSERT INTO room (ID, SingleRoom, DoubleRoom, Apartment, Balance, DateUpdate) VALUES ("+id+", "+room[0]+", "+room[1]+", "+room[2]+", "+balance+", '"+checkInDate+"')";
		PreparedStatement s = getConnection().prepareStatement(sql2);
		s.executeUpdate();
		s.close();
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method used for registering new guest
	 */
	public void enterInfo() throws Exception {
		System.out.println("Check name in archive:");
		firstName = input.next();
		firstName = StringUtils.capitalize(firstName);
		int num = searchDatabase("archive", firstName);
		String archiveQuery = "";
		if (num != 0) {
			
			//Copy data from archive 
			System.out.println("\nEnter guest id to copy basic information");
			int option = input.nextInt();
			archiveQuery = checkArchive(option);
			PreparedStatement s = getConnection().prepareStatement("DELETE FROM archive WHERE ID = "+option+ "");
			s.executeUpdate();
			s.close();
			System.out.println("Basic informations are stored!");
		} else {
			
			//New entry
			System.out.println("No result found!");
			System.out.println("Continue with registration...");
			System.out.println("\nEnter the following information.");
			System.out.println("First name:");
			firstName = input.next();
			firstName = StringUtils.capitalize(firstName);
			System.out.println("Last name:");
			lastName = input.next();
			lastName = StringUtils.capitalize(lastName);
			System.out.println("Gender:");
			gender = input.next();
			System.out.println("Identity card:");
			identityCard = input.next();
			System.out.println("Age:");
			age = input.nextInt();
		}
		//Continue with data input
		System.out.println("\nAssign room number");
		System.out.println("-------------------");
		roomNum = checkAvailableRoom();
		System.out.println("\nRoom Type");
		System.out.println("----------");
		roomType = roomType();
		System.out.println("\nDate registered (YYYY-MM-DD):");
		checkInDate = input.next() + " 12:00:00";
		userName = checkAvailableUserName();
		System.out.println("\nAssign password:");
		password = input.next();
		archiveQuery = "'"+firstName+"', '"+lastName+"', '"+gender+"', '"+identityCard+"', "+age+"";
	
		//New data input
		String sql = "INSERT INTO information (FirstName, LastName, Gender, IdentityCard, Age, RoomNumber, RoomType, CheckInDate, UserName, Password) "
				+ "VALUES (" +archiveQuery+ ", "+roomNum+",'"+roomType+"','"+checkInDate+"','"+userName+"','"+password+"')";
		PreparedStatement statement = getConnection().prepareStatement(sql);
		statement.executeUpdate();
		System.out.println("Registration complete!\n");
		statement.close();
		importServices(getId());
		adminMenu();
	}
	
	/* 
	 * @author Davor Sadikovic
	 * 
	 * Method for checking available rooms 
	 */
	public int checkAvailableRoom() throws SQLException {
		Statement s = getConnection().createStatement();
		s.executeQuery("SELECT RoomNumber FROM information");
		ResultSet rs = s.getResultSet();
		System.out.print("Occupied room numbers: ");
		
		//Listing occupied rooms
		while (rs.next()) {
			int room = rs.getInt("RoomNumber");
		    System.out.print(room + " "); 
		}
		System.out.println();
		rs.close ();
		s.close ();
		
		//Assign room number for a guest
		System.out.println("Enter room number for a guest:");
		int num = input.nextInt();
		return num;
	}
	
	/* 
	 * @author Jasmin Bektic
	 * 
	 * Assign room type for guest 
	 */
	public String roomType() {
		System.out.println("1- Single Room\n2- Double Room\n3- Apartment");
		System.out.println("Choose option:");
		int option = input.nextInt();
		String s = "";
		switch (option) {
			case 1: s = "Single Room"; break;
			case 2: s = "Double Room"; break;
			case 3: s = "Apartment"; break;
		}
		return s;
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method checking available user name 
	 */
	public String checkAvailableUserName() throws SQLException {
		ArrayList<String> li = new ArrayList<>();
		Statement s = getConnection().createStatement();
		s.executeQuery("SELECT UserName FROM information");
		ResultSet rs = s.getResultSet();
		
		//Transfering user names from database to array
		while (rs.next()) {
			String str = rs.getString("UserName");
			li.add(str);
		}
		rs.close ();
		s.close ();
		
		//Compare user name to names from array
		System.out.println("\nAssign username:");
		String user = "";
		boolean boo = true;
		while (boo) {
			user = input.next();
			if (li.size() == 0) {
				break;
			}
			for (int i = 0; i < li.size(); i++) {
				if (user.equals(li.get(i))) {
					System.out.println("User name already exist, try another one:");
					boo = true;
					break;
				} else {
					boo = false;
				}
			}
		}
		return user;
	}
	
	/* 
	 * @author Maja Vasilic
     * 
	 * providing information from database based on entry 
	 */
	public int searchDatabase(String table, String s) throws Exception {
		int num = 0;
		try {
			String or = "";
			if (table == "information") {
				or = "OR UserName = ?";
			}
			// establish connection to the database invoking method
			Connection con = getConnection();
			// var query with SQL query
			String query = "SELECT * FROM " +table+ " WHERE FirstName = ? OR IdentityCard= ? " +or+ "";
			// create statement
			PreparedStatement statement = con.prepareStatement(query);

			// actual values are set to parameters
			statement.setString(1, s);
			statement.setString(2, s);
			if (table == "information") {
				statement.setString(3, s);
			}
			//query execution 
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String format = "%-25s";

			// print column names
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf(format, rsmd.getColumnLabel(i));
			}
			System.out.println();
			// print underline
			for (int i = 1; i <= columnCount * 25; i++) {
				System.out.print("_");
			}
			System.out.println();
			// print information from database
			while (result.next()) {
				for (int i = 1; i <= columnCount; i++) {
					System.out.printf(format, result.getString(i));
					num = result.getInt(1);
				}
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return num;		//if num is 0 no data is returned
	}

	/* 
	 * @author Jasmin Bektic
	 * 
	 * Method checking for online users 
	 */
	public void checkOnlineStatus() throws Exception {
		printStatus();
		while (true) {
			System.out.println();
			System.out.println("Choose No to log out user or choose options below:");
			int num = input.nextInt();
		
			//Option conditions and print status
			if (num > 0 && num < list.size() + 1) {
				list.remove(num - 1);
				printStatus();
				System.out.println("User is removed\n");
			} else if (num == 0) {
				adminMenu();
			} else if (num == list.size() + 1) {
				for (int i = list.size() - 1; i >= 0; i--) {
					list.remove(i);
				}
				printStatus();
				System.out.println("All users are loged out!\n");
			} else if (num == list.size() + 2) {
				System.out.println("Shutting down... Goodbye");
				System.exit(0);
			}
		}
	}
	
	/* Online status print method */
	public void printStatus() {
		System.out.println("\t--Online Status--");
		System.out.println("\nNo\tUserName");
		System.out.println("-----------------");
		for (int i = 1; i <= list.size(); i++) {
			System.out.println(i + "\t" + list.get(i - 1));
		}
		if (list.size() == 0) {
			System.out.println("No users online!");
		}
		System.out.println("-----------------");
		System.out.println("0- Return to menu");
		System.out.println((list.size() + 1) + "- Log out all users");
		System.out.println((list.size() + 2) + "- Shut down");
	}
	
	/*
	 * @author Davor Sadikovic
	 *
	 * Method prints invoice for room expences and extra service expences
	 */
	public void printInvoice(int id) {
		// Calls a method to connect to server
		Connection conn = getConnection();

		try {
			Statement st = conn.createStatement();
			int userID = id;

			// Prompts admin to enter an option for printing invoice
			System.out.println("Enter option for printing invoice: \n");
			System.out.println("1. Print only invoice for room expences.");
			System.out.println("2. Print only invoice for extra services.");
			System.out.println("3. Print invoice for guest room expences and extra services combined.");

			int option = input.nextInt();

			switch (option) {

			// Prints invoice for room expences
			case 1:
				ResultSet rs = st.executeQuery("SELECT * FROM hotel.information WHERE ID =" + userID);

				// Initialized variables for storing values
				String typeRoom = "";
				Timestamp checkIn = new Timestamp(0);
				String guestFirstName = "";
				String guestLastName = "";
				int roomPrice = 0;

				// Adds values from database to variables
				while (rs.next()) {
					typeRoom = rs.getString("RoomType");
					checkIn = rs.getTimestamp("CheckInDate");
					guestFirstName = rs.getString("FirstName");
					guestLastName = rs.getString("LastName");
				}

				// Stores room price depending on room type
				switch (typeRoom) {
				case "Single Room":
					roomPrice = room[0];
					break;
				case "Double Room":
					roomPrice = room[1];
					break;
				case "Apartment":
					roomPrice = room[2];
					break;
				}

				// Calculates days guest stayed in hotel by subtracting check in
				// date and check out date(or current time)
				java.util.Date checkOut = new java.util.Date();
				long numberOfDays = checkOut.getTime() - checkIn.getTime();
				numberOfDays = TimeUnit.DAYS.convert(numberOfDays, TimeUnit.MILLISECONDS);

				// Calculates total price for room expences
				long cost = numberOfDays * roomPrice;

				// Prints invoice with guests information and price to be payed
				System.out.println("\n\t\t\t\t\tHOTEL INVOICE\n");

				System.out.println(
						"\nFirst Name: " + guestFirstName + "\t\t\t\tLast Name: " + guestLastName + "\nCheck In Date: "
								+ checkIn.toString() + "\t\tCheck Out Date: " + new Timestamp(checkOut.getTime()));
				System.out.println(
						"___________________________________________________________________________________________");
				System.out.println("Room Type: " + typeRoom + "\t\t\t\tNights stayed: " + numberOfDays
						+ "\n\nRoom Price: " + roomPrice);
				System.out.println(
						"-------------------------------------------------------------------------------------------");
				System.out.println("Total: \t\t\t\t\t\t" + cost + "\n");

				rs.close();
				break;

			// Prints invoice for extra service expences
			case 2:
				
				// Executes query result set
				ResultSet result = st.executeQuery("SELECT * FROM hotel.extra_service WHERE ID =" + userID + ";");

				// Initializes variables for storing extra services
				int gym = 0, cinema = 0, restaurant = 0, pool = 0, sauna = 0, balance = 0;
				java.util.Date checkOutDate = new Date();

				// Stores data from database to variables
				while (result.next()) {
					gym = result.getInt("Gym");
					cinema = result.getInt("Cinema");
					restaurant = result.getInt("Restaurant");
					pool = result.getInt("Pool");
					sauna = result.getInt("Sauna");
				}
				result.close();
				
				balance = gym + cinema + restaurant + pool + sauna;
				// Prints invoice with extra services presented along with guest information
				System.out.println("\n\t\t\t\t\tHOTEL INVOICE\n");

				ResultSet rset = st.executeQuery("SELECT * FROM hotel.information WHERE ID ='" + userID + "';");

				rset.next();
				System.out.println("\nFirst Name: " + rset.getString("FirstName") + "\t\t\t\tLast Name: "
						+ rset.getString("LastName") + "\nCheck In Date: " + rset.getDate("CheckInDate")
						+ "\t\t\tCheck Out Date: " + new Timestamp(checkOutDate.getTime()));
				System.out.println(
						"___________________________________________________________________________________________");
				System.out.println("Room Type: " + rset.getString("RoomType") + "\t\t\t\tExtra services used: \n");
				System.out.println("\nGym: \t\t\t\t\t\t" + gym);
				System.out.println("Cinema: \t\t\t\t\t" + cinema);
				System.out.println("Restaurant: \t\t\t\t\t" + restaurant);
				System.out.println("Pool: \t\t\t\t\t\t" + pool);
				System.out.println("Sauna: \t\t\t\t\t\t" + sauna);
				System.out.println(
						"-------------------------------------------------------------------------------------------");
				System.out.println("Total: \t\t\t\t\t\t" + balance + "\n");

				break;

			// Creates invoice for complete hotel service expences
			case 3:
				ResultSet res = st.executeQuery("SELECT * FROM hotel.information WHERE ID =" + userID);

				String typeOfRoom = "";
				Timestamp guestCheckIn = new Timestamp(0);
				String firstNameGuest = "";
				String lastNameGuest = "";
				int priceOfRoom = 0;

				// Adds values from database to variables
				while (res.next()) {
					typeOfRoom = res.getString("RoomType");
					guestCheckIn = res.getTimestamp("CheckInDate");
					firstNameGuest = res.getString("FirstName");
					lastNameGuest = res.getString("LastName");
				}
				res.close();

				// Stores room price depending on room type
				switch (typeOfRoom) {
				case "Single Room":
					priceOfRoom = room[0];
					break;
				case "Double Room":
					priceOfRoom = room[1];
					break;
				case "Apartment":
					priceOfRoom = room[2];
					break;
				}
				// Calculates days stayed by the guest
				java.util.Date guestCheckOut = new java.util.Date();
				long days = guestCheckOut.getTime() - guestCheckIn.getTime();
				days = TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);

				ResultSet resultSet = st.executeQuery("SELECT * FROM hotel.extra_service WHERE ID =" + userID + ";");

				int gym1 = 0, cinema1 = 0, restaurant1 = 0, pool1 = 0, sauna1 = 0, extraServiceTotal = 0;
				
				// Takes total balance of extra services from database and calculates overall total value of hotel services
				while(resultSet.next()) {
					gym1 = resultSet.getInt("Gym");
					cinema1 = resultSet.getInt("Cinema");
					restaurant1 = resultSet.getInt("Restaurant");
					pool1 = resultSet.getInt("Pool");
					sauna1 = resultSet.getInt("Sauna");
				}

				extraServiceTotal = gym1 + cinema1 + restaurant1 + pool1 + sauna1;
				long total = (days * priceOfRoom) + extraServiceTotal;

				// Prints invoice for all hotel expences guest used
				System.out.println("\n\t\t\t\t\tHOTEL INVOICE\n");

				System.out.println("\nFirst Name: " + firstNameGuest + "\t\t\t\tLast Name: " + lastNameGuest
						+ "\nCheck In Date: " + guestCheckIn.toString() + "\t\tCheck Out Date: "
						+ new Timestamp(guestCheckOut.getTime()));
				System.out.println(
						"___________________________________________________________________________________________");
				System.out.println("Room Type: " + typeOfRoom + "\t\t\t\tNights stayed: " + days + "\n\nRoom Price: \t\t\t\t\t"
						+ priceOfRoom);
				System.out.println("\nExtra services used: ");
				System.out.println("Gym: \t\t\t\t\t\t" + gym1);
				System.out.println("Cinema: \t\t\t\t\t" + cinema1);
				System.out.println("Restaurant: \t\t\t\t\t" + restaurant1);
				System.out.println("Pool: \t\t\t\t\t\t" + pool1);
				System.out.println("Sauna: \t\t\t\t\t\t" + sauna1);
				System.out.println("\nExtra services total: \t\t\t\t" + extraServiceTotal);
				System.out.println(
						"-------------------------------------------------------------------------------------------");
				System.out.println("Total: \t\t\t\t\t\t" + total + "\n");

				resultSet.close();

				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
