package zadaci_23_08_2016;

public class Z1_Test {

	public static void main(String[] args) {
		
		//kreiranje objekata Time
		Z1_Time time1 = new Z1_Time();
		Z1_Time time2 = new Z1_Time(555550000);
		
		//ispis vremena u formatu h:m:s (uzimamo u obzir vremensku zonu)
		System.out.printf("Current time: %d:%d:%d\n", time1.hour, time1.minute, time1.second);
		System.out.printf("Elapsed time: %d:%d:%d", time2.hour, time2.minute, time2.second);
	}
}
