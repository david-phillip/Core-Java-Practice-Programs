package test.prac.patterns.PrototypePattern;

public class PrototypeWithoutClone {

	public static void main(String[] args) {

		Prototype emp = new Employee("John", 30);	
		System.out.println(emp);

		Employee emp2 = (Employee) emp.getClone();
		System.out.println(emp2);
		emp2.setName("Harry");
		emp2.setAge(20);
		System.out.println(emp2);
	}

}
