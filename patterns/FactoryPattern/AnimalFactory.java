package test.prac.patterns.FactoryPattern;

public class AnimalFactory {

	public static Animal getAnimal(String name){
		
		if(name == null) {
			return null;
		}else if(name.equalsIgnoreCase("Duck")){
			return new Duck();
		}else if(name.equalsIgnoreCase("Tiger")){
			return new Tiger();
		}
		
		return null;
	}
}
