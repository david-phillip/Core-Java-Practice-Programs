package test.prac.patterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class SubjectImpl implements Subject {
	
	List<Observer> observers = new ArrayList<>();

	@Override
	public void attach(Observer o) {
		observers.add(o);
	}

	@Override
	public void deattach(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notify(Message msg) {
		for(Observer o:observers)
			o.notifyObservers(msg);
	}

}
