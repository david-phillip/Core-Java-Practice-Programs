package test.prac.patterns.FactoryPattern;

public interface Shape {
	
	public void draw();

}

class Circle implements Shape{
	
	public void draw() {
		System.out.println("Drawing Circle");
	}
	
}

class Rectangle implements Shape{
	
	public void draw() {
		System.out.println("Drawing Rectangle");
	}
	
}

class Square implements Shape{
	
	public void draw() {
		System.out.println("Drawing Square");
	}
	
}