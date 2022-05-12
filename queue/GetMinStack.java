package queue;

import java.util.*;

/*
Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
NOTE:

All the operations have to be constant time operations.
getMin() should return -1 if the stack is empty.
pop() should return nothing if the stack is empty.
top() should return -1 if the stack is empty.
 */
public class GetMinStack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            A.add(sc.nextInt());
        }
    }
    public Stack<Integer> st = new Stack<>();
    public Deque<ElemIndex> deuqe = new LinkedList<>();
    public void push(int x) {
        st.push(x);
        if(!deuqe.isEmpty()&& deuqe.peekLast().val> x){
            deuqe.add(new ElemIndex(x, st.indexOf(x)));
        }else if(deuqe.isEmpty()){
            deuqe.add(new ElemIndex(x,st.indexOf(x)));
        }
    }

    public void pop() {
        if(st.isEmpty())
            return;
        int index = st.indexOf(st.peek());
        ElemIndex elemPop = new ElemIndex(st.pop(), index);
        if(elemPop.val.equals(deuqe.getLast().val) && elemPop.index.equals(deuqe.getLast().index)){
            deuqe.removeLast();
        }
    }

    public int top() {
        if(st.isEmpty())
            return -1;
        return st.peek();
    }

    public int getMin() {
        if(deuqe.isEmpty())
            return -1;
        return deuqe.getLast().val;
    }

    public class ElemIndex{
        Integer val;
        Integer index;
        ElemIndex(int val, int index){
            this.val = val;
            this.index = index;
        }
    }
}
//
//8
// 1 3 -1 -3 5 3 6 7
// 3