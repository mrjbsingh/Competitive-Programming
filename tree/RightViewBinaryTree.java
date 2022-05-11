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
public class RightViewBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        RightViewBinaryTree obj = new RightViewBinaryTree();
        ArrayList<Integer> res = obj.solve(root);
        System.out.println(res);
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
    public ArrayList<Integer> solve(TreeNode A) {
        Deque<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr, last;
        q.add(A);
        last=A;
        res.add(last.val);
        while (!q.isEmpty()){
            curr = q.remove();
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
            if(curr == last){
                last = q.peekLast();
                if(last!=null)
                res.add(last.val);
            }
        }
        return res;
    }
}
