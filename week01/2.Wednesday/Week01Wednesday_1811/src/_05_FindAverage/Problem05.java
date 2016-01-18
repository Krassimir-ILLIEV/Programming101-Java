package _05_FindAverage;

public class Problem05 {
	//5. Find the average(средно аритметично) of the elements of an array

	//int getAverage(int[] array);
	
	// problem 5
		public static double getAverage(int[] array) {
			double sum = 0;
			for (int a : array) {
				sum += a;
			}

			return sum / array.length;
		}

		// problem 6
		private static long factorial(long n) {
			if (n == 1)
				return n;
			else
				return n * factorial(n - 1);
		}
		
public static void main(String[] args){
	// problem 5
	int[] c = { 4, 3, 2, 1, 0 };
	System.out.println(getAverage(c));
}
}
