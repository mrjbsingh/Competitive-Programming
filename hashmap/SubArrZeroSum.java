package hashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.
*/
public class SubArrZeroSum{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        SubArrZeroSum pm = new SubArrZeroSum();
        int res = pm.solve(A);
        
        System.out.print(res);
        
        
        
    }
    public int solve(ArrayList<Integer> A) {
        int n= A.size();
        Map<Long, Integer> hmap = new HashMap<>();
        long sum=0;
        for(int i=0; i<n; i++){
            sum += A.get(i);
            if(A.get(i)==0){
                return 1;
            }
            if(sum==0){
                return 1;
            }
            else if(hmap.containsKey(sum)){
                return 1;
            }
            hmap.put(sum, 1);
        }
        return 0;
    }
}