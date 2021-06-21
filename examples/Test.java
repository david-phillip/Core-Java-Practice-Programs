package test.prac.examples;

public class Test {
	 
	public static void main(String[] args) {
		Parent obj = new Child();
		Parent obj2 = new Parent();
		Child obj3 = new Child();
		obj.m1();   //Parent reference variable storing the child obj, so method in child class called.
		obj2.m1();  //Parent reference variable storing the parent obj, so method in parent class called.
		//obj2.m2();
		obj3.m2();
	}
}
class Parent
{
	void m1()
	{
		System.out.println("Parent method m1 called");
	}
}

class Child extends Parent
{
	void m1()
	{
		System.out.println("Child method m1 called");
	}
	void m2()
	{
	
		System.out.println("Child method m2 called");
	}
}


 