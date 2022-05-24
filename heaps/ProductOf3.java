package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Given an integer array A of size N.

You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A.
If i < 3, then the integer at index i in B should be -1.
*/
public class ProductOf3 {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
    
        ProductOf3 pm = new ProductOf3();
        ArrayList<Integer> res = pm.solve(A);
        System.out.println(res);
        
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();
        int product=1;
        for (int i = 0; i < A.size(); i++) {
            if(i<3){

                pq.offer(A.get(i));
                product*=A.get(i);
                if(i<2)
                    res.add(-1);
                else
                    res.add(product);
            }else {
                int min = pq.peek();
                if(A.get(i)>min){
                    product/=min;
                    product*=A.get(i);
                    pq.poll();
                    pq.offer(A.get(i));
                }
                res.add(product);
            }
        }
        return res;
    }
}
//284628164
