package _18_ReverseEachWord;

public class Problem18 {
	// 18. Reverse each word in a String

	// String reverseEveryChar(String arg)

	// reverseEveryChar("What is this") => tahW si siht
	public static String reverseEveryChar(String arg) {
		String reversed = "";
		String[] a = arg.split(" ");
		for (int k = 0; k < a.length; k++) {
			for (int i = a[k].length() - 1; i >= 0; i--) {
				reversed += a[k].charAt(i);
			}
			reversed+=" ";
		}

		return reversed;

	}

	public static void main(String[] args) {
		System.out.println(reverseEveryChar("What is this"));
//keep white space System.getProperty("line.separator");
		//file.separator
	}
}
