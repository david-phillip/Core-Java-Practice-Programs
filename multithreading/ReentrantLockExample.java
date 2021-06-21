package test.prac.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NewCounter{
	private volatile int x;
	
	Lock l = new ReentrantLock();
	
	public int getCounter() {
		return x;
	}
	
	public int increment() {
		l.lock();
		x++;
		l.unlock();
		return x;
	}
}

public class ReentrantLockExample {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(2);
		NewCounter nc = new NewCounter();
		
		Runnable r1 = () -> {
			for(int i=0;i<5000;i++) {
				nc.increment();
			}
		};
		
		Runnable r2 = () -> {
			for(int i=0;i<5000;i++) {
				nc.increment();
			}
		};
		
		service.submit(r1);
		service.submit(r2);
		
		try {
			service.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Incremented value of x : " + nc.getCounter());
		

	}

}
