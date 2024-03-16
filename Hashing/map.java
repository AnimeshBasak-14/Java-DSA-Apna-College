package DSA.Hashing;

import java.util.HashMap;
import java.util.Map;

public class map {
    public static void main(String[] args) {
        //create
        HashMap<Integer, String> sname = new HashMap<>();
        //insert
        sname.put(1,"a");
        sname.put(2,"b");
        sname.put(3,"c");
        sname.put(4,"d");
        //search
        System.out.println(sname.containsKey("a")+  sname.get("a"));
        System.out.println(sname.containsKey("f"));


        for (Map.Entry<Integer, String> e: sname.entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }
}
