package twopointer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
*/
public class AllPairSumK{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        
        AllPairSumK pm = new AllPairSumK();
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
        long count=0;
        long M= 1000000007;
         for(int i=0; i<A.size();i++){
            if(hmap.containsKey(B-A.get(i))){
                int temp = hmap.get(A.get(i));
                hmap.put(A.get(i), --temp);
                int val = hmap.get(B-A.get(i));
                count = (count+ val)%M;
                hmap.put(A.get(i), ++temp);
            }
        }
        count = (count*modInverse(2,M))%M;
        return (int)count;
    }
    public long modInverse(long a, long m)
    {
        long m0 = m;
        long y = 0, x = 1;
 
        if (m == 1)
            return 0;
 
        while (a > 1) {
            // q is quotient
            long q = a / m;
 
            long t = m;
 
            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;
            t = y;
 
            // Update x and y
            y = x - q * y;
            x = t;
        }
 
        // Make x positive
        if (x < 0)
            x += m0;
 
        return x;
    }
}