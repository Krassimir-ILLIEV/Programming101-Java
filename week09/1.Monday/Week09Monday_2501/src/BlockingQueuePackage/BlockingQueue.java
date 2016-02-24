package BlockingQueuePackage;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Queue;
import java.util.Vector;




public class BlockingQueue {

	private static final int QUEUE_SIZE=5;
	//private ArrayDeque<String> blockingQueue=ArrayDeque<String>(QUEUE_SIZE);
	private Vector blockingQueue= new Vector();
	
	public synchronized void put(String str) throws InterruptedException{
		while (blockingQueue.size()==QUEUE_SIZE){
			wait();
		}

		blockingQueue.add(str);
		notify();
	}
	
	public synchronized String get() throws InterruptedException{
		while(blockingQueue.size()==0){
			wait();
		}
		
		String message= (String) blockingQueue.remove(0);
		notify();
		return message;
		
	}
	
	public static void main(String[] args){
		BlockingQueue blockingQueue=new BlockingQueue();
		Producer producer1 = new Producer(blockingQueue);
		producer1.start();
		Consumer consumer1=new Consumer(blockingQueue);
		consumer1.setName("consumer Pesho");
		consumer1.start();
		Consumer consumer2=new Consumer(blockingQueue);
		consumer2.setName("consumer Kartata");
		consumer2.start();
		
	}

}	
	class Producer extends Thread{
		private BlockingQueue blockingQueue;
		
		public Producer(BlockingQueue blockingQueue){
			this.blockingQueue=blockingQueue;
		}
		public void run(){
			try{
				while(true){
					String message=new Date().toString();
					System.out.println("Producer: put" + message);
					blockingQueue.put(message);
					sleep(2000);
					
				}
			} catch (InterruptedException ie){
				
			}
			
	}
}
	
	class Consumer extends Thread{
		private BlockingQueue blockingQueue;
		
		public Consumer(BlockingQueue blockingQueue){
		this.blockingQueue=blockingQueue;
		}

		public void run(){
			try{
				while(true){
					String message=(String) blockingQueue.get();
					System.out.println(this.getName()+ " : got "+message);
					sleep(500);
				}
			} catch (InterruptedException ie){
				
			}
		}
	}


