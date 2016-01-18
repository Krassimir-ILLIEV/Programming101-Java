package _29_HackNumbers;

public class Problem29 {
	// 29. Hack Numbers

	// A hack number is an integer, that matches the following criteria:

	// The number, represented in binary, is a palindrome
	// The number, represented in binary, has an odd number of 1's in it

	// Example of hack numbers:

	// 1 is 1 in binary
	// 7 is 111 in binary
	// 7919 is 1111011101111 in binary

	// Implement the following functions:

	// isHack(n) -> checks if n is a hack number
	// nextHack(n) -> returns the next hack number, that is bigger than n

	// Few examples:

	// isHack(1) = True
	// nextHack(0) = 1

	// isHack(21) = True
	// nextHack(10) = 21

	// isHack(8191) = True
	// nextHack(8031) = 8191
	
	public static String toBinary(int n){
		String binary = "";
		for (int i = n; i > 0;) {
			binary = i % 2 + binary;
			i = i / 2;
		}
		return binary;
		//System.out.println(binary);
	}

	public static boolean isHack(int n) {
		
		int counter = 0;

		String binary=toBinary(n);
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) != binary.charAt(binary.length() - 1 - i)) {
				return false;
			}
		}

		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				counter++;
			}
		}
		System.out.println(counter);
		if (counter % 2 == 0)
			return false;
		return true;
	}

	public static int nextHack(int n) {
		if(n%2!=0) n++;
		while(true){
			
		if(isHack(n)) return n;
		
		nextHack(n+2);
		}
		
		
	}

	public static void main(String[] args) {
		System.out.println(isHack(8031));
		System.out.println(nextHack(8031));
	}

}
