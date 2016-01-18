/* Example 8.1: ConvertWithQuery.java
 Repeatedly convert from Fahrenheit to Celsius until the user signals the end.
 */

import java.util.Scanner;

public class ConvertWithQuery {

	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		Thermometer thermo=new Thermometer();
		String doItAgain="y";
		
		while(doItAgain.equals("y")||doItAgain.equals("Y")){
			System.out.print("\nEnter degrees Fahrenheit: ");
			thermo.setFahrenheit(reader.nextDouble());
			//Consume the trailing newline
			reader.nextLine();
			System.out.println("The equivalent in Celsius is "+thermo.getCelsius());
			System.out.print("\nDo it again (y/n)? ");
			doItAgain=reader.nextLine();
		}
	}
}
