import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedExample {

	private static List<Person> getPersons() {

		List<Person> result = new ArrayList<Person>();

		result.add(new Person("John", "Lennon", 33));
		result.add(new Person("Karl", "Marx", 20));
		result.add(new Person("Groucho", "Marx", 10));
		result.add(new Person("Oscar", "Grouch", 55));
		
		return result;

	}

	public static void main(String[] args) {
        Name nameArray[] = {
                new Name("John", "Lennon"),
                new Name("Karl", "Marx"),
                new Name("Groucho", "Marx"),
                new Name("Oscar", "Grouch")
         };
        
        //First Example
            List<Name> names = Arrays.asList(nameArray);
            Collections.sort(names);
            System.out.println(names);
            
       //Second Example
            List<Person> listPersons = getPersons();

    		System.out.println("Before Sort");
    		for (Person person : listPersons) {
    			System.out.println(person);
    		}
    		
    		//sort by age
    		Collections.sort(listPersons, new Comparator<Person>() {
    			@Override
    			public int compare(Person o1, Person o2) {
    				return o1.getAge() - o2.getAge();
    			}
    		});
    		
    		System.out.println("After Sort");
    		for (Person person : listPersons) {
    			System.out.println(person);
    		}  
    		
    		//Example three - lambda expression
    		listPersons.sort((Person o1, Person o2)->o2.getAge()-o1.getAge());

    		System.out.println("After Lambda:: Example 1");
    		listPersons.forEach((person)->System.out.println(person));		
    		
    		//Example four - Lambda expression with type information removed and complex compare 
    		listPersons.sort((o1, o2)-> {
    			if (o1.getNames().compareTo(o2.getNames()) != 0)
    				return o1.getNames().compareTo(o2.getNames());
    			else
    				return o1.getAge()-o2.getAge();	
    		});
    		
    		System.out.println("After Lambda:: Example 2");
    		listPersons.forEach((person)->System.out.println(person));
       

	}
	
}
