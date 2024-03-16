package DSA.Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class set {
    public static void main(String[] args) {
        //Creating
        HashSet<Integer> set = new HashSet<>();

        //Insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);


        //size

        System.out.println(set.size());

        //print all element
        System.out.println(set);
        //Iterator
        Iterator<Integer> it = set.iterator();
        //has
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //Search - Contains
        if (set.contains(1)){
            System.out.println("Its contains 1");
        }if (!set.contains(1)){
            System.out.println("Its does not contains 6");
        }

        //Delete

        set.remove(1);

        if (!set.contains(1)){
            System.out.println("Its contains not 1");
        }

    }
}
