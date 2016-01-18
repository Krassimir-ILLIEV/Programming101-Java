package _06_MultiplicationFunction;

public class MultiplicationFunction {

	public static <T1 extends Number, T2 extends Number> double multiply(T1 number1, T2 number2){
		return number1.doubleValue()*number2.doubleValue();
	}
	
	public static void main(String[] args){
		System.out.println(MultiplicationFunction.multiply(new Double(123), new Double(123.4)));
	}
}
