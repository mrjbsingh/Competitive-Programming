package tree;

import java.util.*;

/*
    inorderTraversal of tree without using recursion
 */
public class EqualTreePartition {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        EqualTreePartition obj = new EqualTreePartition();
        int res = obj.solve(root);
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
    public Map<TreeNode, Long> sumSubTree = new HashMap<>();
    public int solve(TreeNode root) {
        long totalSum = postorderSum(root);
        for(Map.Entry<TreeNode, Long> entry : sumSubTree.entrySet()){
            if(entry.getValue().equals(totalSum/2)){
                return 1;
            }
        }
        return 0;
    }
    public long postorderSum(TreeNode node){
        if(node == null)
            return 0;
        long leftSum = postorderSum(node.left);
        long rightSum = postorderSum(node.right);
        sumSubTree.put(node, (long) node.val + leftSum + rightSum);
        return sumSubTree.get(node);
    }
}
