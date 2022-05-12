package tree;

import java.util.*;

/*
   Given a binary tree, return a 2-D array with vertical order traversal of it.
   Go through the example and image for more details.
   NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
Input 1:

      6
    /   \
   3     7
  / \     \
 2   5     9
Output 1:
[
    [2],
    [3],
    [6, 5],
    [7],
    [9]
 ]
 */
public class VerticalOrderTraversal {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        TreeNode root = new TreeNode(8262);
        root.right = new TreeNode(411);

        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        ArrayList<ArrayList<Integer>>  res = obj.verticalOrderTraversal(root);
        System.out.println(res);
    }

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        Deque<TreeNodeWithDistance> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        TreeNodeWithDistance curr, last;
        int distanceFomRoot =0,
                leftMostFromRoot = Integer.MAX_VALUE, rightMostFromRoot = Integer.MIN_VALUE;
        Map<Integer, ArrayList<TreeNode>> hmap = new HashMap<>();

        q.add(new TreeNodeWithDistance(root, distanceFomRoot));
        last = q.peekLast();

        ArrayList<TreeNode> treeNodeArrayList;
        int key;
        while (!q.isEmpty()){
            curr = q.remove();
            key = curr.distance;
            if(hmap.containsKey(key)){
                treeNodeArrayList = hmap.get(key);
                treeNodeArrayList.add(curr.node);
                hmap.put(key, treeNodeArrayList);
            }else{
                treeNodeArrayList = new ArrayList<>();
                treeNodeArrayList.add(curr.node);
                hmap.put(key, treeNodeArrayList);
            }
            //System.out.println("distance entry "+ curr.distance +" val "+ curr.node.val);
            leftMostFromRoot = Math.min(leftMostFromRoot, curr.distance);
            rightMostFromRoot = Math.max(rightMostFromRoot, curr.distance);


            if(curr.node.left!=null) {
                //System.out.println(" left "+ curr.node.left.val + " distance "+ (curr.distance-1));
                q.add(new TreeNodeWithDistance(curr.node.left, (curr.distance-1)));
            }
            if(curr.node.right!=null) {
                //System.out.println(" right "+ curr.node.right.val + " distance "+ (curr.distance+1));
                q.add(new TreeNodeWithDistance(curr.node.right, (curr.distance+1)));
            }

            if(curr == last){
                last = q.peekLast();
            }
        }
        //System.out.println("leftMostFromRoot "+ leftMostFromRoot+ " rightMostFromRoot "+rightMostFromRoot);
        for (int i = leftMostFromRoot; i <= rightMostFromRoot ; i++) {
            //System.out.println(i);
            treeNodeArrayList = hmap.get(i);
            ArrayList<Integer> tempArr = new ArrayList<>();
            for (int j = 0; j < treeNodeArrayList.size(); j++) {
                //System.out.print(treeNodeArrayList.get(j).val+" ");
                tempArr.add(treeNodeArrayList.get(j).val);
            }
            //System.out.println(tempArr);
            res.add(tempArr);
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
