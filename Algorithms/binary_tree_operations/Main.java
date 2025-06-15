/*
 * Title: Main.java
 * Description: Implements a binary tree that supports multiple commands:
 *              insertion (append), traversal (preorder, inorder, postorder, levelorder),
 *              height calculation, node search, and BST verification.
 *              Commands are read from user input and executed in order.
 * Author: Shane Skare
 * Date: 04/19/2024
 * Reference: https://www.geeksforgeeks.org/binary-tree-data-structure/?ref=shm
 */

import java.util.Objects;
import java.util.Scanner;
class Node {
    // Use "public" data to make the program simple (= no getters and setters).
    public int data;
    public Node left;
    public Node right;

    // Constructor
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

// A class for a BST which may include many Nodes.
class BST {
    private Node root;
    public int counter = 0;
    String pOStr = "";
    String lOStr = "";
    String iOStr = "";
    String prOStr = "";
    public Node getRoot() {
        return root;
    }


    // Add an item to the BST
    // Internally, it calls "insert()" for actual insertion if root is not null.
    public void add(int item) {
        Node newNode = new Node(item, null, null);

        // Empty tree
        if (root == null) {
            root = newNode;
        }
        else {
            insert(newNode, root);
        }
    }

    // Insert a new node under the subtree using recursion
    private void insert(Node newNode, Node subTree) {
        if (counter == 4){
            counter = 0;
        }
        if(subTree.left == null) {
            subTree.left = newNode;
            return;
        }
        if (subTree.right == null) {
            subTree.right = newNode;
        }
        else {
            if (findLeftHeight(root) <= findRightHeight(root) || counter < 2){
                insert(newNode, subTree.left);
                counter++;
            }
            else {
                insert(newNode, subTree.right);
                counter++;
            }
        }
    }

    // Conduct the in-order traversal.
    // Actual traversal happens in another method named inOrder() with the root.
    // We have two inOrder() methods (= method overloading).
    public String preOrder() {
        return preOrder(root);
    }

    private String preOrder(Node subTree) {
        if (subTree != null) {
            if(prOStr.isEmpty()) {
                prOStr += subTree.data;
            }
            else{
                prOStr += " " + subTree.data;
            }
            preOrder(subTree.left);
            preOrder(subTree.right);
        }
        return prOStr;
    }
    public String inOrder() {
       return inOrder(root);
    }
    private String inOrder(Node subTree) {
        if (subTree != null) {
            inOrder(subTree.left);
            if(iOStr.isEmpty()) {
                iOStr += subTree.data;
            }
            else{
                iOStr += " " + subTree.data;
            }
            inOrder(subTree.right);
        }
        return iOStr;
    }
    public String levelOrder() {
        String str = "";
        int h = findHeight();
        for (int i = 1; i <= h+1; i++) {
            str = levelOrder(root, i);
        }
        return str;
    }
    private String levelOrder(Node subTree, int level) {
        if (subTree == null)
            return "";
        if (level == 1)
            if(lOStr.isEmpty()) {
                lOStr += subTree.data;
            }
            else{
                lOStr += " " + subTree.data;
            }
        else if (level > 1) {
            levelOrder(subTree.left, level - 1);
            levelOrder(subTree.right, level - 1);
        }
        return lOStr;
    }
    public String postOrder() {
        return postOrder(root);
    }
    private String postOrder(Node subTree) {
        if (subTree != null)
        {
            postOrder(subTree.left);
            postOrder(subTree.right);
            if(pOStr.isEmpty()) {
                pOStr += subTree.data;
            }
            else{
                pOStr += " " + subTree.data;
            }
        }
        return pOStr;
    }
    String fFStr = "";
    public String findFirstNode(Node subTree) {
        if (subTree.left == null){
            fFStr = String.valueOf(subTree.data);
        }
        else{
            findFirstNode(subTree.left);
        }
        return fFStr;
    }
    private int findLeftHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            int lHeight = findLeftHeight(node.left);
            return (lHeight+1);
        }
    }
    private int findRightHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            int rHeight = findRightHeight(node.right);
            return (rHeight+1);
        }
    }
    public int findHeight() {
        int rHeight = findRightHeight(root);
        int lHeight = findLeftHeight(root);
        if (rHeight > lHeight) {
            return rHeight;
        }
        else {
            return lHeight;
        }
    }
    static int maxValue(Node node)
    {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int value = node.data;
        int leftMax = maxValue(node.left);
        int rightMax = maxValue(node.right);

        return Math.max(value, Math.max(leftMax, rightMax));
    }

    static int minValue(Node node)
    {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        int value = node.data;
        int leftMax = minValue(node.left);
        int rightMax = minValue(node.right);

        return Math.min(value, Math.min(leftMax, rightMax));
    }

    /* Returns true if a binary tree is a binary search tree
     */
    public boolean isBST(Node node)
    {
        if (node == null) {
            return true;
        }

        /* false if the max of the left is > than us */
        if (node.left != null
                && maxValue(node.left) > node.data) {
            return false;
        }

        /* false if the min of the right is <= than us */
        if (node.right != null
                && minValue(node.right) < node.data) {
            return false;
        }

        /* false if, recursively, the left or right is not a
         * BST*/
        if (!isBST(node.left) || !isBST(node.right)) {
            return false;
        }

        /* passing all that, it's a BST */
        return true;
    }
}  // end of class BST

public class Main
{
    public static void main(String[] args)
    {
        BST t1 = new BST();
        Scanner s = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        int root = s.nextInt();
        t1.add(root);
        int commandNumber = s.nextInt();
        for(int i = 0; i < commandNumber; i++){
            String command = s.next();
            if (command.equals("append")){
                t1.add(s.nextInt());
                continue;
            }
            if (command.equals("isBST")){
                str.append(t1.isBST(t1.getRoot()));
            }
            if (command.equals("preOrder")){
                str.append(t1.preOrder());
            }
            if (command.equals("height")){
                str.append(t1.findHeight());
            }
            if (command.equals("levelOrder")){
                str.append(t1.levelOrder());
            }
            if (command.equals("findFirstNode")){
                str.append(t1.findFirstNode(t1.getRoot()));
            }
            if (command.equals("inOrder")){
                str.append(t1.inOrder());
            }
            if (command.equals("postOrder")){
                str.append(t1.postOrder());
            }
            if (i < commandNumber -1) {
                str.append("\n");
            }
        }
        System.out.print(str);
    }
}