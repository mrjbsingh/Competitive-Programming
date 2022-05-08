package linked.list;
import java.util.Scanner;

/*
Given a singly linked list A

 A: A0 → A1 → … → An-1 → An
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → …
You must do this in-place without altering the nodes' values.
 */
public class ReorderLL {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        //int sizeOfLL = sc.nextInt();

        ListNode A = generateLL(10);

        ReorderLL ba = new ReorderLL();
        ListNode res = ba.reorderList(A);
        printLL(res);
    }

     //Definition for singly-linked list with a random pointer.
     static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { this.val = x; next=null;}
    };

    public ListNode reorderList(ListNode A) {
        ListNode fast=A;
        ListNode slow=A;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow= slow.next;
        }
        if(slow.next == null){ // this case is possible only when size of LL is 1
            return A;
        }
        ListNode head2 = slow.next; // break from middle of linkList
        slow.next = null;

        System.out.println("1st half LL");
        printLL(A);
        System.out.println("2nd half LL");
        printLL(head2);
        System.out.println("Reverse the 2nd half");
        head2 = reverseList(head2);
        printLL(head2);

        A = mergeLinkList(A, head2);

        return A;
    }
    public static ListNode reverseList(ListNode A) {

        ListNode prevStart=null, curr=null, nxt=null;
        int count= A!=null?1:0;
        /*
        Adding a buffer node to avoid null pointer exception while reversing from head
         */
        ListNode temp = new ListNode(-1);
        temp.next = A;
        A=temp;
        curr=A;

        prevStart=curr;
        curr = curr.next;

        //System.out.println(prevStart.val +" "+curr.val);
        while (curr.next!=null){
            nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prevStart.next;
            prevStart.next = nxt;
            //printLL(A);
        }

        return A.next;
    }

    public static ListNode mergeLinkList(ListNode x, ListNode y){
        ListNode xnext, ynext, head;
        head = x;
        while (x!=null && y!=null){
            System.out.println("x "+x.val +" y "+y.val);
            xnext = x.next;
            x.next = y;
            ynext = y.next;
            y.next = xnext;
            x = xnext;
            y = ynext;
        }
        return head;
    }
    public static void printLL(ListNode head){
        ListNode curr=head;
        while(curr!=null){
            System.out.print(" "+curr.val);
            curr = curr.next;
        }
        System.out.println();
    }

    public static ListNode generateLL(int length){
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
