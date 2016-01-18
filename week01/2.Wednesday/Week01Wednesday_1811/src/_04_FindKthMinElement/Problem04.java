package _04_FindKthMinElement;
import java.util.Arrays;

public class Problem04 {
	
	//4. Find the kth minimal element of an array

	//int kthMin(int k, int[] array)
	

	// problem 4 - Find the kth minimal element of an array
	public static int kthmin(int k, int[] a) {
		Arrays.sort(a); // heap solution is faster
		return a[k - 1];
	}
	
	public static void main(String[] args){
		// problem 4
		int[] b = { 4, 3, 2, 1, 0 };
		System.out.println(kthmin(4, b));
	}
}
