package zadaci_05_09_2016;

public class Complex implements Cloneable {
	double a;
	double b;
	
	/* Default constructor */
	public Complex() {
		this(0);
	}
	
	public Complex(int a) {
		this(a, 0);
	}
	
	public Complex(double a, double b) {
		this.a = a;
        this.b = b;
	}
	
	/* Method adds new complex numbers */
	public Complex add(Complex com) {
		return new Complex((a + com.a), (b + com.b));
	}
	
	/* Method subtract complex numbers */
	public Complex subtract(Complex com) {
		return new Complex((a - com.a), (b - com.b));
	}
	
	/* Method for multiplication of complex numbers */
	public Complex multiply(Complex com) {
		return new Complex((a * com.a - b * com.b), (b * com.a + a * com.b));
	}
	
	/* Method for dividing complex numbers */
	public Complex divide(Complex com) {
		 return new Complex((a*com.a+b*com.b) / ((Math.pow(com.a, 2) + Math.pow(com.b, 2))), 
				 (b * com.a - a * com.b) / ((Math.pow(com.a, 2) + Math.pow(com.b, 2))));
	}
	
	public double abs() {
		 return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}
	
	/* a getter */
	public double getRealPart() {
		return a;
	}
	
	/* b getter */
	public double getImaginaryPart() {
		return b;
	}
	
	@Override
	public String toString() {
		if (b == 0) {
			return a + "";
		}
		return "(" + this.a + " + " + this.b + "i)";
	} 
}
