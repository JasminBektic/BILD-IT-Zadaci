package zadaci_05_09_2016;

import java.math.BigDecimal;

public class BigIntegerRational extends Number implements Comparable<BigIntegerRational> {
// Data fields for numerator and denominator
	private BigDecimal numerator = BigDecimal.ZERO;
	private BigDecimal denominator = BigDecimal.ONE;

 /** Construct a rational with default properties */
 public BigIntegerRational() {
	 this(BigDecimal.ZERO, BigDecimal.ONE);
 }

 /** Construct a rational with specified numerator and denominator */
 public BigIntegerRational(BigDecimal numerator, BigDecimal denominator) {
	 BigDecimal gcd = gcd(numerator, denominator);
     this.numerator = ((denominator.compareTo(BigDecimal.ZERO) > 0) ? BigDecimal.ONE : new BigDecimal(-1)).multiply(numerator).divide(gcd);
     this.denominator = denominator.abs().divide(gcd);
}
 
 /** Find GCD of two numbers */
 private static BigDecimal gcd(BigDecimal n, BigDecimal d) {
	 BigDecimal n1 = n.abs();
     BigDecimal n2 = d.abs();
     BigDecimal remainder = n1.remainder(n2);
     while (remainder.compareTo(BigDecimal.ZERO) > 0) {
         n1 = n2;
         n2 = remainder;
         remainder = n1.remainder(n2);
     }
     return n2;
}

 /** Return numerator */
 public BigDecimal getNumerator() {
	 return numerator;
}

 /** Return denominator */
 public BigDecimal getDenominator() {
	 return denominator;
}

 /** Add a rational number to this rational */
 public BigIntegerRational add(BigIntegerRational secondRational) {
	 BigDecimal n1 = numerator.multiply(secondRational.getDenominator());
     BigDecimal n2 = denominator.multiply(secondRational.getNumerator());
     BigDecimal n = n1.add(n2);
     BigDecimal d = denominator.multiply(secondRational.getDenominator());
     return new BigIntegerRational(n, d);
}

 /** Subtract a rational number from this rational */
public BigIntegerRational subtract(BigIntegerRational secondRational) {
	 BigDecimal n1 = numerator.multiply(secondRational.getDenominator());
     BigDecimal n2 = denominator.multiply(secondRational.getNumerator());
     BigDecimal n = n1.subtract(n2);

     BigDecimal d = denominator.multiply(secondRational.getDenominator());
     return new BigIntegerRational(n, d);
}

 /** Multiply a rational number by this rational */
 public BigIntegerRational multiply(BigIntegerRational secondRational) {
	 BigDecimal n = numerator.multiply(secondRational.getNumerator());
     BigDecimal d = denominator.multiply(secondRational.getDenominator());
     return new BigIntegerRational(n, d);
}

 /** Divide a rational number by this rational */
 public BigIntegerRational divide(BigIntegerRational secondRational) {
	 BigDecimal n = numerator.multiply(secondRational.getDenominator());
     BigDecimal d = denominator.multiply(secondRational.numerator);
     return new BigIntegerRational(n, d);
}

 @Override
 public String toString() {
	 if (denominator.equals(BigDecimal.ONE))
         return numerator + "";
    else
         return numerator + "/" + denominator;
 }

 @Override // Override the equals method in the Object class
 public boolean equals(Object other) {
	 if ((this.subtract((BigIntegerRational)(other))).getNumerator().equals(BigDecimal.ZERO))
         return true;
     else
         return false;
 }

 @Override // Implement the abstract intValue method in Number
 public int intValue() {
	 return (int)doubleValue();
 }

 @Override // Implement the abstract floatValue method in Number
 public float floatValue() {
	 return (float)doubleValue();
 }

 @Override // Implement the doubleValue method in Number
 public double doubleValue() {
	 return numerator.divide(denominator).doubleValue();
 }

 @Override // Implement the abstract longValue method in Number
 public long longValue() {
	 return (long)doubleValue();
 }

 @Override // Implement the compareTo method in Comparable
 public int compareTo(BigIntegerRational o) {
	 if (this.subtract(o).getNumerator().compareTo(BigDecimal.ZERO) > 0)
         return 1;
     else if (this.subtract(o).getNumerator().compareTo(BigDecimal.ZERO) < 0)
         return -1;
     else
         return 0;
 	}
}