package test.prac.patterns.SingletonPattern;

/*
 * Singleton - Double Checked Locking Approach
 */
class Singleton3{
	
	private volatile static Singleton3 uniqueInstance;
	private int data=0;
	
	private Singleton3() {};
	
	public static Singleton3 getInstance() {
		if(uniqueInstance == null) {
			synchronized(Singleton3.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new Singleton3();
				}
			}
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

public class TestSingleton3 {

	public static void main(String[] args) {
	
		Singleton3 s = Singleton3.getInstance();
		
		s.setData(55);
		System.out.println("First reference : " + s);
		System.out.println("S value : " + s.getData());
		
		s = null;
		s = Singleton3.getInstance();
		
		System.out.println("Second reference : " + s);
		System.out.println("S value : " + s.getData());

	}

}
