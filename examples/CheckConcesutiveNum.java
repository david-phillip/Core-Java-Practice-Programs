package test.prac.examples;

public class CheckConcesutiveNum {

	public static void main(String[] args) {
		
		String str = "121315";
		
		if(isConcesutiveNum(str))
			System.out.println(str + " is consecutive");
		else
			System.out.println(str + " is not consecutive");
	}
	
	private static boolean isConcesutiveNum(String str) {
		boolean isConsecutive = false;
		String num = "";
		
		for(int i=0; i<str.length()/2;i++) {
			String new_str = "";
			int n=0;
			num = num + str.charAt(i);
			n = Integer.parseInt(num);
			
			while(new_str.length() < str.length()) {
				new_str =  new_str + Integer.valueOf(n);
				n++;
			}

			System.out.println("new_str:" + new_str);
			if(new_str.equals(str)) {
				isConsecutive = true;
				break;
			}
			System.out.println("reiterate for loop");
		}
		return isConsecutive;
	}

}
