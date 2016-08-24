package zadaci_23_08_2016;

	/*
	 * @author Jasmin Bektic
	 */

public class Z3_MyPoint {
	double x, y;
	//no-arg konstruktor
	Z3_MyPoint() {
		x = 0;
		y = 0;
	}
	//konstruktor za odredjenim vrijednostima
	Z3_MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	//x-getter
	double getX() {
		return x;
	}
	//y-getter
	double getY() {
		return y;
	}
	//metoda koja izracunava udaljenost dvije tacke
	double distance(Z3_MyPoint n) {
		return distance(n.getX(), n.getY());
	}
	//metoda koja izracunava udaljenost dvije tacke
	double distance(double x, double y) {
		return Math.sqrt(Math.pow((x - this.x), 2) + Math.pow((y - this.y), 2));
	}
}
