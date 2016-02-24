
public class Main {
	
	private static class MyThread extends Thread{
		
		public void run(){
			System.out.println("I'm a thread; look at me.");
		}
	}
	public static void main(String[] args)throws InterruptedException{
		//MyThread thread = new MyThread();
		//thread.start();		
		//thread.join();
		
		//MyRunnable myRunnable=new MyRunnable();
		//Thread thread1=new Thread(myRunnable);
		//thread1.start();
		/*
		Divisor k= new Divisor(5,4);
		Thread thread3=new Thread(k, "ThreadK");
		thread3.start();
		Summation sum=new Summation(5,4);
		Thread thread_sum=new Thread(sum);
		thread_sum.start();
		
		System.out.println("Yet another thread");
		System.out.println(thread3.getName());
		
		*/
		Counter c1=new Counter();
		Counter c2=new Counter();
		
		Thread threadC1=new Thread(c1);
		Thread threadC2=new Thread(c1);
		long startTime = System.currentTimeMillis();
		//getCurrentTimeMilliseconds();
		threadC1.start();
		threadC2.start();
		//threadC1.join();
		//threadC2.join();
		while (threadC1.isAlive() || threadC2.isAlive());
		long totalTime = System.currentTimeMillis() - startTime;
		System.out.println(c1.getCounter());
		System.out.println(totalTime);
	}
}
