package dsa.trees;

import java.util.Stack;

import static com.utility.Utility.*;
import static dsa.trees.BinarySearchTree.*;

public class Tree {
    public static void main(String[] args) {
        println("I love Leetcode!");
        println(new Node(53));
        //println();
        //Node tree=createTree();
        //inOrder(tree);
        //preOrder(tree);
        //postOrder(tree);
        Node root = new Node(12);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.right = new Node(16);

        //println(maxHeight(root) - 1);
        println(search(root, 16));

        //println(verticalSumBST(root));

        preOrderIterative(root);

    }

    public static int heightBinaryTree(Node root) {
        return 0;
    }

    public static void nodesKthDistance() {

    }

    public static void levelOrderTraversal() {

    }

    public static void sizeBinaryTree() {

    }

    public static void maximumBinaryTree() {

    }

    public static void leftView() {

    }

    public static void checkChildrenSum() {

    }

    public static void checkBalancedBinaryTree() {

    }

    public static void maxWidth() {

    }

    public static void BT2DLL() {

    }

    public static void BTFromInOrderPreOrder() {

    }

    public static void spiralTraversal() {

    }

    public static void diameterBT() {

    }

    public static void LCA1() {

    }

    public static void LCA2() {

    }

    public static void burnLeafBT() {

    }

    public static void countNodesBT() {

    }

    public static void serializeBT() {

    }

    public static void deSerializeBT() {

    }

    public static void inOrderIterative(Node root) {

    }

    public static void preOrderIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                println(current.data);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;


        }
    }

    // 2nd approach
    public static void preOrderIterative2(Node root) {
        Stack<Node> stack = new Stack<>();

    }

    // Space Efficient approach
    public static void preOrderIterativeSpaceOptimized(Node root) {
        Stack<Node> stack = new Stack<>();

    }
}
