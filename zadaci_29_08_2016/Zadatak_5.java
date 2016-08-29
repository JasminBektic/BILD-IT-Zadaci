package zadaci_29_08_2016;

	/*
	 * @author Jasmin Bektic
	 * 
	 * 
	 * Modify the Loan class in Listing 10.2 to throw IllegalArgumentException if the loan amount, 
	 * interest rate, or number of years is less than or equal to zero.
	 */

public class Loan {
	private double annualInterestRate;
	private int numberOfYears;
	private double loanAmount;
	private java.util.Date loanDate;
	//default konstruktor
	public Loan() {
		this(2.5, 1, 1000);
	}
	//konstruktor za zadanim vrijednostima
	public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
		if (loanAmount <= 0 || annualInterestRate <= 0 || numberOfYears <= 0) {
			throw new IllegalArgumentException("loanAmount, annualInterestRate and numberOfYears must be greater than 0");
		} else {
		this.annualInterestRate = annualInterestRate;
		this.numberOfYears = numberOfYears;
		this.loanAmount = loanAmount;
		loanDate = new java.util.Date();
		}
	}
	//getteri i setteri
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
		
	public void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate <= 0) {		//ako je 0 ili manje od nule throw new Exception
			throw new IllegalArgumentException("annualInterestRate must be greater than 0");
		} else {			//ako je vece od nula vrati vrijednost annualInterestRate
		this.annualInterestRate = annualInterestRate;
		}
	}
		
	public int getNumberOfYears() {
		return numberOfYears;
	}
		
	public void setNumberOfYears(int numberOfYears) {
		if (numberOfYears <= 0) {		//ako je 0 ili manje od nule throw new Exception
			throw new IllegalArgumentException("numberOfYears must be greater than 0");
		} else {		//ako je vece od nula, vrati vrijednost numberOfYears
		this.numberOfYears = numberOfYears;
		}
	}
		
	public double getLoanAmount() {
		return loanAmount;
	}
		
	public void setLoanAmount(double loanAmount) {
		if (loanAmount <= 0) {		//ako je 0 ili manje od nule throw new Exception
			throw new IllegalArgumentException("loanAmount must be greater than 0");
		} else {		//ako je veci od nule vrati vrijednost loanAmount
		this.loanAmount = loanAmount;
		}
	}
	
	public double getMonthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
		(1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
		return monthlyPayment;
	}
		
	public double getTotalPayment() {
		double totalPayment = getMonthlyPayment() * numberOfYears * 12;
		return totalPayment;
	}
		
	public java.util.Date getLoanDate() {
		return loanDate;
	}

	public static void main(String[] args) {
		Loan loan = new Loan(-1,1,1);
	}
}

