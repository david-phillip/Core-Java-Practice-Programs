package test.prac.patterns.PrototypePattern;

public class PrototypeWIthClone {

	public static void main(String[] args) {
		
		Student student1 = new StudentImpl();
		System.out.println(Student.CATEGORY);
		student1.study();
		
		Student student2 = student1.clone();
		System.out.println(Student.CATEGORY);
		student2.study();
	}

}
