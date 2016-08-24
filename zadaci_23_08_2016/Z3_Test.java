package zadaci_23_08_2016;

public class Z3_Test {

	public static void main(String[] args) {
		Z3_MyPoint point1 = new Z3_MyPoint();			
		Z3_MyPoint point2 = new Z3_MyPoint(10, 30.5);	
		
		System.out.println("Distance: " + point1.distance(point2));		//ispis udaljenosti
	}
}
