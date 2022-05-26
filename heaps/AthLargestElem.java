package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
*/
public class AthLargestElem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int num = sc.nextInt();
        AthLargestElem pm = new AthLargestElem();
        ArrayList<Integer> res = pm.solve(num, A);
        System.out.println(res);
        
    }
    public ArrayList<Integer> solve(int num, ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if(i <num){
                pq.offer(A.get(i));
                if(i<num-1)
                    res.add(-1);
                else
                    res.add(pq.peek());

            }else {
                int min = pq.peek();
                if(min<A.get(i)){
                    pq.poll();
                    pq.offer(A.get(i));
                }
                res.add(pq.peek());
            }
        }
        return res;
    }
}
//284628164
