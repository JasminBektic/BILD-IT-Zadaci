package zadaci_20_08_2016;

	/*
	 * Design a class named StopWatch. The class contains:
	 * ■ Private data fields startTime and endTime with getter methods. 
	 * ■ A no-arg constructor that initializes startTime with the current time.
	 * ■ A method named start() that resets the startTime to the current time.
	 * ■ A method named stop() that sets the endTime to the current time.
	 * ■ A method named getElapsedTime() that returns the elapsed time for the stopwatch in milliseconds.
	 * 
	 * Draw the UML diagram for the class and then implement the class. Write a test program that measures the execution time of 
	 * sorting 100,000 numbers using selection sort.
	 */

class Stopwatch {
	private long startTime;
	private long endTime;
	//no-arg konstruktor
	Stopwatch() {
		this.startTime = System.currentTimeMillis();
	}
	//getter pocetka vremena
	long getStartTime() {
		return startTime;
	}
	//getter stop vremena
	long getEndTime() {
		return endTime;
	}
	//start metoda
	void start() {
		this.startTime = System.currentTimeMillis();
	}
	//stop metoda
	void stop() {
		this.endTime = System.currentTimeMillis();
	}
	//stopano vrijeme
	long getElapsedTime() {
		return getEndTime() - getStartTime();
	}
	
}