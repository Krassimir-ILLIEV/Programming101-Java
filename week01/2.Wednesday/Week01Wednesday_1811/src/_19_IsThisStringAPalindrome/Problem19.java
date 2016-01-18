package _19_IsThisStringAPalindrome;

public class Problem19 {
	//19. Is this string a palindrome

	//boolean isPalindrome(String argument)
	public static boolean isPalindrome(String argument){
		for (int i=0;i<argument.length()/2;i++){
		if (argument.charAt(i)!=argument.charAt(argument.length()-1-i))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isPalindrome("IvmvI"));
	}
}
