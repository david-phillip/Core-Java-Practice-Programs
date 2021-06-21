package test.prac.examples;

public class PrimeNumber {
	
	public static void main(String args[]) {
		printPrimrNumbers();
	}
	
	public static void printPrimrNumbers() {
	
		//Loop 1 - 100. check all numbers
		for(int i=1; i<=100; i++) {
			
			int count = 0;
			//Loop thru i to 1 
			for(int j=i; j>=1; j--) {
				
				if(i%j==0) {
					count = count +1;
				}
			}
			
			if(count == 2) {
				System.out.print(i + " ");
			}
			
		}
	}

}
