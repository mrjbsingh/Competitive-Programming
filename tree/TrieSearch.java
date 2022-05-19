package tree;

import java.util.*;

/*
   Given an array where elements are sorted in ascending order, convert it to a
   height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which
the depth of the two subtrees of every node never differ by more than 1.
 */
public class TrieSearch {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<String> dictonary = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            dictonary.add(sc.next());
        }
        int size2 = sc.nextInt();
        ArrayList<String> searchWords = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            searchWords.add(sc.next());
        }

        TrieSearch obj = new TrieSearch();
        ArrayList<Integer> res = obj.solve(dictonary, searchWords);
        System.out.println(res);
    }
    //Definition for binary tree
    static class TrieNode {
        char val;
        int freq;
        Map<Character, TrieNode> children;
        TrieNode(char x) {
            val = x;
            freq= 0;
            children = new HashMap<>();
        }

    }

    public ArrayList<Integer> solve(ArrayList<String> dictionary, ArrayList<String> searchWords) {
        TrieNode trieNode = new TrieNode('0');
        for (int i = 0; i < dictionary.size(); i++) {
            insertIntoTrie(trieNode, dictionary.get(i));
        }
        ArrayList<Integer>  res = new ArrayList<>();
        for (int i = 0; i < searchWords.size(); i++) {
            res.add(searchIntoTrie(trieNode, searchWords.get(i)));
        }

        return res;

    }
     public void insertIntoTrie(TrieNode trieNode, String inputWord){
         System.out.println(inputWord);
         char word[] = inputWord.toCharArray();
         for (int j = 0; j < word.length; j++) {
             if(trieNode.children.containsKey(word[j])){
                 trieNode = trieNode.children.get(word[j]);
             }else{
                 trieNode.children.put(word[j], new TrieNode(word[j]));
                 trieNode = trieNode.children.get(word[j]);
             }
         }
         trieNode.freq++;
     }
    public int searchIntoTrie(TrieNode trieNode, String searchWord){
        char word[] = searchWord.toCharArray();
        for (int j = 0; j < word.length; j++) {
            if(trieNode.children.containsKey(word[j])){
                trieNode = trieNode.children.get(word[j]);
            }else{
                return 0;
            }
        }
        if(trieNode.freq>0)
            return 1;
        else
            return 0;
    }
}
