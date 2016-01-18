package _05_SubtractionFunction;

public class SubtractionFunction {

	public static <T1 extends Number, T2 extends Number> double subtract(T1 first, T2 second){
		//return first.doubleValue()+second.doubleValue();
		return (Double) first- (Double) second;
	}
	
	public static void main(String[] args){
		SubtractionFunction sf=new SubtractionFunction();
		System.out.println(sf.subtract(new Double(234.0), new Double(132.0)));
	}
}
