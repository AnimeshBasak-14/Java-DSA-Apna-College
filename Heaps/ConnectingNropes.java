package DSA.Heaps;

import java.util.*;
public class ConnectingNropes {
    public static void main(String[] args) {
        long ropes[] = {2,3,3,4,6};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i =0; i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost = 0;
        while(pq.size()>1) {
            int min  = Math.toIntExact(pq.remove());
            int min2 = Math.toIntExact(pq.remove());
            cost += min+min2;
            pq.add((long) (min+min2));
        }
        System.out.println("Cost of connecting ropes = " + cost);
    }
}
