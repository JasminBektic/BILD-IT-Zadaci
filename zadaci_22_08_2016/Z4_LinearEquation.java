package zadaci_22_08_2016;

	/*
	 * Design a class named LinearEquation for a 2 * 2 system of linear equations.
	 * The class contains:
	 * ■ Private data fields a, b, c, d, e, and f.
	 * ■ A constructor with the arguments for a, b, c, d, e, and f.
	 * ■ Six getter methods for a, b, c, d, e, and f.
	 * ■ A method named isSolvable() that returns true if ad - bc is not 0.
	 * ■ Methods getX() and getY() that return the solution for the equation.
	 */

public class Z4_LinearEquation {
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;
	//konstruktor
	Z4_LinearEquation(double a, double b, double c, double d, double e, double f) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
	}
	//getteri
	double getA() {
		return a;
	}
	
	double getB() {
		return b;
	}
	
	double getC() {
		return c;
	}
	
	double getD() {
		return d;
	}
	
	double getE() {
		return e;
	}
	
	double getF() {
		return f;
	}
	//uslov za djelitelj
	boolean isSolvable() {
		if (a * d - b * c != 0) {
			return true;
		}
		return false;
	}
	//rezultat jednacine X
	double getX() {
		return (e * d - b * f) / (a * d - b * c);
	}
	//rezultat jednacine Y
	double getY() {
		return (a * f - e * c) / (a * d - b * c);
	}
}
