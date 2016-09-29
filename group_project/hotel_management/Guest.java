package group_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class Guest extends Admin {
	String userOnline;
	
	public Guest() {
		
	}
	
	public String getESDateUpdate() throws Exception {
		String query = "SELECT DateUpdate FROM extra_service WHERE ID = ?";
		PreparedStatement statement = getConnection().prepareStatement(query);
		statement.setInt(1, getId());
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			esDateUpdate = rs.getString(1);
		}
		return esDateUpdate;
	}
	
	public String getRoomDateUpdate() throws Exception {
		String query = "SELECT DateUpdate FROM room WHERE ID = ?";
		PreparedStatement statement = getConnection().prepareStatement(query);
		statement.setInt(1, getId());
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			roomDateUpdate = rs.getString(1);
		}
		return roomDateUpdate;
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Guest main menu
	 */
	public void guestMenu() throws Exception {
		System.out.println("\t--MENU--");
		System.out.println("1- Check current service charges\n2- Order extra service\n3- Change room\n4- Check out\n5- Log Out\n6- Exit");
		int option = input.nextInt();
		switch (option) {
			case 1: checkMyBalance(); break;
			case 2: orderExtraService(); break;
			case 3: orderNewRoom(); break;
			case 4: userCheckOut(); break;
			case 5: list.remove(list.size() - 1);
					System.out.println("You are logged out!\n");
					Hotel.main(null); break;
			case 6: Hotel.main(null); break;
		}
	}
	
	/* 
	 * @author Jasmin Bektic
	 * 
	 * Method acting like LogIn form 
	 */
	public void logIn() throws Exception {
		Statement s = getConnection().createStatement();
		ResultSet rs = null;

		//username and pass input
		boolean boo = true;
		while (boo) {
			System.out.println("Enter username:");
			userName = input.next();
			System.out.println("Enter password:");
			password = input.next(); 
			s.executeQuery("SELECT UserName, Password FROM information");
			rs = s.getResultSet();
			
			//Processing current data and comparing to data from database
			while (rs.next()) {
				String user = rs.getString("UserName");
				String pass = rs.getString("Password");
				if (userName.equals(user) && password.equals(pass)) {
					boo = false;
					break;
				} 
			}
			//Supporting message, in case of input failure
			if (boo == true) System.out.println("Incorrect user name or password, try again:");
		}
		System.out.println();
		
		//Add username in array
		PreparedStatement statement = getConnection().prepareStatement("SELECT UserName FROM information WHERE information.UserName = ?");
		statement.setString(1, userName);
		userOnline = (rs.getString(1));
		setList(userOnline);
	}
	
	/*
	 * @author Maja Vasilic
	 * 
	 * Method retrieving information from "information" table
	 * @throws Exception 
	 */
	public void userCheckOut() throws Exception {
		Connection conn = getConnection();
		
		//Select data from information and copy to archive table
		PreparedStatement statement = conn.prepareStatement("SELECT FirstName, LastName, Gender, IdentityCard, Age FROM information WHERE ID = "+getId()+"");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			firstName = rs.getString("FirstName");
			lastName = rs.getString("LastName");
			gender = rs.getString("Gender");
			identityCard = rs.getString("IdentityCard");
			age = rs.getInt("Age");
		}
		//Send check out request to admin
		String sql = "INSERT INTO archive (FirstName, LastName, Gender, IdentityCard, Age) VALUES ('"+firstName+"', '"+lastName+"', '"+gender+"', '"+identityCard+"', "+age+")";
		String information = id +"#"+ firstName +" "+ lastName +"#"+ sql;
		checkOut.add(information);
		System.out.println("Request has been sent!\n");
		guestMenu();
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method helping guest to check his/her current balance track
	 */
	public void checkMyBalance() throws Exception {
		ArrayList<String> services = new ArrayList<>();
		int sumES = 0;
		int sumRoom = 0;
		
		//Get balance for extra service
		String query1 = "SELECT Gym, Cinema, Restaurant, Pool, Sauna, Balance FROM extra_service WHERE ID = ?";
		PreparedStatement statement = getConnection().prepareStatement(query1);
		statement.setInt(1, getId());
		ResultSet rs = statement.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int esColumnBalance = 0;
		String str = "";
		services.add("Extra services\n---------------");
		
		//Add column name and data to string
		while (rs.next()) {
			for (int i = 0; i < 5; i++) {
				int num = rs.getInt(i + 1);
				String columnName = rsmd.getColumnName(i + 1);
				sumES += num;
				if (num > 0) {
					str = columnName + ": " + num + " $";
					services.add(str);
				}
			}
			esColumnBalance = rs.getInt("Balance");
		}
		//If current balance is zero, just add sum
		int esBalance = 0;
		if (esColumnBalance == 0) {
			esBalance = sumES;
		} else {
			esBalance = balance(getESDateUpdate(), sumES);
		}
		
		//Get balance for room
		String query2 = "SELECT SingleRoom, DoubleRoom, Apartment, Balance FROM room WHERE ID = ?";
		PreparedStatement s = getConnection().prepareStatement(query2);
		s.setInt(1, getId());
		ResultSet result = s.executeQuery();
		ResultSetMetaData r = result.getMetaData();
//		int roomColumnBalance = 0;
		services.add("\nRoom\n-----");
		
		//Add column name and data to string
		while (result.next()) {
			for (int i = 0; i < 3; i++) {
				int num = result.getInt(i + 1);
				String columnName = r.getColumnName(i + 1);
				sumRoom += num;
				if (num > 0) {
					str = columnName + ": " + num + " $";
					services.add(str);
				}
			}
//			roomColumnBalance = result.getInt("Balance");
		}
		//If current balance is zero, just add sum
		int roomBalance = 0;
		if (roomBalance == 0) {
			roomBalance = sumRoom;
		} else {
			roomBalance = balance(getRoomDateUpdate(), sumRoom);
		}
		
		//Printing current service charge
		System.out.println("--Current service charges--\n");
		for (String ex : services) {
			System.out.println(ex);
		}
		System.out.println("\n\nTotal: " + (esBalance + roomBalance) + " $");
		System.out.println("===================\n");
		guestMenu();
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method is used for ordering new extra service and admin to approve them
	 */
	public void orderExtraService() throws Exception {
		int[] extraService = new int[5];
		int sum = 0;
		
		//Getting old extra service prices and sum
		String query = "SELECT Gym, Cinema, Restaurant, Pool, Sauna FROM extra_service WHERE ID = ?";
		PreparedStatement statement = getConnection().prepareStatement(query);
		statement.setInt(1, getId());
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			for (int i = 0; i < 5; i++) {
				extraService[i] = rs.getInt(i + 1);
				sum += rs.getInt(i + 1);
			}
		}
		int balance = balance(getESDateUpdate(), sum);
		
		//Ordering new services and saving in array along with dateUpdate
		System.out.println("1- Gym\n2- Cinema\n3- Restaurant\n4- Pool\n5- Sauna\n\n0- Finish my order");
		int index = 0;
		ArrayList<Integer> lastOrder = new ArrayList<>();
		while (true) {
			System.out.println("\nOrder service entering adequate number or finish your order:");
			index = input.nextInt();
			if (index == 0) break;
			lastOrder.add(index);		//used for sending information to admin
			extraService[index - 1] = this.extraService[index - 1];
		}
		//Get old balance and add new one
		PreparedStatement st = getConnection().prepareStatement("SELECT Balance FROM extra_service WHERE ID = ?");
		st.setInt(1, getId());
		ResultSet result = st.executeQuery();
		if (result.next()) {
			balance += result.getInt("Balance");
		}
		//Get first and last name from information table and add to string
		PreparedStatement stat = getConnection().prepareStatement("SELECT FirstName, LastName FROM information WHERE ID = ?");
		stat.setInt(1, getId());
		ResultSet res = stat.executeQuery();
		String information = "";
		while (res.next()) {
			String info1 = res.getString("FirstName");
			String info2 = res.getString("LastName");
			information = info1 + " " + info2 + " ordering new services:\n";
		}
		//Assign proper string option to information string
		for (int i = 0; i < lastOrder.size(); i++) {
			switch (lastOrder.get(i)) {
				case 1: information += "Gym\n"; break;
				case 2: information += "Cinema\n"; break;
				case 3: information += "Restaurant\n"; break;
				case 4: information += "Pool\n"; break;
				case 5: information += "Sauna\n"; break;
			}
		}
		//Save all information in array
		String sql = "UPDATE extra_service SET Gym = "+extraService[0]+", Cinema= "+extraService[1]+", Restaurant= "+extraService[2]+", Pool = "+extraService[3]+", Sauna = "+extraService[4]+", Balance = "+balance+", DateUpdate = '"+dateTime+"' WHERE ID = "+getId()+"";
		orderNewES.add(information);
		orderNewES.add(sql);
		System.out.println("Request has been sent!\n");
		guestMenu();
	}
	
	/*
	 * @author Jasmin Bektic
	 * 
	 * Method from which guest can order new room
	 */
	public void orderNewRoom() throws Exception {
		String newRoom = roomType();
		int[] room = new int[3];
		int sum = 0;
		
		//Get current room price 
		String query = "SELECT SingleRoom, DoubleRoom, Apartment FROM room WHERE ID = ?";
		PreparedStatement statement = getConnection().prepareStatement(query);
		statement.setInt(1, getId());
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			for (int i = 0; i < 3; i++) {
				sum += rs.getInt(i + 1);
			}
		}
		int balance = balance(getRoomDateUpdate(), sum);
		
		//Get old balance and add new one
		PreparedStatement st = getConnection().prepareStatement("SELECT Balance FROM room WHERE ID = ?");
		st.setInt(1, getId());
		ResultSet result = st.executeQuery();
		if (result.next()) {
			balance += result.getInt("Balance");
		}
		switch (newRoom) {
			case "Single Room": room[0] = this.room[0];room[1] = 0;room[2] = 0; break;
			case "Double Room": room[1] = this.room[1];room[0] = 0;room[2] = 0; break;
			case "Apartment": room[2] = this.room[2];room[0] = 0;room[1] = 0; break;
		}
		//Get first and last name from information table and add to string
		PreparedStatement stat = getConnection().prepareStatement("SELECT FirstName, LastName FROM information WHERE ID = ?");
		stat.setInt(1, getId());
		ResultSet res = stat.executeQuery();
		String information = "";
		while (res.next()) {
			String info1 = res.getString("FirstName");
			String info2 = res.getString("LastName");
			information = info1 + " " + info2 + "\t\t";
		}
		//Assign proper string option to information string
			switch (sum) {
				case 20: information += "Single Room\t"; break;
				case 40: information += "Double Room\t"; break;
				case 60: information += "Apartment\t"; break;
			}
		information += newRoom;
		
		String sql = "UPDATE room SET SingleRoom = "+room[0]+", DoubleRoom = "+room[1]+", Apartment = "+room[2]+", Balance = "+balance+", DateUpdate = '"+dateTime+"' WHERE ID = "+getId()+"";
		orderNewRoom.add(information);
		orderNewRoom.add(sql);
		System.out.println("Request has been sent!\n");
		guestMenu();
	}
}
