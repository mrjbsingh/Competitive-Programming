package stacks;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
Given an array A, find the nearest smaller element G[i] for every element A[i] 
in the array such that the element has an index smaller than i.
Elements for which no smaller element exist, consider the next smaller element as -1.
Input 1:

 A = [4, 5, 2, 10, 8]

 Output 1:
 
 [-1, 4, -1, 2, 2]
*/
public class NearestSmallElem{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        
        NearestSmallElem pm = new NearestSmallElem();
        ArrayList<Integer> res = pm.prevSmaller(A);
        
        System.out.print(res);
        
    }
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i< A.size(); i++){

            while(!st.empty() && (Integer)st.peek()>=A.get(i)){
                st.pop();
            }
            if(st.empty()){
                res.add(-1);
            }
            else{
                res.add((Integer)st.peek());
            }
            st.push(A.get(i));
        }
        return res;
    }
}