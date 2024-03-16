import java.util.*;
public class LinkedHashset {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Noida");
        lhs.add("Mumbai");
        lhs.add("Bengaluru");
        System.out.println(lhs);
        
        
        TreeSet<String> ts = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Ahmdabad");
        ts.add("Noida");
        ts.add("Mumbai");
        System.out.println(ts);

    }
    
}
