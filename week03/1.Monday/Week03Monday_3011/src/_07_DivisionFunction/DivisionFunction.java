package _07_DivisionFunction;

public class DivisionFunction{
	

	public static<T1 extends Number, T2 extends Number> double division(T1 number1, T2 number2){
		return number1.doubleValue()/number2.doubleValue();
	}
	
	public static void main(String[] args){
		DivisionFunction df=new DivisionFunction();
		System.out.println(df.division(new Double(234.0), new Double(132.0)));
	}
}
