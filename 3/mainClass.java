
public class mainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] first = {"one", "two", "three", "four",
						"five", "six", "seven", "eight", "nine", 
						"ten"};
		String[] second = {"gree", "blue", "red", "grey", "black", 
							"pink", "white"};
		
		StringOut s1 = new StringOut(first, 500L);
		StringOut s2 = new StringOut(second, 1000L);
		
		s1.start();
		s2.start();

	}

}
