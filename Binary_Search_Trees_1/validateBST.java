package DSA.Binary_Search_Trees_1;

import java.util.ArrayList;

import static DSA.Binary_Search_Trees_1.RootToLeaf.printRoot2Leaf;

public class validateBST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

         if(root.data > val) { //go to left subtree
            root.left = insert(root.left, val);
         } else { // go to right subtree
             root.right = insert(root.right, val);
         }

         return root;
    }
    
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }
        
        if(min != null && root.data <= min.data) {
            return false;
        }
        
        if(max != null && root.data >= max.data) {
            return false;
        }
        
        return isValidBST(root.left, min, root)
            && isValidBST(root.right, root, max);
    }
    public static void main(String args[]) {
        Node root = null;
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }
        System.out.println(isValidBST(root, null, null ));
    }

}
