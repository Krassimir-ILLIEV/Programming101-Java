package _08_SmallestMultiple;

public class Problem08 {
	// 8. Smallest multiple

	// long getSmallestMultiple(int upperBound);

	// Find the smallest (positive) number, that can be divided by each of the
	// numbers from 1 to upperBound.

	public static long getSmallestMultiple(int upperBound) {
		int[] divisors = new int[upperBound];
		long result = 1;
		int current = 1;
		int j;
		for (int i = 2; i <= upperBound; i++) {

			if (result % i != 0) {
				current = i;
				for (j = 0; divisors[j] != 0; j++) {
					
					if (current % divisors[j] == 0) {
						current = current / divisors[j];
						if (current== 1) {
							break;
						}

					}
				}
				if (current > 1) {
					divisors[j] = current;
					result *= current;
				}

			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(getSmallestMultiple(7));
	}
}
