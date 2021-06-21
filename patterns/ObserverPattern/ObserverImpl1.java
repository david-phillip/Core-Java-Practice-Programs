package test.prac.patterns.ObserverPattern;

public class ObserverImpl1 implements Observer {

	@Override
	public void notifyObservers(Message msg) {
		System.out.println("ObserverImpl1 recevied " + msg);

	}

}
