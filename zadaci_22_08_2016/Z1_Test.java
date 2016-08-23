package zadaci_22_08_2016;

public class Z1_Test {

	public static void main(String[] args) {
		Z1_Fan fan1 = new Z1_Fan();
		fan1.setSpeed(fan1.FAST);		//brzina prvog ventilatora na max
		fan1.setRadius(10);				//mjenjamo poluprecnik
		fan1.setColor("yellow");		//mjenjamo boju
		fan1.setOn(true);				//ventilator upaljen
		
		Z1_Fan fan2 = new Z1_Fan();
		fan2.setSpeed(fan1.MEDIUM);		//mjenjamo brzinu drugog ventilatora
		
		System.out.println(fan1.toString());
		System.out.println(fan2.toString());
	}
}
