package tree;

import java.util.*;

/*
   Given an array where elements are sorted in ascending order, convert it to a
   height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which
the depth of the two subtrees of every node never differ by more than 1.
 */
public class ArrToBST {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        final List<Integer> A = new ArrayList<Integer>();

        ArrToBST obj = new ArrToBST();
        TreeNode res = obj.sortedArrayToBST(A);
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

    public TreeNode sortedArrayToBST(final List<Integer> A) {


        return helperArrToBST(A, 0, A.size()-1);
    }
    public TreeNode helperArrToBST( final List<Integer> A, int L, int R){
        if(L>R)
            return null;
        int mid = L+(R-L)/2;
        TreeNode node = new TreeNode(A.get(mid));
        node.left = L>=0?helperArrToBST(A, L, mid-1): null;
        node.right = R<A.size()?helperArrToBST(A, mid+1, R):null;

        return node;
    }
}
