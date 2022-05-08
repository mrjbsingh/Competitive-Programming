package linked.list;

import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

/*
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.
 */
public class RemoveLoopLL {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        //int sizeOfLL = sc.nextInt();

        ListNode A = generateLL(10);
        A = makingLoopAtIndex(A,4);

        RemoveLoopLL ba = new RemoveLoopLL();
        ListNode res = ba.solve( A);
        printLL(res);
    }

     //Definition for singly-linked list with a random pointer.
     static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { this.val = x; next=null;}
    };
    // 1->2->3->4->5->6->7
    // 1->2->6->5->4->3->7
    public ListNode solve(ListNode A) {
        ListNode fast=A;
        ListNode slow=A;
        do{
            fast = fast.next.next;
            slow= slow.next;
            System.out.println(slow.val+" ");
            System.out.println(fast.val+" ");
        }while(fast!=slow);
        ListNode start = A;
        //meeting point of these to pointer are start of loop
        System.out.println("After meeting");
        while(start.next!=slow.next){
            start = start.next;
            slow= slow.next;
            System.out.println(slow.val+" ");
        }
        slow.next = null;
        return A;
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
    /*
    This method will make last pointer to point toward given index
     */
    public static ListNode makingLoopAtIndex(ListNode A, int index){
        ListNode curr, lastNode;
        curr = A;
        while (curr.next!=null){
            curr = curr.next;
        }
        lastNode = curr;
        curr = A;
        while (index-- >0){
            curr = curr.next;
        }
        lastNode.next = curr;
        return A;
    }
}
