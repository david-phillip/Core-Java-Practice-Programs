package test.prac.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Counter{
	
	//private volatile int counter;
	AtomicInteger counter = new AtomicInteger(0);
	
	public int getValue() {
		return counter.get();
	}
	
	//public synchronized int incrementValue() {
	public int incrementValue() {
		return counter.incrementAndGet();
	}
}

public class AtomicVarExample {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(2);
		Counter c = new Counter();
		
		try {
			Runnable task1 = () -> {
				for(int i=0;i<500;i++) {
					c.incrementValue();
				}
			};
			
			Runnable task2 = () -> {
				for(int i=0;i<500;i++) {
					c.incrementValue();
				}
			};
			
			service.execute(task1);
			service.execute(task2);
			
			service.awaitTermination(1, TimeUnit.SECONDS);
			
			System.out.println("Incremented value of counter is : " + c.getValue());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
