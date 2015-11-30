
public class Problem02 {

	//2. Is N prime?

//boolean isPrime(int N)
	// problem 2 - Is N prime?
	public static boolean isPrime(int N) {
		if (N < 2)
			return false;
		for (int i = 2; i <= N / i; i++) {
			if (N % i == 0)
				return false;
		}

		return true;
	}
	
	public static void main(String[] args){

		int m = 51;
		System.out.printf("\"%d is prime\" is %b ", m, isPrime(m));
		System.out.println();
	}
}
