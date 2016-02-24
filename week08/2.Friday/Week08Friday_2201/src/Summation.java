
public class Summation implements Runnable{

	private int a;
	private int b;
	
	public Summation(int a, int b){
		this.a=a;
		this.b=b;
	}
	
	public double sum(){
		return (double) a+b;
	}
	
	@Override
	public void run(){
		System.err.println(sum());
	}
	

}
