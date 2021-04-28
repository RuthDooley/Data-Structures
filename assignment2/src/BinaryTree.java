import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isSymmetric(Node X, Node Y)
    {
        // base case: if both trees are empty
        if (X == null && Y == null) {
            return true;
        }

        // return true if
        // 1. Both trees are non-empty, and
        // 2. The left subtree is the mirror of the right subtree, and
        // 3. The right subtree is the mirror of the left subtree
        return (X != null && Y != null) &&
                isSymmetric(X.left, Y.right) &&
                isSymmetric(X.right, Y.left);
    }

    // Function to check if a given binary tree has a symmetric structure or not
    public static boolean isSymmetric(Node root)
    {
        // return true if left and right subtree mirror each other
        return isSymmetric(root.left, root.right);
    }

}