package linked_list;

import java.util.Scanner;
import java.util.Stack;

/*
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.

 */
public class PalindromeLL {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        while (true){
            int N = sc.nextInt();

            PalindromeLL ba = new PalindromeLL();
            ListNode A = ba.generateLL(N, sc);
            int res = ba.solve( A);
            System.out.println(res);
        }

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
        if(slow.next==null){ // only 2 elements
            if(A!=null && A.next!=null && A.val == A.next.val){
                return 1;
            }else if(A!=null && A.next == null){
                return 1;
            }else{
                return 0;
            }
        }
        ListNode head2 = slow.next, nxt, prev=null;
        slow.next = null;
        //reverse the second half
        ListNode temp = new ListNode(-1);
        temp.next = head2;
        head2=temp;
        ListNode curr=head2;

        ListNode prevStart=curr;
        curr = curr.next;
        printLL(head2);
        //System.out.println(prevStart.val +" "+curr.val);
        while (curr.next!=null){
            nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prevStart.next;
            prevStart.next = nxt;
            //printLL(A);
        }
        head2 = head2.next;
        printLL(A);
        printLL(head2);

        curr =A; ListNode curr2 = head2;
        while (curr!= null && curr2!= null){
            if(curr.val!= curr2.val){
                return 0;
            }
            curr = curr.next;
            curr2 = curr2.next;
        }
        if(curr!=null && curr.next!=null && curr.val == curr.next.val){
            return 1;
        }else if(curr!=null && curr.next == null){
            return 1;
        }
        else {
            return 0;
        }
    }

    public void printLL(ListNode head){
        ListNode curr=head;
        while(curr!=null){
            System.out.print(" "+curr.val);
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode generateLL(int length, Scanner sc){
        ListNode head=null, curr= null;
        for(int i=0; i<length; i++){
            ListNode temp = new ListNode(sc.nextInt());
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
