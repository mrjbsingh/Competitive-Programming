package linked.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeepCopyLL {
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        /*
        * I haven't taken proper input and output but implementation of
        * copyRandomList is correct as per problem statement
        */
        DeepCopyLL ba = new DeepCopyLL();
        RandomListNode res = ba.copyRandomList(new RandomListNode(10));
        System.out.println("res "+res.label);
    }

     //Definition for singly-linked list with a random pointer.
     static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> addressRef = new HashMap<>();
        RandomListNode curr = head;
        RandomListNode newHead= null;
        while (curr!= null){
            RandomListNode temp = new RandomListNode(curr.label);
            addressRef.put(curr, temp);
            if(curr == head){
                newHead = temp;
            }
            curr = curr.next;
        }
        curr = head;
        while (curr!= null){
            RandomListNode temp = addressRef.get(curr);
            temp.next = addressRef.get(curr.next);
            temp.random = addressRef.get(curr.random);
            curr = curr.next;
        }

        return newHead;
    }
}
