
public class Problem06 {

	//6. Double factorial

	//long doubleFac(int n); return E.g. if n=3, => (3!)! = 6! = 720 
	
	private static long factorial(long n){
		if(n==1||n==0) return 1;
		return n*factorial(n-1);
	}
	
	public static long doubleFac(int n) {

		/*
		 * long factorial=1; for(long i=1;i<=n;i++){ factorial *=i; } long
		 * twoFactorial; for(long l=1;l<=factorial;l++){ twoFactorial *=l;}
		 * return twoFactorial;
		 */
	
		return factorial(factorial((long) n));
	}

	
	public static void main(String[] args){
		// problem 6
				long L = 3;
				int P = 3;
				System.out.println(factorial(L));
				System.out.println(doubleFac(P));
	}
}
