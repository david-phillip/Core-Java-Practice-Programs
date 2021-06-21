package test.prac.patterns.SingletonPattern;

/*
 * Singleton - Synchronized Approach
 */
class Singleton2{
	
	private static Singleton2 uniqueInstance;
	private int data=0;
	
	private Singleton2() {};
	
	public static synchronized Singleton2 getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance =  new Singleton2();
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

public class TestSingleton2 {

	public static void main(String[] args) {
		Singleton2 s = Singleton2.getInstance();
		
		s.setData(55);
		System.out.println("First reference : " + s);
		System.out.println("S value : " + s.getData());
		
		s = null;
		s = Singleton2.getInstance();
		
		System.out.println("Second reference : " + s);
		System.out.println("S value : " + s.getData());

	}

}
