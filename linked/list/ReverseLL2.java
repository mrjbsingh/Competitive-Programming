package linked.list;

import java.util.Scanner;

/*
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Output 1:
 1 -> 4 -> 3 -> 2 -> 5
 */
public class ReverseLL2 {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int B = sc.nextInt();
        int C = sc.nextInt();

        ReverseLL2 ba = new ReverseLL2();
        ListNode A = ba.generateLL(10);
        ListNode res = ba.reverseBetween( A, B, C);
        ba.printLL(res);
    }

     //Definition for singly-linked list with a random pointer.
     static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { this.val = x; next=null;}
    };
    // 1->2->3->4->5->6->7
    // 1->2->6->5->4->3->7
    public ListNode reverseBetween(ListNode A, int B, int C) {

        ListNode prevStart=null, curr=null, nxt=null;
        int count= A!=null?1:0;
        /*
        Adding a buffer node to avoid null pointer exception while reversing from head
         */
        ListNode temp = new ListNode(-1);
        temp.next = A;
        A=temp;

        curr=A;
        while(count<=B){
            prevStart=curr;
            curr = curr.next;
            count++;
        }
        //System.out.println(prevStart.val +" "+curr.val);
        while (count<=C){
            nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prevStart.next;
            prevStart.next = nxt;
            count++;
            //printLL(A);
        }

        return A.next;
    }
    public void printLL(ListNode head){
        ListNode curr=head;
        while(curr!=null){
            System.out.print(" "+curr.val);
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode generateLL(int length){
        ListNode head=null, curr= null;
        for(int i=1; i<length; i++){
            ListNode temp = new ListNode(i);
            if(head == null){
                head = temp;
                curr= head;
            }else{
                curr.next =temp;
                curr= curr.next;
            }
        }
        return head;
    }
}
