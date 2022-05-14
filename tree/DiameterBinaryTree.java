package tree;

import java.util.Scanner;

/*
  Given a binary tree of integers denoted by root A.
  Return an array of integers representing the right view of the Binary tree.
  Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
 */
public class DiameterBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello"+ String.valueOf(100).length());
        String str = new String("jay");
        str.toCharArray();
        int aa[] = new int[10];
        System.out.println(aa.length);
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        DiameterBinaryTree obj = new DiameterBinaryTree();
        int res = obj.solve(root);
        System.out.println(res);
    }
    public int diameter=0;
    public int solve(TreeNode root) {
        int height  = calculateHeight(root);
        return diameter;
    }

    public int calculateHeight(TreeNode root){
        if(root== null)
            return -1;
        int leftHeight  = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);
        //System.out.print("root.val "+root.val+" leftHeight "+leftHeight+ " rightHeight "+ rightHeight);
        diameter = Math.max(diameter, leftHeight + rightHeight +2);  // for two edges
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
