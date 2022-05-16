package linked_list;

/*
This is utility class for Linked List where we have lots of common method that can be used while coding
 */
public final class UtilityClassLL {

    //Definition for singly-linked list with a next pointer.
     public static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { this.val = x; next=null;}
    };

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
}
