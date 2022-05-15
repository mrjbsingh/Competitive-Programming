package tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
    inorderTraversal of tree without using recursion
 */
public class kthSmallestElement {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        int k = sc.nextInt();

        kthSmallestElement obj = new kthSmallestElement();
        int res = obj.kthSmallest(root, k);
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
    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        do{
            while(curr!=null){
                st.add(curr);
                curr= curr.left;
            }

            curr = st.pop();
            k--;
            if(k==0){
                return curr.val;
            }
           curr = curr.right;
        }while(curr!=null || !st.isEmpty());

        return -1;
    }
}
