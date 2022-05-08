package queue;

import java.util.*;

/*
Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.
 */
public class SlidingMaximum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        SlidingMaximum ts = new SlidingMaximum();
        ArrayList<Integer> res = ts.slidingMaximum(A, B);

        System.out.println(res);

    }
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        Deque<ElemIndex> dq = new LinkedList<ElemIndex>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            ElemIndex temp = new ElemIndex();
            temp.elem = A.get(i);
            temp.index = i;
            while ( !dq.isEmpty() && A.get(i)>dq.getLast().elem){
                dq.removeLast();
            }
            dq.add(temp);
//            for (Iterator<ElemIndex> it = dq.iterator(); it.hasNext(); ) {
//                ElemIndex ei = it.next();
//                System.out.print(ei.elem+" ");
//            }
//            System.out.println();
            if(i>=B-1){
                while ( !dq.isEmpty() && dq.peek().index< i-(B-1)){
                    dq.remove();
                }
                res.add(dq.peek().elem);
            }
        }
        return res;
    }
    public static class ElemIndex{
        public int elem;
        public int index;
    }
}
//
//8
// 1 3 -1 -3 5 3 6 7
// 3