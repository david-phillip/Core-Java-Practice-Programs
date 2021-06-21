package test.prac.patterns.BridgePattern;

public class Rectangle extends Shape{

	Rectangle(Colour colour) {
		super(colour);
	}

	@Override
	public void draw() {
		System.out.println("Drawing rectangle in " + this.colour.fillColour());
	}

}
