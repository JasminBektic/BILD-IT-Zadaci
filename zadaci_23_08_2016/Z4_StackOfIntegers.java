package zadaci_23_08_2016;

	/*
	 * @author Jasmin Bektic
	 */

public class Z4_StackOfIntegers {
	int[] num;
	static final int DEFAULT_CAPACITY = 10;
	int size;
	//konstruktor sa default kapacitetom
	Z4_StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	//konstruktor za zadanim kapacitetom
	Z4_StackOfIntegers(int capacity) {
		num = new int[capacity];
	}
	//metoda za unos integera u stack
	int push(int value) {
		if (size >= num.length) {	//ako broj integera prodje velicinu kapaciteta, povecati kapacitet za duplo
			int[] temp = new int[num.length * 2];
			System.arraycopy(num, 0, temp, 0, num.length);
			num = temp;
		}
		return num[size++] = value;
	}
	//metoda koja vraca prvi integer sa vrha
	int pop() {
		return num[--size];
	}
}
