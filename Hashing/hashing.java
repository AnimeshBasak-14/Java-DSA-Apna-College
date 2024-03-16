package DSA.Hashing;


import java.util.*;




public class  hashing {
    static class HashMap< K, V>{
        private class Node{
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];//N = buckets.length
        public HashMap(){
            this.N=4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i]= new LinkedList();
            }
        }
        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi)% N;
        }
        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key){
                    return i; //di
                }
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldbuckets[] = buckets;
            buckets = new LinkedList[N*2];

            for (int i = 0; i < 4; i++) {
                this.buckets[i]= new LinkedList();
            }

            for (int i = 0; i < oldbuckets.length; i++) {
                LinkedList<Node> ll = oldbuckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di=-1
            if (di == -1){
                buckets[bi].add(new Node( key,value));
            }
            else {
                Node data = buckets[bi].get(di);
                data.value = value;
            }
            double lambda = (double) n/N;
            if (lambda>2.0){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di=-1
            if (di == -1){
                return false;
            }
            else {
                return true;
            }
        }
        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di=-1
            if (di == -1){
                return null;
            }
            else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;

            }
        }
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi); //di=-1

            if (di == -1){
                return null;
            }
            else {
                Node node = buckets[bi].get(di);
                 return node.value;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }

    }

    public static void main(String[] args) {

        HashMap<String, Integer> map =new HashMap<>();
        map.put("India", 190);
        map.put("USA", 90);
        map.put("China", 180);
        map.put("Russia", 80);
        ArrayList<String > keys = map.keySet();
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i)+" " + map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India"));
    }
}
