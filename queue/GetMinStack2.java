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
public class GetMinStack2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            A.add(sc.nextInt());
        }
    }
    public Stack<Integer> st = new Stack<>();
    public Stack<Integer> st1 = new Stack<>();  // stack will contain the index of min element instead of min element
    public void push(int x) {
        st.push(x);
        if(!st1.isEmpty()&& st1.peek()>= x){
            st1.push(x);
        }else if(st1.isEmpty()){
            st1.push(x);
        }
    }

    public void pop() {
        if(st.isEmpty())
            return;
        int elem = st.peek();
        st.pop();
        if(st1.peek().equals(elem)){
            st1.pop();
        }
    }

    public int top() {
        if(st.isEmpty())
            return -1;
        return st.peek();
    }

    public int getMin() {
        if(st1.isEmpty())
            return -1;
        return st1.peek();
    }
}
//
//8
// 1 3 -1 -3 5 3 6 7
// 3