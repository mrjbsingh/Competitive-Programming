    package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/*
  Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.

Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or
directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 */
public class LeastCommonAncestor {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            A.add(sc.nextInt());
        }
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);

        int B = sc.nextInt();
        int C = sc.nextInt();
        LeastCommonAncestor obj = new LeastCommonAncestor();
        TreeNode root = obj.deserializeBinaryTree(A);
        int res = obj.lca(root, B, C);
        System.out.println(res);
    }
    public boolean flagIsBalanced=true;
    public int lca(TreeNode root, int B, int C) {
        ArrayList<Integer> pathB = new ArrayList<>();
        ArrayList<Integer> pathC = new ArrayList<>();

        if(B == C)
            return B;
        postOrderSearch(root, B, pathB);
        postOrderSearch(root, C, pathC);

        System.out.print(pathB);
        System.out.println(pathC);
        if(pathB.isEmpty() || pathC.isEmpty())
            return -1;

        int iteratorB = pathB.size()-1, iteratorC = pathC.size()-1;
        while (( iteratorB>=0 && iteratorC>=0 && pathB.get(iteratorB).equals(pathC.get(iteratorC)))){
            iteratorB--;
            iteratorC--;
        }
        if(iteratorB>=0){
            return pathB.get(iteratorB+1);
        }
        else if(iteratorC>=0){
            return pathC.get(iteratorC+1);
        }
        else if(iteratorB ==-1 && iteratorC ==-1){
            return pathB.get(0);
        }
        return root.val;
    }
    public void postOrderSearch(TreeNode root, int B, ArrayList<Integer> path){
        if (root == null)
            return;
        if (root.val == B){
            path.add(root.val);
            return;
        }

        postOrderSearch(root.left, B, path);
        if(path.isEmpty())
            postOrderSearch(root.right, B, path);
        if(!path.isEmpty()){
            path.add(root.val);
        }
    }
    public TreeNode deserializeBinaryTree(ArrayList<Integer> A) {
        TreeNode root =null, curr;
        Deque<TreeNode> dq = new LinkedList();
        root = new TreeNode(A.get(0));
        dq.add(root);

        for (int i = 1; i <A.size() ; i+=2) {
            curr = dq.peek();
            if(A.get(i)!=-1){
                curr.left = new TreeNode(A.get(i));
                dq.add(curr.left);
            }
            if(A.get(i+1)!=-1){
                curr.right = new TreeNode(A.get(i+1));
                dq.add(curr.right);
            }
            dq.removeFirst();
        }
        return root;
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
