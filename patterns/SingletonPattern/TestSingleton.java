package test.prac.patterns.SingletonPattern;

/*
 * Singleton - Lazy Evaluation Approach
 */
class Singleton{
	
	private static Singleton uniqueInstance;
	private int data = 0;
	
	private Singleton() {};

	public static Singleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		return uniqueInstance;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

public class TestSingleton {

	public static void main(String args[]) {
		
		Singleton s = Singleton.getInstance();
		
		s.setData(55);
		System.out.println("First reference : " + s);
		System.out.println("S value : " + s.getData());
		
		s = null;
		s = Singleton.getInstance();
		
		System.out.println("Second reference : " + s);
		System.out.println("S value : " + s.getData());
	}
}
