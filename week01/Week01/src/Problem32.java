
public class Problem32 {
	// 32. Palindrome Score

	// We denote the "Palindrome score" of an integer by the following function:

	// P(n) = 1, if n is palindrome
	// P(n) = 1 + P(s) where s is the sum of n and the reverse of n

	// Implement a function, called pScore(n), which finds the palindrome score
	// for n.

	// Lets see two examples:

	// pScore(121) = 1, because 121 is a palindrome.

	// pScore(48) = 3, because:

	// P(48) = 1 + P(48 + 84) = 132
	// P(132) = 1 + 1 + P(132 + 321 = 363)
	// P(363) = 1.
	// When we return from the recursion, we get 3.

	// Examples:

	// * pScore(121) = 1
	// * pScore(48) = 3
	// * pScore(198) = 6

	private static int reverse(int n) {
		String s = ((Integer) n).toString();
		String reversed = "";
		for (int i = 0; i < s.length(); i++) {
			reversed += s.charAt(s.length() - 1 - i);
		}
		return Integer.parseInt(reversed);
	}

	public static int pScore(int n) {
		boolean isPalindrome = true;
		String s = ((Integer) n).toString();
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}
		if (isPalindrome) {
			return 1;
		} else
			return 1 + pScore(n + reverse(n));
	}

	public static void main(String[] args) {
		System.out.println(pScore(48));// = 1 + P(48 + 84) = 132
		System.out.println(pScore(132)); // = 1 + 1 + P(132 + 321 = 363)
		System.out.println(pScore(363)); // = 1
		System.out.println(pScore(121));// = 1
		System.out.println(pScore(48));// = 3
		System.out.println(pScore(198));// = 6
	}
}
