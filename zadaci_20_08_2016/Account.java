package zadaci_20_08_2016;

import java.util.Date;

	/*
	 * Design a class named Account that contains:
	 * ■ A private int data field named id for the account (default 0).
	 * ■ A private double data field named balance for the account (default 0).
	 * ■ A private double data field named annualInterestRate that stores the current interest rate (default 0). Assume all accounts have the same interest rate.
	 * ■ A private Date data field named dateCreated that stores the date when the account was created.
	 * ■ A no-arg constructor that creates a default account.
	 * ■ A constructor that creates an account with the specified id and initial balance.
	 * ■ The accessor and mutator methods for id, balance, and annualInterestRate.
	 * ■ The accessor method for dateCreated.
	 * ■ A method named getMonthlyInterestRate() that returns the monthly interest rate.
	 * ■ A method named getMonthlyInterest() that returns the monthly interest.
	 * ■ A method named withdraw that withdraws a specified amount from the account.
	 * ■ A method named deposit that deposits a specified amount to the account.
	 * 
	 * 
	 */

class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated = new Date();
	//no-arg konstruktor
	Account() {
		id = 0;
		balance = 0;
		annualInterestRate = 0;
	}
	//konstruktor
	Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}
	//getteri i setteri
	int getId() {
		return id;
	}
	
	void setId(int id) {
		this.id = id;
	}
	
	double getBalance() {
		return balance;
	}
	
	void setBalance(double balance) {
		this.balance = balance;
	}
	
	double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	//metoda za mjesecnu stopu
	double getMonthlyInterestRate() {
		double monthlyInterestRate = (annualInterestRate / 100) / 12;
		return balance * monthlyInterestRate;
	}
	//metod kada skidamo novac sa racuna
	void withdraw(double amount) {
		balance = balance - amount;
	}
	//metod kada dodajemo novac na racun
	void deposit(double amount) {
		balance = balance + amount;
	}
	//print stanja racuna, mjesecne naknade i datuma kad je acc kreiran
	void print() {
		System.out.printf("Balance: %6.2f\nMonthly interest: %4.2f\n", balance, getMonthlyInterestRate());
		System.out.println(dateCreated);
	}
}
