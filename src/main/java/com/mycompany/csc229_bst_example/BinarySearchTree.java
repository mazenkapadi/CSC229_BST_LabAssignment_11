package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        System.out.print("[input: " + data + "]");
        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(" -> inserted: " + data);
            return;
        }
        insertNode(this.root, data);
        System.out.print(" -> inserted: " + data);
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(" ->" + root.getData());
        if (root.getData() >= data) {
            System.out.print(" [L]");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print(" [R]");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {

        // ToDo 1: complete InOrder Traversal
        if(root==null)
            return;
        doInOrder(root.getLeft());
        System.out.println(root + " ");
        doInOrder(root.getRight());
    }
        public void preOrderTraversal() {
        doPreOrder(this.root);
        // ToDo 2: complete the pre-order travesal . 
    }
    private void doPreOrder(BstNode root){
        if(root==null)
            return;
        System.out.println(root + " ");
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }

    public Integer findHeight() {
        // ToDo 3: Find the height of a tree
        return getNodeHeight(this.root);
    }

    private Integer getNodeHeight(BstNode node){
        if(node == null)
            return -1;
        return Math.max(getNodeHeight(node.getLeft()), getNodeHeight(node.getRight()))+1;
    }
    

    public int getDepth(BstNode node) {
        //ToDo 4: complete getDepth of a node
        if(node == null)
            return 0;
        else {
            int Depth1 = getDepth(node.getLeft());
            int Depth2 = getDepth(node.getRight());

            if (Depth1 > Depth2)
                return (Depth1 + 1);
            else
                return (Depth2 + 1);
        }
    }

    
   public void print() {
       System.out.println("\n==== BST Print ===== \n");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }
    private void print(String str, BstNode node, boolean isLeft){
        if(node!=null)  {
            System.out.println(str + (isLeft ? "|--" : "\\--"));

            print(str + (isLeft ? "| " : " "), node.getLeft(), true);
            print(str + (isLeft ? "| " : " "), node.getRight(), false);
        }
    }
}
