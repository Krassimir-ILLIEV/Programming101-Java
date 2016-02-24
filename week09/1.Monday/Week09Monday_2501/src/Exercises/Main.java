package Exercises;

public class Main {

	static class Run implements Runnable {

		public void run() {

		}
	}

	public static void main(String[] args) {

		Thread thread = new Thread(new Run());

	}
	int a=0;
	Object obj=new Object();
	
	public synchronized void incrementA(){
		
		//Thread A and B
		synchronized(obj){
		this.a+=1;
		System.out.println("asads");
	}
		
	}
	public void increment(){
		this.a+=1;
	}
}

