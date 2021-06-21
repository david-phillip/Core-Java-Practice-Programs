package test.prac.examples;

import java.util.concurrent.Callable;

class MyCallable implements Callable{

	@Override
	public Object call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

public class CallInterfaceExample {

	public static void main(String[] args) {
		
		MyCallable m = new MyCallable();
		Thread t = new Thread();
		

	}

}
