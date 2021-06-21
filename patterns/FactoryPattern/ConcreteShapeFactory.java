package test.prac.patterns.FactoryPattern;

public class ConcreteShapeFactory {
	
	public Shape getShape(String shape) {
		
		if(shape==null) {
			return null;
		}else if(shape == "Circle") {
			return new Circle();
		}else if(shape == "Rectangle") {
			return new Rectangle();
		}else if(shape == "Square") {
			return new Square();
		}
		
		return null;
	}

}
