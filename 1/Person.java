
public class Person {
	private Name names;
	private int age;

	public Person(String fname, String lname, int age) {
		names = new Name(fname, lname);
		this.age = age;
	}
	
	public String toString() {
		return names + ": " + age;
	}

	public int getAge() {
		return age;
	}	
	
	public Name getNames() {
		return names;
	}
	
}
