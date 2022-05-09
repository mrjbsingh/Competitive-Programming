package tree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
    inorderTraversal of tree without using recursion
 */
public class InorderTraversal {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        InorderTraversal obj = new InorderTraversal();
        ArrayList<Integer> res = obj.inorderTraversal(root);
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
      //LNR -
     //res - 6,1, 3, 2
    // 1->2->3->4->5->6->7
    // 1->2->6->5->4->3->7
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
