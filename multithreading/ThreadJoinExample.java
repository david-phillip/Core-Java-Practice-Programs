package test.prac.multithreading;

class MyRunnable2 implements Runnable{
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " start");
			Thread.sleep(4000);
			System.out.println(Thread.currentThread().getName() + " end");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public class ThreadJoinExample {

	public static void main(String[] args) {
		
		System.out.println("Main Thread started");
		Thread t1 = new Thread(new MyRunnable2(), "Thread1");
		Thread t2 = new Thread(new MyRunnable2(), "Thread2");
		Thread t3 = new Thread(new MyRunnable2(), "Thread3");
		
		t1.start();{
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		t2.start();{
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		t3.start();{
			try {
				//t2.join();
				t3.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Main Thread end");
	}

}
