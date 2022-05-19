package linked_list;

import java.util.Scanner;

/*
Merge two sorted linked lists, A and B, and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
Input 1:

 A = 5 -> 8 -> 20
 B = 4 -> 11 -> 15
 Output 1:

 4 -> 5 -> 8 -> 11 -> 15 -> 20
 */
public class MergeTwoSortedLL {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);

        MergeTwoSortedLL ba = new MergeTwoSortedLL();
        ListNode A = ba.generateLL(10);
        ListNode B = ba.generateLL(5);
        ListNode res = ba.mergeTwoLists( A, B);
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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode x=A, y=B;
        ListNode z, head;
        if(x.val > y.val){
            head = y;
            y = y.next;
        }else{
            head = x;
            x = x.next;
        }
        z = head;
        while(x!= null && y!= null){
            if(x.val > y.val){
                z.next = y;
                y = y.next;
                z = z.next;
            }else{
                z.next = x;
                x = x.next;
                z = z.next;
            }
        }
        if(x!= null)
            z.next = x;
        if(y!= null)
            z.next = y;
        return head;
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
            ListNode temp = new ListNode(i+length);
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
