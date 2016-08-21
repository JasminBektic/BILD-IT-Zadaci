package zadaci_20_08_2016;

class Zadatak3_StopwatchTest {

	static void main(String[] args) {
		int[] list = new int[100000];
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 100);
		}
		Stopwatch stopwatch = new Stopwatch();
		stopwatch.start();		//pocetak stopanja vremena
		sort(list);				//sortiranje brojeva
		stopwatch.stop();		//stop stopanju vremena
		System.out.println("Execution time of sorting 100,000 numbers using selection sort is " + stopwatch.getElapsedTime() + " miliseconds");		//ispis vremena
	}
		//selection sort metoda
	static void sort(int[] list) {
		for (int i = list.length - 1; i >= 1; i--) {
			int max = list[0];
			int maxIndex = 0;
			for (int j = 1; j <= i; j++) {
				if (max < list[j]) {
					max = list[j];
					maxIndex = j;
				}
			}
			if (maxIndex != i) {
				list[maxIndex] = list[i];
				list[i] = max;
			}
		}
	}
}
