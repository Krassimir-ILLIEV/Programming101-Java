import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputChecker{

	private interface Validator{
		public boolean validate(String input);
	}
		
		
	public class PersonNameValidator implements Validator{
		public boolean validate(String input){
			
			return true;//??????????????/
			
			
		}
	}
	
	/*
	 
	 
	^ # Assert position at the beginning of the string.
	 \+ # Match a literal "+" character.
	 (?: # Group but don't capture:
	 [0-9] # Match a digit.
	 \\s # Match a space character
	 ? # between zero and one time.
	 ) # End the noncapturing group.
	 {6,14} # Repeat the group between 6 and 14 times.
	 [0-9] # Match a digit.
	 $ # Assert position at the end of the string.
	 
	 */
	 
	//BulgarianPhoneNumberValidator
	public class BulgarianPhoneNumberValidator implements Validator{
		public boolean validate(String input){
		
			//String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
			 
			String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
			Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(input);
		    return matcher.matches();
		}
	}
	
	public static class PersonAgeValidator implements Validator{
		public boolean validate(String input){

			//String regex ="^([0]?[1-9]{1,3})$";
			String regex="^(([1][0-2][0-9])|([1-9][0-9])|[0-9])$";
			Pattern pattern = Pattern.compile(regex);
		    Matcher matcher = pattern.matcher(input);
		    return matcher.matches();
		}
	}
	
	
	public class CreditCardNumberValidator implements Validator{
	
		public boolean validate(String card){
			
	String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
	        "(?<mastercard>5[1-5][0-9]{14})|" +
	        "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
	        "(?<amex>3[47][0-9]{13})|" +
	        "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
	        "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
	 
	Pattern pattern = Pattern.compile(regex);
	 
	
	    //Strip all hyphens
	    card = card.replaceAll("-", "");
	 
	    //Match the card
	    Matcher matcher = pattern.matcher(card);
	 
	    boolean ifCard = matcher.matches();
	 return ifCard;
	    //if(ifCard) {
	        //If card is valid then verify which group it belong
	        //System.out.println(matcher.group("mastercard"));
	   // }
	}
	}
	//IpVersion4Validator /????????????????????????????????????????????????????????
	//IpVersion6Validator /????????????????????????????????????????????????????????
	public static class MacAddressValidator implements Validator{
		public boolean validate(String input){
			String regex="^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
			//String regex="^([[:xdigit:]]{2}[:.-]?){5}[[:xdigit:]]{2}$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher=pattern.matcher(input);
			return matcher.matches();
			
			//^(?:[[:xdigit:]]{2}([-:]))(?:[[:xdigit:]]{2}\1){4}[[:xdigit:]]{2}$/
			 //:xdigit: is short for hex digit, more-or-less another way of saying [a-fA-F0-9]. 
			//The \1 refers to the capture group for the first dash or colon ([-:]), and only matches what matched that first time.
		
		}
		
		  	
	}
	
 
		


	
	public static Validator factory(){
		return new PersonAgeValidator();
	}
	
	public static void main(String[] args){
	
		//Validator pav= new PersonAgeValidator();
		//System.out.println(pav.validate("1.0"));
		
		Validator mac= new MacAddressValidator();
		System.out.println(mac.validate("01.02:03.04.ab.cd"));

		//01:02:03:04:ab:cd
		//01-02-03-04-ab-cd
		//01.02.03.04.ab.cd
		//0102-0304-abcd
		//01020304abcd
	}
}

