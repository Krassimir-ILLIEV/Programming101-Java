package Measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

	public static void main(String[] args) throws Exception {
		// AtomicInteger memorySize = new AtomicInteger(1000000000);
		// AtomicInteger numberOfProducers = new AtomicInteger(20);
		// AtomicInteger numberOfConsumers = new AtomicInteger(30);
		// Memory memory = new Memory(memorySize);
		int memorySize = 1500;
		int elements=100;
		int numberOfProducers = 15;
		int numberOfConsumers = 15;
		
		
		//AtomicInteger memorySize = new AtomicInteger(10000);
	

		
	    long startTimer=System.currentTimeMillis();
	    
		for (int k = 1000; k < memorySize; k=k+1000) {
			for (int i = 1; i < numberOfConsumers; i = i + 10) {
				for (int j = 1; j < numberOfProducers; j = j + 10) {
					Memory memory = new Memory(k,elements);
					Thread[] producers=new Thread[j];
					Thread[] consumers=new Thread[i];

					for(int l=0;l<i;l++){
						consumers[l]  = new Thread(new Consumer(memory));
						//System.out.println("cons");
						consumers[l].start();
					}
					
					for(int m=0;m<j;m++){
					producers[m] = new Thread(new Producer(memory));
					//System.out.println("prod");
					producers[m].start();
					}
				
					while(memory.producedElements.get()<memory.totalElements || 
							memory.consumedElements.get()<memory.totalElements){
						
					}
						
					for(int l=0;l<i;l++){
						consumers[l]  = null;
					}
					for(int m=0;m<j;m++){
					producers[m] = null;
					}
					System.out.println("Time: "+ (System.currentTimeMillis()-startTimer) +" producers: "+j+" consumers: "+i);

				}
			}
		}
		
			
	
			
			
			
			
		}

	
		
		// Producer p = new Producer(memory);
		// Consumer pp = new Consumer(memory);
		// Consumer ppp = new Consumer(memory);
		// Thread t = new Thread(p);
		// Thread tt = new Thread(pp);
		// Thread ttt = new Thread(ppp);
		// t.start();
		// tt.start();
		// ttt.start();
		// t.join();
		// tt.join();

	

	static class Producer implements Runnable {
		int count = 0;
		Memory m;

		public Producer(Memory m) {
			this.m = m;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//System.out.println(m.consumedElements.get());
			while (m.producedElements.get()<m.totalElements) {
				try {
					// Thread.sleep(100);
					m.put(++count);
				    //System.out.println("Produced " + count + " " + Thread.currentThread().getName());
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		    //System.out.println("Thread stopped: " + Thread.currentThread().getName());

		}
	}

	static class Consumer implements Runnable {
		Memory m;

		public Consumer(Memory m) {
			this.m = m;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			//System.out.println(m.consumedElements.get());
			while (m.consumedElements.get()<m.totalElements) {
				try{
					// Thread.sleep(110);
					Object result = m.get();
					
					//System.out.println("Consumed " + result + " " + Thread.currentThread().getName());
				}   catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		    //System.out.println("Thread stopped: " + Thread.currentThread().getName());

		}

	}

	static class Memory {

		public AtomicInteger producedElements=new AtomicInteger();
		public AtomicInteger consumedElements=new AtomicInteger();
		public int totalElements;
		
		List data = new ArrayList();
		int capacity;

		public Memory(int capacity,int elements) {
			this.capacity = capacity;
			this.totalElements=elements;
			//this.producedElements=elements;
			//this.consumedElements=elements;
		}

		void put(Object o) throws InterruptedException {
			synchronized (data) {
				while (data.size() == capacity) {
					data.wait();
				}
				producedElements.incrementAndGet();
				data.add(o);
				data.notifyAll();
			}
		}

		Object get() throws InterruptedException {
			Object element = null;
			synchronized (data) {
				while (data.size() == 0) {
					data.wait();
				}
				 consumedElements.incrementAndGet();
				element = data.remove(data.size() - 1);
				data.notifyAll();
			}
			return element;
		}
	}

}