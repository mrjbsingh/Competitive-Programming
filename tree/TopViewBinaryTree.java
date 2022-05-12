package tree;

import java.util.*;

/*
   Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

   The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

   Return the nodes in any order.
Input 1:


            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8
Output 1:

 [1, 2, 4, 8, 3, 7]

 */
public class TopViewBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        TopViewBinaryTree obj = new TopViewBinaryTree();
        ArrayList<Integer> res = obj.solve(root);
        System.out.println(res);
    }
    public ArrayList<Integer> solve(TreeNode root) {

        return levelOrderModified(root);
    }
    public ArrayList<Integer> levelOrderModified(TreeNode root) {
        Deque<TreeNodeWithDistance> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        TreeNodeWithDistance curr, last;
        int distanceFomRoot =0;
        Map<Integer, Integer> hmap = new HashMap<>();
        q.add(new TreeNodeWithDistance(root, distanceFomRoot));
        last = q.peekLast();

        while (!q.isEmpty()){
            curr = q.remove();
            if(!hmap.containsKey(curr.distance)){
                hmap.put(curr.distance, curr.node.val);
                res.add(curr.node.val);
            }

            if(curr.node.left!=null) q.add(new TreeNodeWithDistance(curr.node.left, curr.distance-1));
            if(curr.node.right!=null) q.add(new TreeNodeWithDistance(curr.node.right, curr.distance+1));
            if(curr == last){
                last = q.peekLast();
            }
        }
        return res;
    }
    public class TreeNodeWithDistance{
        TreeNode node;
        int distance;
        TreeNodeWithDistance(TreeNode node, int distance){
            this.node = node;
            this.distance = distance;
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
}
