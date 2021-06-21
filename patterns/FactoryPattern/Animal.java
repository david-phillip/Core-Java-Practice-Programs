package test.prac.patterns.FactoryPattern;

public interface Animal {

	public void walk();
	public void talk();
}

class Duck implements Animal{

	@Override
	public void walk() {
		System.out.println("Duck is walking");
	}

	@Override
	public void talk() {
		System.out.println("Duck is talking");	
	}
}


class Tiger implements Animal{
	
	@Override
	public void walk() {
		System.out.println("Tiger is walking");
	}

	@Override
	public void talk() {
		System.out.println("Tiger is talking");	
	}
}