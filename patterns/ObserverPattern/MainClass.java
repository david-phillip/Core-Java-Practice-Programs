package test.prac.patterns.ObserverPattern;

public class MainClass {

	public static void main(String[] args) {
		
		Subject s = new SubjectImpl();
		
		Observer o1 = new ObserverImpl1();
		Observer o2 = new ObserverImpl2();
		Observer o3 = new ObserverImpl3();
		
		s.attach(o1);
		s.attach(o2);
		s.attach(o3);
		
		s.notify(new Message("Hello World"));
		
		s.deattach(o2);
		
		s.notify(new Message("Hello World Again"));
	}

}
