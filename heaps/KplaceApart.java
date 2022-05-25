package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
N people having different priorities are standing in a queue.

The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.
*/
public class KplaceApart {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        KplaceApart pm = new KplaceApart();
        ArrayList<Integer> res = pm.solve(A, B);
        System.out.println(res);
        
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            pq.offer(A.get(i));
            if(i>=B){ //0 index based array
                res.add(pq.poll());
            }
        }
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        return res;
    }
}
//284628164
