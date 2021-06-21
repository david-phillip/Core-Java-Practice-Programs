package test.prac.patterns.FactoryPattern;

public abstract class AbstractShapeFactory {
	
	protected abstract Shape getFactoryObj();
	
	public Shape getShape() {
		return getFactoryObj();
	}

}

//Sublclasses extending Abstract class
class CircleFactory extends AbstractShapeFactory{

	@Override
	protected Shape getFactoryObj() {
		return new Circle();
	}
}

class RectangleFactory extends AbstractShapeFactory{

	@Override
	protected Shape getFactoryObj() {
		return new Rectangle();
	}
}

class SquareFactory extends AbstractShapeFactory{

	@Override
	protected Shape getFactoryObj() {
		return new Square();
	}
}