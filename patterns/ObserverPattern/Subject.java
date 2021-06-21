package test.prac.patterns.ObserverPattern;

public interface Subject {
	
	public void attach(Observer o);
	
	public void deattach(Observer o);
	
	public void notify(Message msg);

}
