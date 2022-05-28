public class BinarySearchTree {

    //node class that defines BST node
    class Node {
        Player player;
        Node left, right;

        public Node(Player player){
            this.player = player;
            left = right = null;
        }
    }
    // BST root node
    Node root;

    // Constructor for BST =>initial empty tree
    BinarySearchTree(){
        root = null;
    }

    void insert(Player player)  {
        root = insert_Recursive(root, player);
    }

    //recursive insert function
    Node insert_Recursive(Node root, Player player) {
        //tree is empty
        if (root == null) {
            root = new Node(player);
            return root;
        }
        //traverse the tree
        if (player.score < root.player.score)     //insert in the left subtree
            root.left = insert_Recursive(root.left, player);
        else if (player.score > root.player.score)    //insert in the right subtree
            root.right = insert_Recursive(root.right, player);
        // return pointer
        return root;
    }

    // method for inorder traversal of BST
    void inorder() {
        inorder_Recursive(root);
    }

    // recursively traverse the BST
    void inorder_Recursive(Node root) {
        if (root != null) {
            inorder_Recursive(root.left);
            System.out.print(root.player.name + " : " + root.player.score);
            System.out.println(" ");
            inorder_Recursive(root.right);
        }
    }

}




