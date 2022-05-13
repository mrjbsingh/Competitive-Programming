package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/*
    Two elements of a binary search tree (BST), represented by root A are swapped by mistake.
    Tell us the 2 values swapping which the tree will be restored.

    A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
 */
public class FindSwapedNodeBST {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        FindSwapedNodeBST obj = new FindSwapedNodeBST();
        ArrayList<Integer> res = obj.inorderTraversal(root);
        System.out.println(res);
    }
    public ArrayList<Integer> recoverTree(TreeNode root) {
        ArrayList<Integer> inorderTraversal= inorderTraversal(root);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < inorderTraversal.size() ; i++) {
            if(inorderTraversal.get(i-1)>inorderTraversal.get(i)){
                    res.add(inorderTraversal.get(i-1));
                    res.add(inorderTraversal.get(i));
            }
        }
        if(res.size()>2){
            res.remove(2);
            res.remove(1);
        }
        Collections.sort(res);
        return res;
    }

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = A;
        do{
            while(curr!=null){
                st.add(curr);
                curr= curr.left;
            }
            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }while(curr!=null || !st.isEmpty());

        return res;
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
