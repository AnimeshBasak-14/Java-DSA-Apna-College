package DSA.Binary_Search_Trees_1;

public class mirrorBST {
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

    public static Node createMirror(Node root) {
        if (root == null) {
            return null; // Base case: null node
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void preorder(Node root)
    {
        if(root==null)
            return;

        System.out.printf(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String args[]) {
        Node root = null;
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        for(int i=0; i<values.length; i++) {
            root = insert(root, values[i]);
        }
        preorder(root);
        root=createMirror(root);
        System.out.println();
        preorder(root);
    }

}
