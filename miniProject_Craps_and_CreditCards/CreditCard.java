package miniProjekat_Craps_and_CreditCards;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Credit card numbers follow certain patterns. A credit card number must have between 13 and 16 digits. 
	 * It must start with:
	 * 	4 for Visa cards
	 * 	5 for Master cards
	 * 	37 for American Express cards
	 * 	6 for Discover cards
	 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class CreditCard extends Application {
	Stage window;
    Scene scene1, scene2;

	public static void main(String[] args) {
		launch(args);
	}
		
	public void start(Stage primaryStage) {
		 window = primaryStage;

		 // Prostor za unosenje vrijednosti i njegove dimenzije
	     TextField input = new TextField();
	     input.setMaxSize(200, 10);
	        
	     // Button1 ce vrsiti provjeru unosa u TextField i provjeru 
	     // tri uslova za validnost kartice
	     Label label1 = new Label("Please enter you credit card number:");
	     Button button1 = new Button("Next >");
	     button1.setOnAction( e -> checkInput(input) );
	       
	     // Layout1 
	     VBox layout1 = new VBox(20);
	     layout1.setAlignment(Pos.CENTER);
	     layout1.getChildren().addAll(label1, input, button1);
	     scene1 = new Scene(layout1, 250, 150);
	     
	     // Program pocinje sa scene1 i eventualno zavrsava sa scene2 ili pop-up prozorom 
	     window.setScene(scene1);
	     window.setTitle("Bank Account Verification");
	     window.show();
	}
	
		 // Scene2, kreiran kao druga metoda zbog uslova u checkInput metodi
	 public void scene2() {
		 
		 // Button 2
	     Label label2 = new Label("Credit card is valid");
	     Button button2 = new Button("Close");
	     button2.setOnAction(e -> window.close());

	     // Layout 2
	     VBox layout2 = new VBox(20);
	     layout2.setAlignment(Pos.CENTER);
	     layout2.getChildren().addAll(label2, button2);
	     scene2 = new Scene(layout2, 250, 120);
	        
	     window.setScene(scene2);
	     window.setTitle("Bank Account Verification");
	     window.show();
	 }
	 
	 	// Metoda koja predstavlja pop-up prozor, namjenjen za prikaz greske pri unosu
	 public static void alert(String message) {
	     Stage window = new Stage();

	     // Blokira klikanje na druge povrsine sem pop-up
	     window.initModality(Modality.APPLICATION_MODAL);
	     window.setTitle("Alert");
	     window.setMinWidth(250);
	     window.setMinHeight(100);
	     
	     // Label
	     Label label = new Label();
	     label.setText(message);
	     Button closeButton = new Button("Close");
	     closeButton.setOnAction(e -> window.close());

	     // Layout
	     VBox layout = new VBox(10);
	     layout.getChildren().addAll(label, closeButton);
	     layout.setAlignment(Pos.CENTER);

	     // Pop-up ostaje aktivan
	     Scene scene = new Scene(layout);
	     window.setScene(scene);
	     window.showAndWait();
	 }
	
		// metoda za provjeru svih uslova koje zadatak nosi
	public static boolean isValid(long num) {
		int sum = sumOfDoubleEvenPlace(num) + sumOfOddPlace(num);
		if (getSize(num) < 13 || getSize(num) > 16) {			// duzina broja ne smije biti manja od 13 i veca od 16
			alert("Your credit card number is not long enough!");
			return false;
		}
		if (prefixMatched(num) == false) {					// ako uslov ne zadovoljava, odnosno ako je false, ispisi poruku
			alert("Your credit card does not start with suitable prefix!");
			return false;
		}
		if (sum % 10 != 0) {						// uslov sume parnih i neparnih brojeva koji mora biti djeljiv sa 10
			alert("Your credit card is invalid!");
			return false;
		}
		return true;
	}
	
		// metoda koja sumira sve cifre na parnim mjestima
	public static int sumOfDoubleEvenPlace(long number) {
		String num = Long.toString(number);
		int sum = 0;
		for (int i = num.length() - 2; i >= 0; i--, i--) {					// petlja ce brojati unazad, krenuvsi od predzadnjeg broja
			sum += getDigit((Character.getNumericValue(num.charAt(i))) * 2);	// suma svih cifri na parnim mjestima
		}
		return sum;
	}
	
		// metoda koja vraca zbir cifara
	public static int getDigit(int number) {
		int rem = number % 10;
		return rem + number / 10;
	}
	
		// metoda koja sumira sve cifre na neparnim mjestima
	public static int sumOfOddPlace(long number) {
		String num = Long.toString(number);
		int sum = 0;
		for (int i = num.length() - 1; i >= 0; i--, i--) {		// petlja ce brojati unazad, krenuvsi od zadnjeg broja
			sum += Character.getNumericValue(num.charAt(i));	// suma cifri na neparnim indeksima
		}
		return sum;
	}
	
		// metoda za ispitivanje odgovarajuceg prefixa
	public static boolean prefixMatched(long number) {
		String num = Long.toString(number);
		int[] prefix = {4, 5, 6, 37};					// lista prefixa za uporedbu
		for (int i = 0; i < prefix.length; i++) {
			if (Long.valueOf(num.substring(0, 2)) == prefix[i]) {	// uslov za dvocifreni prefix
				return true;
			} 
			if (Long.valueOf(num.substring(0, 1)) == prefix[i]) {	// uslov za jednocifreni prefix
				return true;
			}
		}
		return false;
	}
	
		// metoda za duzinu cifri u broju
	public static int getSize(long number) {
		String num = Long.toString(number);
		return num.length();				// vraca duzinu broja
	}
		// metoda za provjeru unosa
	public void checkInput(TextField number) {
		try {
			long num = Long.parseLong(number.getText());
			if (num < 0) 					// ako je negativan broj, pretvorit cemo ga u pozitivan
				num = Math.abs(num);
			if (isValid(num)) 
				scene2();
		}
		catch (Exception e) {				// hvatanje greske
			alert("Wrong input, try again!");
		}
	}
}
