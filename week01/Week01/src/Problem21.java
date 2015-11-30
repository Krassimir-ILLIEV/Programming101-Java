
public class Problem21 {
	// 21. Copy every character K times

	// String copyEveryChar(String input, int k)

	// copyEveryChar("tldr", 3) => "tttllldddrrr"
	public static String copyEveryChar(String input, int k) {
		String s = "";
		
			for (int j = 0; j < input.length(); j++) {
				for (int i = 1; i <= k; i++){
				s += input.charAt(j);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(copyEveryChar("chetiri", 4));

	}
}
