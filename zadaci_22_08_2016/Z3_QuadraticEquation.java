package zadaci_22_08_2016;

	/*
	 * Design a class named QuadraticEquation for a quadratic equation ax2 + bx + x = 0. The class contains:
	 * ■ Private data fields a, b, and c that represent three coefficients.
	 * ■ A constructor for the arguments for a, b, and c.
	 * ■ Three getter methods for a, b, and c.
	 * ■ A method named getDiscriminant() that returns the discriminant, which is b2 - 4ac.
	 * ■ The methods named getRoot1() and getRoot2() for returning two roots of the equation
	 * These methods are useful only if the discriminant is nonnegative. Let these methods return 0 if the discriminant is negative.
	 */

class Z3_QuadraticEquation {
	private double a;
	private double b;
	private double c;
	//konstruktor
	Z3_QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	//getteri za a, b i c
	double getA() {
		return a;
	}
	
	double getB() {
		return b;
	}
	
	double geC() {
		return c;
	}
	//metoda diskriminant
	double getDiscriminant() {
		return b * b - (4 * a * c);
	}
	//root1 metod za vracanje vrijednosti ako diskriminant nije nula
	double getRoot1() {
		if (getDiscriminant() < 0) {
			return 0;
		} 
		double r1 = (-b + Math.sqrt(getDiscriminant())) / (2 * a);
		return r1;
	}
	//root2 metoda vracanja vrijednosti ako diskriminant nije nula
	double getRoot2() {
		if (getDiscriminant() < 0) {
			return 0;
		}
		double r2 = (-b - Math.sqrt(getDiscriminant())) / (2 * a);
		return r2;
	}
}
