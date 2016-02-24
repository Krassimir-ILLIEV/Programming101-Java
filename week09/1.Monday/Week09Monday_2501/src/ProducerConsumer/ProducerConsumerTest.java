package ProducerConsumer;

import java.util.*;

class BlockingQueue {

	private static final int QUEUE_SIZE = 5;
	private Vector mQueue = new Vector();

	public synchronized void put(String aString) throws InterruptedException {
		while (mQueue.size() == QUEUE_SIZE) //trqbva li da se sinhronizira?
			wait();
		mQueue.addElement(aString);
		notify();
	}

	public synchronized Object poll() throws InterruptedException {
		while (mQueue.size() == 0)
			wait();
		String message = (String) mQueue.firstElement();
		mQueue.removeElement(message);
		notify();
		return message;
	}
}

class Producer extends Thread {
	private BlockingQueue mBlockingQueue;

	public Producer(BlockingQueue aBlockingQueue) {
		mBlockingQueue = aBlockingQueue;
	}

	public void run() {
		try {
			while (true) {
				String message = new Date().toString();
				System.out.println("producer : put " + message);
				mBlockingQueue.put(message);
				sleep(500);
			}
		} catch (InterruptedException e) {
		}
	}
}

class Consumer extends Thread {
	private BlockingQueue mBlockingQueue;

	public Consumer(BlockingQueue aBlockingQueue) {
		mBlockingQueue = aBlockingQueue;
	}

	public void run() {
		try {
			while (true) {
				String message = (String) mBlockingQueue.poll();
				System.out.println(getName() + " : got " + message);
				sleep(2000);
			}
		} catch (InterruptedException e) {
		}
	}
}

public class ProducerConsumerTest {
	public static void main(String args[]) {
		BlockingQueue blockingQueue = new BlockingQueue();
		Producer producer = new Producer(blockingQueue);
		producer.start();
		Consumer consumer1 = new Consumer(blockingQueue);
		consumer1.setName("consumer Pesho");
		consumer1.start();
		Consumer consumer2 = new Consumer(blockingQueue);
		consumer2.setName("consumer Kiro");
		consumer2.start();
	}
}
