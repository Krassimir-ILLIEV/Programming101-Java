package _31_Consonants;
import java.util.Enumeration;
import java.util.Hashtable;

public class Problem31 {
	// 31. Consonants in a string

	// Implement a function, called countConsonants(str), which returns the
	// count of all consonants in the string str.

	// Count uppercase consonants as well!

	// The English consonants are bcdfghjklmnpqrstvwxz.

	// Examples:

	// * countConsonants("Java") = 2
	// * countConsonants("Theistareykjarbunga") = 11
	// * countConsonants("grrrrgh!") = 7
	// * countConsonants("Github is the second best thing that happend to
	// programmers, after the keyboard!") = 44
	// * countConsonants("A nice day to code!") = 6
	public static int countConsonants(String str) {
		int counter = 0;

		Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
		String bothCases = "bcdfghjklmnpqrstvwxzBCDFGHJKLMNPQRSTVWXZ";
		// String upperCase="BCDFGHJKLMNPQRSTVWXZ";

		for (int i = 0; i < bothCases.length(); i++) {
			ht.put(bothCases.charAt(i), 0);
		}

		//System.out.println(ht.size());
		Enumeration<Character> e = ht.keys();
		// while(e.hasMoreElements()){
		// System.out.println(e.nextElement());
		// }
		for (int i = 0; i < str.length(); i++) {
			if (ht.containsKey(str.charAt(i))) {
				counter++;
			}

		}
		// if (e.hasMoreElements()) return e.nextElement();

		return counter;
	}

	public static void main(String[] args) {
		System.out.println(countConsonants("Theistareykjarbunga")); // = 11
		System.out.println(
				countConsonants("Github is the second best thing that happend to programmers, after the keyboard!"));// =
		System.out.println(countConsonants("A nice day to code!"));// = 6																										// 44

	}

}
