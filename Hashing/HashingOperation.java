import java.util.HashMap;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class HashingOperation {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("China", 100);
        hm.put("India", 150);
        hm.put("US", 50);

        System.out.println(hm);

        //Get
        int population=hm.get("India");
        System.out.println(population);

        System.out.println(hm.get("Asia"));

        //Contains Key

        System.out.println(hm.containsKey("India")); //true
        System.out.println(hm.containsKey("Asia")); //false

        //Remove
        System.out.println(hm.remove("China"));
        System.out.println(hm);
        System.out.println(hm.remove("usa"));

        //Size
        System.out.println(hm.size());
        // Is Empty
        System.out.println(hm.isEmpty());

    }
} 