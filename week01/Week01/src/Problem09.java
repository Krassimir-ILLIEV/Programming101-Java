
public class Problem09 {
	
	//9. Find the largest integer palindrome number up to N

	//long getLargestPalindrome(long N);

	//1234321 is a palindrome. You are given a number => N. Find the largest number < N, that is a palindrome.

	//Bonus do this without using Collections.sort
	public static long getLargestPalindrome(long N) {
		String s = ((Long) N).toString();
		String palindrome = "";
		boolean flag = false;
		//System.out.println(N);
		for (int i = 0; i <= s.length() / 2; i++) {
			if (flag) {
				palindrome += "9";
			} else {
				if (s.charAt(i) <= s.charAt(s.length() - 1 - i)) {
					palindrome += s.charAt(i);
				} else {
					palindrome += s.charAt(s.length() - 1 - i);
					flag = true;
				}
			}
		}
		if (s.length() % 2 == 0) {
			palindrome = palindrome.substring(0, palindrome.length() - 1);
		}
		//System.out.println(palindrome);
		String palindromeFull = palindrome;
		int reverseUpTo;
		if (s.length() % 2 != 0) {
			reverseUpTo = palindrome.length() - 2;
		} else
			reverseUpTo = palindrome.length() - 1;
		for (int i = reverseUpTo; i >= 0; i--) {
			palindromeFull += palindrome.charAt(i);
		}
		//System.out.println(palindromeFull);
		return Long.parseLong(palindromeFull);

	}

	public static void main(String[] args){

				System.out.println(getLargestPalindrome(17473374));
	}
}
