package _07_KthFactorial;

public class Problem07 {
	//7. Kth factorial

	//long kthFac(int k, int n); Get the kthFactorial of n. k is guaranteed to be positive. 
	//Bonus no "helper" methods, no recursion :)

	// problem 7
		public static long kthFac(int k, int n) {
			long p = n;
			long f = 1;
			for (long i = 1; i <= k; i++) {
				for (long j = 1; j <= p; j++) {
					f *= j;
				}
				p = f;
				f = 1;
			}
			return p;
		}
		
		public static void main(String[] args){
			// problem 7
			System.out.println(kthFac(2, 3));
		}
}
