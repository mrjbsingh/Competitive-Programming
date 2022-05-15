package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
   Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree and try to solve this in constant extra space.
 */
public class NextPointerBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.right.left = new TreeLinkNode(4);
        root.right.left.right = new TreeLinkNode(5);

        NextPointerBinaryTree obj = new NextPointerBinaryTree();
        obj.connect(root);
        
    }
    //Definition for binary tree
    static class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x) {
            val = x;
            left = null;
            right = null;
            next = null;
        }
    }
    public void connect(TreeLinkNode root) {
        levelOrderApplication(root);
    }
    public void levelOrderApplication(TreeLinkNode A) {
        Deque<TreeLinkNode> q = new LinkedList<>();

        TreeLinkNode curr, last;
        q.add(A);
        last=A;

        while (!q.isEmpty()){
            curr = q.remove();

            if(curr.left!=null) q.add(curr.left);
            if(curr.right!=null) q.add(curr.right);
            if(curr == last){
                last = q.peekLast();
            }else{
                curr.next = q.getFirst();
            }
        }
    }
}
