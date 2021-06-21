package test.prac.examples;

public class ThreadOddEven{
	
	int i = 1;
	final int MAX=10;
	boolean odd;
	
	public void printEvenNumbers() throws InterruptedException {
		synchronized(this) {
			while(i < MAX) {
				if(odd) {
					wait();
				}
				System.out.println("i : " + i);
				i++;
				odd = true;
				notify();
			}
		}
	}
	
	public void printOddNumbers() throws InterruptedException {
		synchronized(this) {
			while(i < MAX) {
				if(!odd) {
					wait();
				}
				System.out.println("i : " + i);
				i++;
				odd = false;
				notify();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadOddEven toe1 = new ThreadOddEven();
		toe1.odd = true;
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					toe1.printEvenNumbers();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					toe1.printOddNumbers();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();

		
	}
}


