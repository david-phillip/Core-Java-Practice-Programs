package test.prac.examples;

public class Country implements Comparable{
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public Country(String name){
			this.name = name;
		}

		@Override
		public String toString() {
			return  name;
		}
		
		@Override
		public int compareTo(Object obj) {
			Country c = (Country) obj;
			return this.getName().compareTo(c.getName());
		}
		
		@Override
		public boolean equals(Object obj) {
			Country c = (Country) obj;
			return this.name.equalsIgnoreCase(c.getName());
		}
		 
		@Override
		 public int hashCode() {
		  final int prime = 31;
		  int result = 1;
		  result = prime * result + ((name == null) ? 0 : name.hashCode());
		  return result;
		 }
}
