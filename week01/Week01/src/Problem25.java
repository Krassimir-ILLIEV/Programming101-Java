
public class Problem25 {
//25. Sum all the numbers in a String

//int sumOfNumbers(String input)

//Sum all of the numbers in the String. Ignore the characters. sumOfNumbers("abc123dd34") => 157 sumOfNumbers("12 99 1) => 112

public static int sumOfNumbers(String input){
	input=input.replaceAll("[^\\d.]"," ");

	String[] s=input.split(" ");
	int sum=0;
	for (int i=0; i<s.length;i++){
		if (s[i].length()!=0){
		sum +=Integer.parseInt(s[i]);
		}
	}
	return sum;	
}

public static void main(String[] args){
	System.out.println(sumOfNumbers("abc123dd34")); // =>157

	System.out.println(sumOfNumbers("12 99 1")); //=> 112
}

}
