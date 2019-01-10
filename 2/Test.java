import java.util.Dictionary;
import java.util.Hashtable;

public class Test {
    public static void main(String[] args) {
        Dictionary d = new Hashtable();
        d.put("1", "First");
        d.put("2", "Second");
        d.put("3","Third");
        d.put("4","Fourth");

        System.out.println(d.get(1));
        System.out.println(d.get(2));
        System.out.println(d.get(3));
        System.out.println(d.get(4));
    }
}
