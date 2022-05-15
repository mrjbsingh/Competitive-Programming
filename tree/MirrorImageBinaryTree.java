package tree;

import java.util.Scanner;

/*
  Given a binary tree of integers denoted by root A.
  Return an array of integers representing the right view of the Binary tree.
  Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
 */
public class MirrorImageBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        MirrorImageBinaryTree obj = new MirrorImageBinaryTree();
        TreeNode res = obj.invertTree(root);
        System.out.println(res);
    }
    public TreeNode invertTree(TreeNode node) {
        if(node==null)
            return null;
        TreeNode temp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(temp);
        return node;
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
