package linked.list;

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
}
