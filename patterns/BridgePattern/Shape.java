package test.prac.patterns.BridgePattern;

public abstract class Shape {
	
	protected Colour colour;
	
	Shape(Colour colour){
		this.colour = colour;
	}
	
	public abstract void draw();

}
