package test.prac.patterns.ObserverPattern;

public class ObserverImpl3 implements Observer {

	@Override
	public void notifyObservers(Message msg) {
		System.out.println("ObserverImpl3 recevied " + msg);

	}

}
