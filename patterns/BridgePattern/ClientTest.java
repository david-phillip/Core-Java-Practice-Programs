package test.prac.patterns.BridgePattern;

/*
 * Similarly we can extend the abstract class and implementation heiarchies 
   as both the abstraction and implementation are decoupled 
 */
public class ClientTest {

	public static void main(String[] args) {
		
		Shape s1 = new Square(new BlueColour());
		s1.draw();
		
		Shape s2 = new Rectangle(new RedColour());
		s2.draw();
		
		Shape s3 = new Square(new RedColour());
		s3.draw();
		
		Shape s4 = new Rectangle(new BlueColour());
		s4.draw();
	}

}
