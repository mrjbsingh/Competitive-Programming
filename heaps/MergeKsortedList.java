package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
Given a list containing head pointers of N sorted linked lists.
Merge these given sorted linked lists and return them as one sorted list.
*/
public class MergeKsortedList {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <ListNode> A = new ArrayList<ListNode>();
    
        MergeKsortedList pm = new MergeKsortedList();
        ListNode res = pm.mergeKLists(A);
        System.out.println(res);
        
    }
    public ListNode mergeKLists(ArrayList<ListNode> streams) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode a, ListNode b)-> Integer.compare(a.val, b.val));
        ListNode newHead =null, curr=null, min;
        //first elem off all streams
        for (int i = 0; i < streams.size(); i++) {
            pq.offer(streams.get(i));
        }

        while (!pq.isEmpty()){
            min = pq.poll();
            if(newHead == null){
                newHead = min;
                curr = min;
            }else {
                curr.next = min;
                curr = curr.next;
            }
            if(min.next!= null){
                pq.offer(min.next);
            }
        }
        return newHead;
    }
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }
}
//284628164
