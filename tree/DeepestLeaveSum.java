package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
   https://leetcode.com/problems/deepest-leaves-sum/
 */
public class DeepestLeaveSum {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        DeepestLeaveSum obj = new DeepestLeaveSum();
        ArrayList<ArrayList<Integer>> res = obj.levelOrder(root);
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
    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        TreeNode curr, last;
        q.add(root);
        last=root;

        ArrayList<Integer> nodeAtLevel = new ArrayList<>();
        while (!q.isEmpty()){
            curr = q.remove();
            nodeAtLevel.add(curr.val);
            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
            if(curr == last){
                res.add(nodeAtLevel);
                nodeAtLevel = new ArrayList<>();
                last = q.peekLast();
            }
        }
        int lastLevel = res.size()-1; int sum =0;
        for (int i = 0; i < res.get(lastLevel).size() ; i++) {
            sum+= res.get(lastLevel).get(i);
        }
        return sum;
    }
}
