package group_project;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * First assignment:
	 * - Get familiar with SQL/MySQL
	 * - Play around with world.sql database
	 * - Connect to SQL database using Java with JDBC
	 * - Optional: Provide SQL statements at the end
	 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Assignment_zero {
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Search database by country name, city name or country population:");
		String s = input.next();
		input.close();
		select(s);
	}
	
	/** Connection confirmation */
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String user = "root";
			String pass = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, pass);
			System.out.println("Connected to database.\n");
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/** Method providing information from SQL database */
	public static void select(String s) {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT City.ID, Country.Code, Country.Name as 'Country Name', "
					+ "Country.GovernmentForm, Country.Region, Country.Continent, CountryLanguage.Language, Country.HeadOfState, "
					+ "Country.Population AS 'Country Population', City.Name AS 'Capital', City.Population AS 'Capital Population', "
					+ "City.District AS 'Capital District', Country.GNP, Country.LifeExpectancy, Country.IndepYear, "
					+ "Country.SurfaceArea FROM Country, City, CountryLanguage WHERE Country.Capital = City.ID AND "
					+ "Country.Code = CountryLanguage.CountryCode AND (Country.Name = ? OR City.Name = ? OR Country.Population = ?)");
			statement.setString(1, s);
			statement.setString(2, s);
			statement.setString(3, s);
			ResultSet result = statement.executeQuery();
			ResultSetMetaData rsmd = result.getMetaData();
			
			int columnCount = rsmd.getColumnCount();
			String format = "%-30s";
			
			//Column names
			for (int i = 1; i <= columnCount; i++) {
				System.out.printf(format, rsmd.getColumnLabel(i));
			}
			System.out.println();
			
			//Underline
			for (int i = 1; i <= columnCount * 30; i++) {
				System.out.print("_");
			}
			System.out.println();
			
			//Information from database
			while (result.next()) {
			    for (int i = 1; i <= columnCount; i++) {
			        System.out.printf(format, result.getString(i));
			    }
			    System.out.println();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}


		/** SQL statements */

/*
 * 		-Search query by country name-
 *  SELECT c.Name AS 'Country Name', c.Code, cb.Language, c.Region, ct.Name AS Capital, c.LifeExpectancy AS 'Life Expectancy', 
	c.GNPOld AS 'GNP Old', c.GNP AS 'GNP New', c.SurfaceArea AS 'Surface Area', c.IndepYear AS 'Independence Year', 
	c.LocalName AS 'Local Name', c.GovernmentForm AS 'Government Form', c.HeadOfState AS 'Head Of State', c.Population, c.Continent
		FROM Country AS c
		JOIN Countrylanguage AS cb
		JOIN City AS ct
			ON ct.ID = c.Capital AND cb.CountryCode = c.Code
		WHERE c.Name = 'Bosnia and Herzegovina';
 */


/*
 * 		-Search query by city name-
 * SELECT c.ID, c.Name AS 'City Name', c.CountryCode AS 'Country Code', c.District, c.Population AS 'City Population', 
   ct.Population AS 'Country Population', ct.Name AS Country, ct.Continent
   		FROM City AS c
		JOIN Country AS ct
			ON ct.Code = c.CountryCode
		WHERE c.Name = 'Sarajevo';
 */


/*
 * 		-Search query by population size-
 * SELECT c.Name AS 'Country Name', c.Code, c.Region, ct.Name AS Capital, c.LifeExpectancy AS 'Life Expectancy', 
   c.GNPOld AS 'GNP Old', c.GNP AS 'GNP New', c.SurfaceArea AS 'Surface Area', c.IndepYear AS 'Independence Year', 
   c.LocalName AS 'Local Name', c.GovernmentForm AS 'Government Form', c.HeadOfState AS 'Head Of State', c.Population, 
   c.Continent
		FROM Country AS c
		JOIN City AS ct
			ON ct.ID = c.Capital
		WHERE c.Population BETWEEN 1000000 AND 1500000;
 */
