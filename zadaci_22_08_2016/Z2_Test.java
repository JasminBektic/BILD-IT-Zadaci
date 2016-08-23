package zadaci_22_08_2016;

public class Z2_Test {

	public static void main(String[] args) {
		
		//kreiranje poligona
		Z2_RegularPolygon polygon1 = new Z2_RegularPolygon();
		Z2_RegularPolygon polygon2 = new Z2_RegularPolygon(6, 4);
		Z2_RegularPolygon polygon3 = new Z2_RegularPolygon(10, 4, 5.6, 7.8);
		
		//ispis obima i povrsine za sva tri poligona
		System.out.println("Perimeter \tArea");
		System.out.printf("%4.2f\t\t%4.2f\n", polygon1.getPerimeter(), polygon1.getArea());
		System.out.printf("%4.2f\t\t%4.2f\n", polygon2.getPerimeter(), polygon2.getArea());
		System.out.printf("%4.2f\t\t%4.2f\n", polygon3.getPerimeter(), polygon3.getArea());
	}
}
