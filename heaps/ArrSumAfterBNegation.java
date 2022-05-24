package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Given an array of integers A and an integer B. You must modify the array exactly B number of times.
In a single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
*/
public class ArrSumAfterBNegation {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
    
        ArrSumAfterBNegation pm = new ArrSumAfterBNegation();
        ArrayList<Integer> res = pm.solve(A);
        System.out.println(res);
        
    }
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum=0, temp;
        for (int i = 0; i < A.size(); i++) {
            pq.offer(A.get(i));
        }
        for (int i = 0; i < B; i++) {
            temp = pq.poll();
            pq.offer(-1*temp);
        }
        while (!pq.isEmpty()){
            sum+= pq.poll();
        }
        return sum;
    }

}
//284628164
