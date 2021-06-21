package test.prac.patterns.PrototypePattern;

public interface Student extends Cloneable{

	public static final String CATEGORY = "STUDENT";
	
	public Student clone();
	
	public void study();
}
