package tree;

import java.util.Scanner;

/*
 Given a binary tree A, flatten it to a linked list in-place.
 The left child of all nodes should be NULL.
 */
public class FlattenBinaryTreeLL {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);

        FlattenBinaryTreeLL obj = new FlattenBinaryTreeLL();
        TreeNode res = obj.flatten(root);
        System.out.println(res);
    }
    public TreeNode flatten(TreeNode root) {
        Pair res = helperFlatten(root);
        return res.head;
    }
    public Pair helperFlatten(TreeNode node){
        if(node== null){
            return new Pair(null, null);
        }
        Pair leftSide = helperFlatten(node.left);
        Pair rightSide = helperFlatten(node.right);
        node.left = null;
        if(leftSide.head != null){
            node.right = leftSide.head;
            leftSide.tail.right = rightSide.head;
            return new Pair( node, rightSide.head!=null? rightSide.tail: leftSide.tail);
        }else {
            node.right = rightSide.head;
            // take care of this edge case if single node then head and tail are same node
            return new Pair(node, rightSide.tail!= null? rightSide.tail: node);
        }
    }
    static class Pair{
        TreeNode head;
        TreeNode tail;
        Pair(TreeNode head, TreeNode tail){
            this.head = head;
            this.tail = tail;
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
