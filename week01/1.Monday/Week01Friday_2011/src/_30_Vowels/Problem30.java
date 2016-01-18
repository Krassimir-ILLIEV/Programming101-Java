package _30_Vowels;

public class Problem30 {
	// 30. Vowels in a string

	// Implement a function, called countVowels(str), which returns the count of
	// all vowels in the string str.

	// Count uppercase vowels as well!

	// The English vowels are aeiouy.

	// Examples:

	// * countVowels("Java") = 2
	// * countVowels("Theistareykjarbunga") = 8
	// * countVowels("grrrrgh!") = 0
	// * count_vowels("Github is the second best thing that happened to
	// programmers, after the keyboard!") = 22
	// * count_vowels("A nice day to code!") = 8

	public static int countVowels_helper(String str, String vowels) {
		int counter = 0;
		int index = 0;
		int i;
		for (int j = 0; j < vowels.length(); j++) {
			index=0;
			while ((i = str.indexOf(vowels.charAt(j), index)) > -1) {
				counter++;
				index = i + 1;
			}
		}
		//System.out.printf("index: %d, counter: %d\n", index, counter);
		return counter;
	}

	public static int countVowels_array(String str) {

		String lowerCase = "aeiouy";
		String upperCase = "AEIOUY";
		return countVowels_helper(str, lowerCase) + countVowels_helper(str, upperCase);

	}
	
	

	public static void main(String[] args) {
		System.out.println(countVowels_array("Java"));
	}
}
