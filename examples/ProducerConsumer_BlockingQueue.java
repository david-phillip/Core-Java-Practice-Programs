package test.prac.examples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer_BlockingQueue {

	public static void main(String[] args) {
		
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
		Thread t1 = new Thread(new Producer(blockingQueue));
		Thread t2 = new Thread(new Consumer(blockingQueue));
		t1.start();
		t2.start();
	}
}

class Producer implements Runnable{

	BlockingQueue<Integer> blockingQueue = null;
	int i=0;

	protected Producer(BlockingQueue<Integer> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("BQ size : " + blockingQueue.size());
				produce(i++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void produce(int i) throws InterruptedException{
		System.out.println("Producer produced " + i);
		blockingQueue.put(i);
		Thread.sleep(100);
	}	
}


class Consumer implements Runnable{

	BlockingQueue<Integer> blockingQueue = null;
	int i=0;

	protected Consumer(BlockingQueue<Integer> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void consume() throws InterruptedException{
		System.out.println("Consumed " + blockingQueue.take());
		System.out.println("BQ remaining size : " + blockingQueue.remainingCapacity());
		Thread.sleep(500);
	}
	
}