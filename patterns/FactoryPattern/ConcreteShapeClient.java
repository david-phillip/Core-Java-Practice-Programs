package test.prac.patterns.FactoryPattern;

public class ConcreteShapeClient {

	public static void main(String[] args) {
		
		ConcreteShapeFactory concreteShapeFactory = new ConcreteShapeFactory();
		
		Shape s1 = concreteShapeFactory.getShape("Circle");
		s1.draw();
		
		Shape s2 = concreteShapeFactory.getShape("Rectangle");
		s2.draw();
		
		Shape s3 = concreteShapeFactory.getShape("Square");
		s3.draw();
	}
}
