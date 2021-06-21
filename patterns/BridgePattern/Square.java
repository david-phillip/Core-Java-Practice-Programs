package test.prac.patterns.BridgePattern;

public class Square extends Shape{
	
	Square(Colour colour) {
		super(colour);
	}

	@Override
	public void draw() {
		System.out.println("Drawing square in " + this.colour.fillColour());
	}
	
}
