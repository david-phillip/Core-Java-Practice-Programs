package test.prac.patterns.SingletonPattern;

/*
 * Singleton - Bill Pugh Approach
 */
class Singleton5{
	
	private int data=0;
	private Singleton5() {};
	
	private static class SingletonHelper{
		private static final Singleton5 uniqueInstance = new Singleton5();
	}
	
	public static Singleton5 getInstance() {
		return SingletonHelper.uniqueInstance;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

public class TestSingleton5 {

	public static void main(String[] args) {
		Singleton5 s = Singleton5.getInstance();
		
		s.setData(55);
		System.out.println("First reference : " + s);
		System.out.println("S value : " + s.getData());
		
		s = null;
		s = Singleton5.getInstance();
		
		System.out.println("Second reference : " + s);
		System.out.println("S value : " + s.getData());

	}

}
