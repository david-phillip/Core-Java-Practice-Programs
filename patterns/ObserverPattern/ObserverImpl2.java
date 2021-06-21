package test.prac.patterns.ObserverPattern;

public class ObserverImpl2 implements Observer {

	@Override
	public void notifyObservers(Message msg) {
		System.out.println("ObserverImpl2 recevied " + msg);

	}

}
