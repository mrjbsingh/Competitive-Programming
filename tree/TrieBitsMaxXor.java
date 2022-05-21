package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 Given an array of integers A, find and return the maximum result of A[i] XOR A[j],
 where i, j are the indexes of the array.

 */
public class TrieBitsMaxXor {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }

        TrieBitsMaxXor obj = new TrieBitsMaxXor();
        int res = obj.solve(A);
        System.out.println(res);
    }
    //Definition for binary tree
    static class TrieNode {
        Boolean val;
        Integer num;
        Map<Boolean, TrieNode> child;

        TrieNode(Boolean x) {
            val = x;
            num = null;
            child = new HashMap<>();
        }
    }
    public int solve(ArrayList<Integer> A) {
        TrieNode root = new TrieNode(false);
        for (int i = 0; i < A.size(); i++) {
            insertIntoTrie(root, A.get(i));
        }

        return findMaxXor(root, A);

    }

    private int findMaxXor(TrieNode root, ArrayList<Integer> A) {
        int maxXor = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int  bestNum = searchIntoTrie(root, A.get(i));
            System.out.println("for num "+ A.get(i)+" bestNum is "+bestNum);
            maxXor = Math.max(maxXor, bestNum^A.get(i));
        }
        return maxXor;
    }

    public void insertIntoTrie(TrieNode trieNode, int num){

         for (int i = 31; i >=0 ; i--) {
            Boolean bit = (num & (1<<i))>0;
            if(trieNode.child.containsKey(bit)){
                trieNode = trieNode.child.get(bit);
            }
            else {
                trieNode.child.put(bit, new TrieNode(bit));
                trieNode = trieNode.child.get(bit);
            }
         }
         trieNode.num = num;
     }
    public int searchIntoTrie(TrieNode trieNode, int num){
        System.out.println("Num "+ num);
        for (int i = 31; i >=0 ; i--) {
            Boolean bit = (num & (1<<i))>0;
            //System.out.println(bit);
            if(trieNode.child.containsKey(!bit)){
                //System.out.println("Enter into anti-bit"+ !bit);
                trieNode = trieNode.child.get(!bit);
            }
            else if(trieNode.child.containsKey(bit)){
                trieNode = trieNode.child.get(bit);
            }
        }
        return trieNode.num;
    }
}
//6 20 30 15 25 10 5