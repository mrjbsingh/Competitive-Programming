package tree;

import java.util.*;

/*
   Given an array where elements are sorted in ascending order, convert it to a
   height Balanced Binary Search Tree (BBST).

Balanced tree : a height-balanced binary tree is defined as a binary tree in which
the depth of the two subtrees of every node never differ by more than 1.
 */
public class TrieAutoComplete {
    public static void main(String[] args) {
        //System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        while (testCase-->0){
            int size1 = sc.nextInt();
            int size2 = sc.nextInt();
            ArrayList<String> dictonary = new ArrayList<>();
            for (int i = 0; i < size1; i++) {
                dictonary.add(sc.next());
            }
            ArrayList<Integer> weights = new ArrayList<>();
            for (int i = 0; i < size1; i++) {
                weights.add(sc.nextInt());
            }
            ArrayList<String> searchWords = new ArrayList<>();
            for (int i = 0; i < size2; i++) {
                searchWords.add(sc.next());
            }

            TrieAutoComplete obj = new TrieAutoComplete();
            ArrayList<ArrayList<String>> res = obj.solve(dictonary, weights, searchWords);
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j)+" ");
                }
                System.out.println();
            }
        }


    }
    //Definition for binary tree
    static class TrieNode {
        char val;
        int freq;
        int weight;
        String word;
        boolean isEnd;
        Map<Character, ArrayList<TrieNode>> children;
        ArrayList<TrieNode> endWords;
        TrieNode(char x) {
            val = x;
            freq= 0;
            weight=0;
            isEnd = false;
            children = new HashMap<>();
            endWords = new ArrayList<>();
        }

    }

    public ArrayList<ArrayList<String>>solve(ArrayList<String> dictionary, ArrayList<Integer> weights, ArrayList<String> searchWords) {
        TrieNode trieNode = new TrieNode('0');
        for (int i = 0; i < dictionary.size(); i++) {
            insertIntoTrie(trieNode, dictionary.get(i), weights.get(i));
        }
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWords.size(); i++) {
            res.add(autoCompleteFromTrie(trieNode, searchWords.get(i)));
        }

        return res;

    }
     public void insertIntoTrie(TrieNode trieNode, String inputWord, Integer weight){
         Stack<TrieNode> prefixNodes = new Stack<>();
         char word[] = inputWord.toCharArray();

         for (int j = 0; j < word.length; j++) {
             prefixNodes.push(trieNode);
             if(trieNode.children.containsKey(word[j]) && j!= word.length-1){
                 trieNode = trieNode.children.get(word[j]).get(0);
             }else{
                 TrieNode child = new TrieNode(word[j]);
                 ArrayList<TrieNode> childrenList;
                 if(trieNode.children.containsKey(word[j])){
                     childrenList = trieNode.children.get(word[j]);
                 }else{
                     childrenList = new ArrayList<>();
                 }
                 childrenList.add(child);
                 trieNode.children.put(word[j], childrenList);
                 trieNode = child;
             }
         }
//         if(trieNode.freq>=1){
//             TrieNode parent = prefixNodes.peek();
//             TrieNode sibiling =  new TrieNode(word[inputWord.length()-1]);
//             parent.children.put(word[inputWord.length()-1], sibiling);
//             trieNode = trieNode.children.get(word[j]);
//         }
         prefixNodes.push(trieNode);
         trieNode.weight = weight;
         trieNode.word = inputWord;
         trieNode.freq++;
         trieNode.isEnd = true;

         //making all parent to point toward children having complete word so autocomplete work fast due to pre-computation
         while (!prefixNodes.isEmpty()){
             TrieNode parent = prefixNodes.pop();
             parent.endWords.add(trieNode);
             Collections.sort(parent.endWords, new SortTreeByWeight());
             if(parent.endWords.size()>5){
                 parent.endWords.remove(5);
             }
         }
     }
    public ArrayList<String> autoCompleteFromTrie(TrieNode trieNode, String searchWord){
        boolean notFound = false;
        ArrayList<String> res = new ArrayList<>();
        ArrayList<TrieNode> temp = new ArrayList<>();
        char word[] = searchWord.toCharArray();
        for (int j = 0; j < word.length; j++) {
            if(trieNode.children.containsKey(word[j])){
                //System.out.println(trieNode.children.get(word[j]));
                ArrayList<TrieNode> childrenList = trieNode.children.get(word[j]);
                if(childrenList.size()==1){
                    trieNode = childrenList.get(0);
                }else{

                    for (int i = 0; i < childrenList.size(); i++) {
                        String str = childrenList.get(i).word;
                        if(str == null || str.charAt(str.length()-1)!=word[j]){
                            trieNode = childrenList.get(i);
                        }
                        if(childrenList.get(i).isEnd && childrenList.get(i).word.equals(searchWord)){
                            temp.addAll(childrenList.get(i).endWords);
//                            for (int k = 0; k < childrenList.get(i).endWords.size(); k++) {
//                                temp.add(childrenList.get(i).endWords.get(k));
//                            }
                        }

                    }
                }
            }else{
               notFound = true;
               break;
            }
        }

        if(!notFound){
//            Collections.sort(trieNode.endWords, new SortTreeByWeight());
//            // returning the best 5
            temp.addAll(trieNode.endWords);
            Collections.sort(temp, new SortTreeByWeight() );
            for (int i = 0; i<5 && i <temp.size(); i++) {
                res.add(temp.get(i).word);
            }
        }else{
            res.add("-1");
        }


        return res;
    }

    class SortTreeByWeight implements Comparator<TrieNode> {
        @Override
        public int compare(TrieNode node1, TrieNode node2) {
            if(node1.weight < node2.weight)
                return 1;
            else
                return -1;
        }
    }
}
// a-b-b-c
// a-b
// a-b
// a-b-b
// a-b-b-e