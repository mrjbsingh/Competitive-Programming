package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
  You are given a Binary Tree A with N nodes.

Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).

If the complete Binary Tree is BST, then return the size of the whole tree.

NOTE:

The largest subtree is the subtree with the most number of nodes.
 */
public class LargestBinarySearchTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            A.add(sc.nextInt());
        }

//        TreeNode root = new TreeNode(15);
//        root.left = new TreeNode(10);
//        root.right = new TreeNode(25);
//        root.left.left = new TreeNode(5);
//        root.left.right = new TreeNode(12);

        LargestBinarySearchTree obj = new LargestBinarySearchTree();
        TreeNode root = obj.generateBinaryTree(A);
        int res = obj.solve(root);
        System.out.println(res);
    }
//9 20 14 12 11 -1 -1 -1 -1 -1

    public int solve(TreeNode root) {
        BstNodeInfo rootInfo = helperBstInfo(root);

        return rootInfo.sizeOfSubTree;
    }
    public BstNodeInfo helperBstInfo(TreeNode root){
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, sizeOfBST=0;
        boolean isBST = true;

        if(root== null)
            return new BstNodeInfo(max, min, sizeOfBST, isBST);
        //System.out.println("Node - " + root.val);
        
        BstNodeInfo left  = helperBstInfo(root.left);
        BstNodeInfo right = helperBstInfo(root.right);
        min = Math.min(root.val, Math.min(left.min, right.min));
        max = Math.max(root.val, Math.max(left.max, right.max));

        if(left.max<= root.val && right.min> root.val){
            isBST = left.isBST && right.isBST;
        }
        else {
            isBST = false;
        }

        if(isBST)
            sizeOfBST = left.sizeOfSubTree + right.sizeOfSubTree + 1;
        else{

                sizeOfBST = Math.max(left.sizeOfSubTree, right.sizeOfSubTree);

        }
        BstNodeInfo node = new BstNodeInfo(max, min, sizeOfBST, isBST);
//        System.out.println("NODE "+node.toString());
//        System.out.println("Left "+left.toString());
//        System.out.println("RIGHT "+right.toString());
        return node;
    }
    public class BstNodeInfo{
        int max;
        int min;
        int sizeOfSubTree;
        boolean isBST;

        public BstNodeInfo(int max, int min, int sizeOfSubTree, boolean isBST) {
            this.max = max;
            this.min = min;
            this.sizeOfSubTree = sizeOfSubTree;
            this.isBST = isBST;
        }

        @Override
        public String toString() {
            return "BstNodeInfo{" +
                    "max=" + max +
                    ", min=" + min +
                    ", sizeOfSubTree=" + sizeOfSubTree +
                    ", isBST=" + isBST +
                    '}';
        }
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
    public TreeNode generateBinaryTree(ArrayList<Integer> deseralizeArr) {
        TreeNode root =null, curr;
        Deque<TreeNode> dq = new LinkedList();
        root = new TreeNode(deseralizeArr.get(0));
        dq.add(root);

        for (int i = 1; i <deseralizeArr.size() ; i+=2) {
            curr = dq.peek();
            if(deseralizeArr.get(i)!=-1){
                curr.left = new TreeNode(deseralizeArr.get(i));
                dq.add(curr.left);
            }
            if(deseralizeArr.get(i+1)!=-1){
                curr.right = new TreeNode(deseralizeArr.get(i+1));
                dq.add(curr.right);
            }
            dq.removeFirst();
        }
        return root;
    }
}
