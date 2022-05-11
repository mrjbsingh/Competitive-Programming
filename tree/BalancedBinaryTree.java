package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
  Given a binary tree of integers denoted by root A.
  Return an array of integers representing the right view of the Binary tree.
  Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
 */
public class BalancedBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        BalancedBinaryTree obj = new BalancedBinaryTree();
        int res = obj.isBalanced(root);
        System.out.println(res);
    }
    public boolean flagIsBalanced=true;
    public int isBalanced(TreeNode root) {
        int height = calculateHeight(root);

        return flagIsBalanced?1:0;
    }
    public int calculateHeight(TreeNode root){
        if(root== null)
            return 0;
        int leftHeight  = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        //System.out.print("root.val "+root.val+" leftHeight "+leftHeight+ " rightHeight "+ rightHeight);
        if(Math.abs(leftHeight - rightHeight)>1){
            flagIsBalanced = false;
        }
        return Math.max(leftHeight, rightHeight)+1;
    }
    //Definition for binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

}
