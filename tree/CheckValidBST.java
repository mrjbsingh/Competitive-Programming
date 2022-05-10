package tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
    inorderTraversal of tree without using recursion
 */
public class CheckValidBST {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        CheckValidBST obj = new CheckValidBST();
        int res = obj.isValidBST(root);
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
    public int isValidBST(TreeNode A) {
        ArrayList<Integer> inorderTraversal = inorderTraversal(A);
        //System.out.print(inorderTraversal);
        for(int i=1; i<inorderTraversal.size(); i++){
            if(inorderTraversal.get(i)<=inorderTraversal.get(i-1)){
                return 0;
            }
        }
        return 1;
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
}
