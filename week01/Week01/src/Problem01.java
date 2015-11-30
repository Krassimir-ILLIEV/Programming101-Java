
public class Problem01 {
	//1. Is it an odd number?

	//boolean isOdd(int n) Return whether n is an odd number
	

	public static boolean isOdd(int n) {
		return (n % 2 != 0);
	}
	
	public static void main(String[] args){
		// problem 1
		int N = 3;
		System.out.printf("if %d is odd: %b ", N, isOdd(N));
		System.out.println();
	}
}
