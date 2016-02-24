
public class Example {

	private int valueOfLife;
	
	public Example(int value){
		valueOfLife=value;
	}
	public static void main(String[] args){
		Example example=new Example(42);
		System.out.println(example.valueOfLife);
	}
}
