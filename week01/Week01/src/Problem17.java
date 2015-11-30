
public class Problem17 {
	//17. Reverse a String

	//String reverseMe(String argument)
	public static String reverseMe(String argument){
		String reversed="";
		for (int i=argument.length()-1;i>=0;i--){
			reversed +=argument.charAt(i);
		}
		return reversed;
	}
	public static void main(String[] args){
		System.out.println(reverseMe("hop trop zmei"));
	}
}
