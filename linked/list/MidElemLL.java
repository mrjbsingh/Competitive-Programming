package linked.list;

import java.util.Scanner;

/*
Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.

 */
public class MidElemLL {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        MidElemLL ba = new MidElemLL();
        ListNode A = ba.generateLL(N);
        int res = ba.solve( A);
        System.out.println(res);
    }

     //Definition for singly-linked list with a random pointer.
     static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { this.val = x; next=null;}
    };
    // 1->2->3->4->5->6->7
    // 1->2->6->5->4->3->7
    public int solve(ListNode A) {
        ListNode fast=A;
        ListNode slow=A;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow= slow.next;
        }
        return slow.val;
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
