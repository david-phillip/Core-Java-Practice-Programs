package test.prac.patterns.PrototypePattern;

public class StudentImpl implements Student {

	@Override
	public Student clone() {
		Student student = null;
		
		try {
			student = (Student) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public void study() {
		System.out.println("M in studing");
	}
}
