package hashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Shaggy has an array A consisting of N elements. We call a pair of 
distinct indices in that array a special if elements at those indices 
in the array are equal.

Shaggy wants you to find a special pair such that the distance between 
that pair is minimum. Distance between two indices is defined as |i-j|. 
If there is no special pair in the array, then return -1.*/
public class LongestConsecutiveSeq{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        LongestConsecutiveSeq pm = new LongestConsecutiveSeq();
        int res = pm.solve(A);
        
        System.out.print(res);
        
        
        
    }
    public int solve(ArrayList<Integer> A) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<A.size(); i++){
            hmap.put(A.get(i),1);
        }
        int count, ans=Integer.MIN_VALUE;
        for(int i=0; i<A.size(); i++){
            
            if(!hmap.containsKey(A.get(i)-1)){
                int key = A.get(i);
                System.out.println((key+1)+" key++ & val "+hmap.containsKey(key+1));
                count=1;
                while(hmap.containsKey(key+1)){
                    count++;
                    key++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}