package _04_SummationFunction;

public class SummationFunction {

	public static <T1 extends Number, T2 extends Number> double add(T1 first, T2 second){
		//return first.doubleValue()+second.doubleValue();
		return (Double) first+(Double) second;
	}
	
	public static void main(String[] args){
		SummationFunction sf=new SummationFunction();
		System.out.println(sf.<Double, Double>add(new Double(234.0), new Double(132.0)));
	}
}
