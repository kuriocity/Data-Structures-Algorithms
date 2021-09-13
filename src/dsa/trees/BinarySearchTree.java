package dsa.trees;

import java.util.*;

import static com.utility.Utility.*;

public class BinarySearchTree {

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

        println(verticalSumBST(root));
    }

    //      12
//      8       16
//  4     10

    static boolean search(Node root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;
        if (data < root.data) {
            return search(root.left, data);
        } else {
            return search(root.right, data);
        }
    }

    static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        return root;

    }

    static Node delete(Node root, int data) {
        return root;
    }

    static Node floorBST(Node root, int data) {
        return root;
    }

    static Node ceilBST(Node root, int data) {
        return root;
    }

    static boolean checkBST(Node root) {
        return true;
    }

    static TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    static int verticalSumBST(Node root) {
        getSumOfHorizontalDistances(root, 0);
        Set<Integer> keys = treeMap.keySet();
        int sum = 0;
        for (int key : keys) {
            sum += treeMap.get(key);
        }
        return sum;
    }

    static void getSumOfHorizontalDistances(Node root, int hd) {
        if (root == null) return;
        getSumOfHorizontalDistances(root.left, hd - 1);
        if (treeMap.get(hd) == null) {
            treeMap.put(hd, root.data);
        } else {
            treeMap.put(hd, treeMap.get(hd) + root.data);
        }
        getSumOfHorizontalDistances(root.right, hd + 1);

    }

    static void verticalTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        //queue.
    }

    static int maxHeight(Node root) {
        if (root == null) return 0;
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        return 1 + Math.max(left, right);
    }

    private static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        print(root.data + " ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        print(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        print(root.data);
    }


    public static Node createTree() {
        Node root = null;
        println("Enter value");
        int data = scanner.nextInt();
        if (data == -1)
            return null;
        root = new Node(data);
        println("Enter left value");
        root.left = createTree();
        println("Enter right value");
        root.right = createTree();
        return root;

    }
}


