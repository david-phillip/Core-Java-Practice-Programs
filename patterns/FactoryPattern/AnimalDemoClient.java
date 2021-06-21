package test.prac.patterns.FactoryPattern;

public class AnimalDemoClient {

	public static void main(String[] args) {

		Animal a = AnimalFactory.getAnimal("Duck");
		a.talk();
		
		Animal a2 = AnimalFactory.getAnimal("Tiger");
		a2.talk();
	}
}
