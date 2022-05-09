package tree;

import java.util.*;

/*
   Given a binary tree, return the level order traversal of its nodes' values.
   (i.e., from left to right, level by level).
 */
public class DeserializeBinaryTree {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            A.add(sc.nextInt());
        }
        DeserializeBinaryTree obj = new DeserializeBinaryTree();
        TreeNode root = obj.solve(A);
        ArrayList<Integer> res = obj.inorderTraversal(root);
        System.out.println(res);
    }
    public TreeNode solve(ArrayList<Integer> A) {
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
