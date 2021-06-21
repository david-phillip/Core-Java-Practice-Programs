package test.prac.examples;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueue_Comparator {

	public static void main(String[] args) {
		
		PriorityQueue<Employee> pq = new PriorityQueue<>(new EmployeeByAge());
		pq.add(new Employee(30,"Allan"));
		pq.add(new Employee(20,"Paul"));
		pq.add(new Employee(33,"Roy"));
		pq.add(new Employee(50,"Batty"));
		pq.add(new Employee(30,"Kate"));
		pq.add(new Employee(48,"Morris"));
		pq.add(new Employee(45,"VK"));
		
		System.out.println(pq);
		
		while(pq.size()>0) {
			System.out.println("Removed Element : " + pq.poll());
		}
	}

}

class EmployeeByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee emp1, Employee emp2) {
		if(emp1.getAge() > emp2.getAge()) return +1;
		else if(emp1.getAge() < emp2.getAge()) return -1;
		return emp1.getName().compareTo(emp2.getName());
	}
	
		
}

class Employee{
	
	private int age;
	private String name;
	
	protected Employee(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "age=" + age + ", name=" + name + "]" + "\n";
	}
}


