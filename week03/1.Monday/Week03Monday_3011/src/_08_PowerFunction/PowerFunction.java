package _08_PowerFunction;

public class PowerFunction {

	public static <T1 extends Number, T2 extends Number> double power(T1 first, T2 second){

		return Math.pow((Double) first,(Double) second);
	}
	public static void main(String[] args){
		PowerFunction pf=new PowerFunction();
		System.out.println(pf.<Double, Double>power(new Double(2.0),new Double(-3.09)));
	}
}
