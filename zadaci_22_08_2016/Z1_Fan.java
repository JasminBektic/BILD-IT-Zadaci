package zadaci_22_08_2016;

	/*
	 * Design a class named Fan to represent a fan. The class contains: 
	 * ■ Three constants named SLOW, MEDIUM, and FAST with the values 1, 2, and 3 to denote the fan speed.
	 * ■ A private int data field named speed that specifies the speed of the fan (the default is SLOW).
	 * ■ A private boolean data field named on that specifies whether the fan is on (the default is false).
	 * ■ A private double data field named radius that specifies the radius of the fan (the default is 5).
	 * ■ A string data field named color that specifies the color of the fan (the default is blue).
	 * ■ The accessor and mutator methods for all four data fields.
	 * ■ A no-arg constructor that creates a default fan.
	 * ■ A method named toString() that returns a string description for the fan. If the fan is on, the method returns the fan speed, color, and radius in one combined string. 
	 * If the fan is not on, the method returns the fan color and radius along with the string “fan is off” in one combined string. Draw the UML diagram for the class 
	 * and then implement the class. Write a test program that creates two Fan objects. Assign maximum speed, radius 10, color yellow, and turn it on to the first 
	 * object. Assign medium speed, radius 5, color blue, and turn it off to the second object. Display the objects by invoking their toString method.
	 */

public class Z1_Fan {

	public static final int SLOW = 1;
	public static final int MEDIUM = 2;
	public static final int FAST = 3;
	private int speed;
	private double radius;
	private boolean on;
	String color;
	//konstruktor
	Z1_Fan() {
		speed = SLOW;
		radius = 5;
		on = false;
		color = "blue";
	}
	//getteri i setteri
	public int getSpeed() {
		return speed;
	}
	//podesavanje brzine
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
	public double getRadius() {
		return radius;
	}
	//podesavanje poluprecnika
	public void setRadius(double newRadius) {
		radius = newRadius;
	}
	
	public String getColor() {
		return color;
	}
	//podesavanje boje
	public void setColor(String newColor) {
		color = newColor;
	}
	
	public boolean isOn() {
		return on;
	}
	//podesavanje statusa upaljen/ugasen
	public void setOn(boolean newOn) {
		on = newOn;
	}
	//metoda koja vraca rezultat i stanje ventilatora
	public String toString() {	
		if (on) {
		return "Speed is: " + speed + "\tRadius is: " + radius + "\tColor is: " + color;
	} 		else {
			return "Fan is off!" + "\tRadius is: " + radius + "\tColor is: " + color;
		}
	}
}