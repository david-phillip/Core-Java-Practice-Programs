package test.prac.examples;

class NaturalNumbers implements Runnable {
	
    static int i = 1;
	final int MAX = 10;
	int remainder;
	static Object lock=new Object();
	
	public NaturalNumbers(int remainder) {
		this.remainder = remainder;
	}

	public void run() {
		while(i < MAX) {
			synchronized(lock){
				while(i%2 != remainder) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("i : " + i);
				i++;
				lock.notifyAll();
			}
		}
	}
}

public class ThreadOddEven2 {

	public static void main(String[] args) {
		NaturalNumbers o = new NaturalNumbers(1);
		NaturalNumbers e = new NaturalNumbers(0);
		
		Thread t1 = new Thread(o);
		Thread t2 = new Thread(e);
		
		t1.start();
		t2.start();
		
		
	}

}
