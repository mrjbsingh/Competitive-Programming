package tree;

import java.util.*;

/*
   Given a binary tree, return the level order traversal of its nodes' values.
   (i.e., from left to right, level by level).
 */
public class LeveleOrderTraversal {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        LeveleOrderTraversal obj = new LeveleOrderTraversal();
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

      public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
          Deque<TreeNode> q = new LinkedList<>();
          ArrayList<ArrayList<Integer>> res = new ArrayList<>();
          TreeNode curr, last;
          q.add(A);
          last=A;
          ArrayList<Integer> level = new ArrayList<>();
          while (!q.isEmpty()){
              curr = q.remove();
              level.add(curr.val);
              if(curr.left!=null) q.add(curr.left);
              if(curr.right!=null) q.add(curr.right);
              if(curr == last){
                  res.add(level);
                  level = new ArrayList<>();
                  last = q.peekLast();
              }
          }
          return res;
    }
}
