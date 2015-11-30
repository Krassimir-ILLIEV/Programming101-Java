
public class Problem14 {
	// 14. Max span

	// int maxSpan(int[] numbers) Consider the leftmost and righmost appearances
	// of some value in an array.
	// We'll say that the "span" is the number of elements between the two
	// inclusive.
	// A single value has a span of 1. Returns the largest span found in the
	// given array.

	// maxSpan({1, 2, 1, 1, 3}) → 4 maxSpan({1, 4, 2, 1, 4, 1, 4}) → 6
	// maxSpan({1, 4, 2, 1, 4, 4, 4}) → 6

	public static int maxSpan(int[] numbers) {
		int maxSpan = 0;

		for (int i = 0; maxSpan<numbers.length-i; i++) {
			for (int j = numbers.length - 1; j-i+1>maxSpan; j--) {
				if (numbers[i] == numbers[j]) {
					
					if (j - i+1 > maxSpan)
						maxSpan = j - i+1;

				}
			}
		}

		return maxSpan;

	}

	public static void main(String[] args) {
		int[] a={1, 2, 1, 1, 3};
		int[] b={1, 4, 2, 1, 4, 1, 4};
	    int[] c={1, 4, 2, 1, 4, 4, 4};
		System.out.println(maxSpan(a)); // → 4 
		System.out.println(maxSpan(b));// → 6
		System.out.println(maxSpan(c));//) → 6
	}
}
