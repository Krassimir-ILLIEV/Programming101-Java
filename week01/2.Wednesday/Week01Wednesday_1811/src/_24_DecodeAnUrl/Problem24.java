package _24_DecodeAnUrl;

public class Problem24 {
	
	//24. Decode an URL

	//Input 'kitten%20pic.jpg' Output 'kitten pic.jpg' %20=>' ' %3A=>':' %3D=>'?' %2F=>'/' String decodeUrl(String input)
	
	public static String decodeUrl(String input){
		String[] s_old="%20,%3A,%3D,%2F".split(",");
		String[] s_new=" ,:,?,/".split(",");
		for(int i=0;i<s_old.length;i++){
		input=input.replaceAll(s_old[i],s_new[i]);
		}
	return input;	
	}
	
	public static void main(String[] args){
		System.out.println(decodeUrl("kitten%20pic.jpg"));
	}
}
