package test.prac.patterns.SingletonPattern;

/*
 * Singleton - Eager Initialization Approach
 */
class Singleton4{
	
	private static Singleton4 uniqueInstance = new Singleton4();
	private int data = 0;
	
	private Singleton4() {};
	
	public static Singleton4 getInstance() {
		return uniqueInstance;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

public class TestSingleton4 {

	public static void main(String[] args) {
		Singleton4 s = Singleton4.getInstance();
		
		s.setData(55);
		System.out.println("First reference : " + s);
		System.out.println("S value : " + s.getData());
		
		s = null;
		s = Singleton4.getInstance();
		
		System.out.println("Second reference : " + s);
		System.out.println("S value : " + s.getData());
	}

}
