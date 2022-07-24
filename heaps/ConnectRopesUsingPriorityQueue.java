package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
You are given an array A of integers that represent the lengths of ropes.

You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.
*/
public class ConnectRopesUsingPriorityQueue {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int A[] = new int[size1];

        for (int i = 0; i < size1; i++) {
            A[i] = sc.nextInt();
        }
    
        ConnectRopesUsingPriorityQueue pm = new ConnectRopesUsingPriorityQueue();
        int res = pm.solve(A); 
        System.out.println(res);
        
    }
    public int solve(int[] A) {
        PriorityQueue< Integer > pq = new PriorityQueue<>();
        //max heap --> new PriorityQueue<>((a,b)-> b-a);
        int cost = 0;

        for (int x: A) {
            pq.offer(x);
        }

        // keep on removing elements from the queue untill there is one element in the queue
        while (pq.size() != 1) {
            int l1 = pq.poll();
            int l2 = pq.poll();
            cost += l1 + l2;
            pq.offer(l1 + l2);
        }

        return cost;
    }
    
}
//4 5 17 100 11