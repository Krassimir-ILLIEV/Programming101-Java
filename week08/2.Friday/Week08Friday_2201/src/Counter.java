import java.util.concurrent.atomic.AtomicInteger;

public class Counter implements Runnable{

	//public static AtomicInteger c=new AtomicInteger(0);
	
	//use either atomic data types or synchronized methods
	public static int c=0;
	
	public synchronized void increment(){
		//c.incrementAndGet();
		c++;
	}
	
	//public static void decrement(){
		//c--;
	//}
	
	public int getCounter(){
		return c;//.get();
	}
		public void run(){
			for(int i=0;i<1000000*100;i++){
				increment();
			}
		}
	
}
