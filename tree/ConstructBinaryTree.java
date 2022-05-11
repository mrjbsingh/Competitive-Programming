package tree;

import java.util.*;

import static my.utility.CodeTemplate.waitfun;

/*
   Given the inorder and postorder traversal of a tree, construct the binary tree.

NOTE: You may assume that duplicates do not exist in the tree.
 */
public class ConstructBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            A.add(sc.nextInt());
        }
        int size2 = sc.nextInt();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            B.add(sc.nextInt());
        }
        ConstructBinaryTree obj = new ConstructBinaryTree();
        TreeNode root = obj.buildTree(A, B);
        ArrayList<Integer> res = obj.inorderTraversal(root);
        System.out.println(res);
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = B.size();

        return buildHelper(A,B, 0, n, n);
    }
    public TreeNode buildHelper(ArrayList<Integer> A, ArrayList<Integer> B, int start, int end, int postOrderLastIndex){

        if(start>=end)
            return null;
        TreeNode root = new TreeNode(B.get(postOrderLastIndex-1));
        int rootIndex = findRootIndex(A, start, end, B.get(postOrderLastIndex-1));
        int lengthOfRightPart = end-rootIndex;

        root.left = buildHelper(A,B, start, rootIndex, postOrderLastIndex-lengthOfRightPart);
        root.right = buildHelper( A, B, rootIndex+1, end, postOrderLastIndex-1);
        return root;
    }

    public int findRootIndex(ArrayList<Integer> inorderTraversal, int start, int end, int search){

        for (int i = start; i < end; i++) {
            if(inorderTraversal.get(i).equals(search)){
                return i;
            }
        }
        return -1;
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
