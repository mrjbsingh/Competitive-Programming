package twopointer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Given an one-dimensional integer array A of size N and an integer B.

Count all distinct pairs with difference equal to B.
*/
public class DistinctPairWithKDiff{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        
        DistinctPairWithKDiff pm = new DistinctPairWithKDiff();
        int res = pm.solve(A, B);
        
        System.out.print(res);
        
        
        
    }
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<A.size();i++){
            if(hmap.containsKey(A.get(i))){
                int val = hmap.get(A.get(i));
                hmap.put(A.get(i), ++val);
            }
            else
                hmap.put(A.get(i), 1);
        }
        int count=0;
        for(Map.Entry<Integer, Integer> e: hmap.entrySet()){
            if(B==0 && e.getValue()>1){
                count++;
            }
            else if(B!=0 && hmap.containsKey(e.getKey()+B)){
                count++;
            }
        }
        return count;
    }
    
}