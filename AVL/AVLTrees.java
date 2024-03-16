package DSA.AVL;
public class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data){
            this.data = data;
            height =1 ;

        }

    }
    public static Node root;

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return root.height;
    }
    static int max(int a, int b){
        return (a>b) ? a:b;
    }

    //Right rotate subtree rooted with y
    public static Node rightRotate(Node y){
        Node x= y.left;
        Node T2 = x.right;

        //perform rotation
        x.right = y;
        y.left = T2;


        //Update heights
        y.height=max(height(y.left),height(y.right)) + 1;
        x.height=max(height(x.left),height(x.right)) + 1;


        //Return new root
        return x;
    }

    //Left rotate subtree rooted with x
    public static Node leftRotate(Node x){
        Node y= x.right;
        Node T2 = y.left;

        //perform rotation
        y.left = x;
        x.right = T2;

        //Update heights
        x.height=max(height(x.left),height(x.right)) + 1;
        y.height=max(height(y.left),height(y.right)) + 1;

        //Return new root
        return y;
    }

    public static int getBalance( Node root){
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    public static Node balancer(Node root, int key){

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left-Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right-Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    public static Node insert(Node root, int key){
        if(root == null)
            return new Node(key);
        if (key < root.data)
            root.left = insert(root.left,key);
        else if (key > root.data)
            root.right = insert(root.right,key);
        else
            return root; //Duplicate keys are not allowed

        return balancer(root, key);

    }


    public static Node minValueNode(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;

        return current;
    }


    public static Node deleteNode(Node root, int key)
    {
        Node temp = null;
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.data)
            root.left = deleteNode(root.left, key);

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.data)
            root.right = deleteNode(root.right, key);

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {

                if (root.left == null)
                    temp = root.right;
                else
                    temp = root.left;

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp;
                // Copy the contents of the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.data = temp.data;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.data);
            }
        }


        return balancer(root, key);
    }


    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void inorder(Node root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args){
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /* The constructed AVL Tree would be
         30
        /  \
       20  40
       / \   \
      10 25  50

        */

        preorder(root);
        System.out.println();
        inorder(root);

        root = deleteNode(root, 30);

        /* The AVL Tree after deletion of key 30
         40
        /  \
       20  50
       / \
      10 25

        */


        System.out.println();

        preorder(root);
        System.out.println();
        inorder(root);


    }
}

