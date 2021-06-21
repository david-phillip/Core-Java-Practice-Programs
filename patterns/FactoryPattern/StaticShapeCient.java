package test.prac.patterns.FactoryPattern;

public class StaticShapeCient {

	public static void main(String[] args) {
		
		Shape s1 = StaticShapeFactory.getShape("Circle");
		s1.draw();
		
		Shape s2 = StaticShapeFactory.getShape("Rectangle");
		s2.draw();
		
		Shape s3 = StaticShapeFactory.getShape("Square");
		s3.draw();
	}
}
