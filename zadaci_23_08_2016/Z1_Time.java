package zadaci_23_08_2016;

	/*
	 * @author Jasmin Bektic
	 */

public class Z1_Time {
	long hour, minute, second;
	//no-arg konstruktor koji vraca tacno vrijeme
	Z1_Time() {
		setTime(System.currentTimeMillis());
	}
	//konstruktor koji milisekunde prosledjuje metodi te racuna u satima, minutama i sekundama
	Z1_Time(long n) {
		setTime(n);
	}
	//konstruktor sa odredjenim vrijednostima za sate, minute i sekunde
	Z1_Time(long hour, long minute, long second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	//getteri za sate, minute i sekunde
	long getGour() {
		return hour;
	}
	
	long getMinute() {
		return minute;
	}
	
	long getSecond() {
		return second;
	}
	//metoda koja izracunava sate, minute i sekunde iz datih milisekundi
	void setTime(long elapseTime) {
		second = elapseTime / 1000;
		minute = second / 60;
		hour = minute / 60;
		hour = hour % 24;
		minute = minute % 60;
		second = second % 60;;
	}
}
