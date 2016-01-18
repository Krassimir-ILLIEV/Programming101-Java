package _03_FindMinimumElement;

public class Problem03 {
	//3. Find the minimum element of an array

	//int min(int... array)
	
	// problem 3 - Find the minimum element of an array
	public static int min(int[] a) {
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
		}
		return min;
	}

	public static void main(String[] args){
		// problem 3
		int[] a = { 4, 3, 2, 1, 0 };
		System.out.printf("min: %d ", min(a));
	}
}
