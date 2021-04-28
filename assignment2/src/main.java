public class main {
    public static void main(String[] args)
    {
        /* Construct the following tree
              1
            /   \
           /     \
          2       3
           \     /
            5   6
        */

        BinaryTree.Node root = new BinaryTree.Node(1);
        root.left = new BinaryTree.Node(3);
        root.left.left = new BinaryTree.Node(7);
        root.left.right = new BinaryTree.Node(9);
        root.left.right.left = new BinaryTree.Node(15);

        root.right = new BinaryTree.Node(5);
        root.right.left = new BinaryTree.Node(11);
        root.right.left.right = new BinaryTree.Node(17);
        root.right.right = new BinaryTree.Node(13);

        if (BinaryTree.isSymmetric(root)) {
            System.out.print("The binary tree is symmetric");
        }
        else {
            System.out.print("The binary tree is not symmetric");
        }
    }
}
