package stacks;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
Given an array of integers A.

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
Input 1:

 A = [4, 7, 3, 8]

Example Output
Output 1:
 26
*/
public class MaxMinSum{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        
        MaxMinSum pm = new MaxMinSum();
        int res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
            ArrayList<Long> smallLeft = getNearestSmallElemLeft(A);
            ArrayList<Long> smallRight = getNearestSmallElemRight(A);
            ArrayList<Long> greaterLeft = getNearestGreaterElemLeft(A);
            ArrayList<Long> greaterRight = getNearestGreaterElemRight(A);
    
            long sum = 0;
            long M = 1000000007;
            for(int i=0; i<A.size(); i++){
                long subArrElemMin = ((smallRight.get(i)-(long)i)*((long)i-smallLeft.get(i)))%M;
                long subArrElemMax = ((greaterRight.get(i)-(long)i)*((long)i-greaterLeft.get(i)))%M;
                long tempSum = ((long)A.get(i)*((subArrElemMax - subArrElemMin + M)%M))%M;
                sum = (sum + (tempSum+ M)%M)%M;
            }
            return (int)sum;
        }
    
        public ArrayList<Long> getNearestSmallElemLeft(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Long> res = new ArrayList<>();
    
            for(int i=0; i< A.size(); i++){
    
                while(!st.empty() && A.get((int)st.peek())>A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                    res.add((long)-1);
                }
                else{
                    res.add((long)st.peek());
                }
                st.push(i); 
            }
            return res;
        }
    
        public ArrayList<Long> getNearestSmallElemRight(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Long> res = new ArrayList<>();
            for(int i=A.size()-1; i>=0; i--){
                res.add((long)-1);
            }
            for(int i=A.size()-1; i>=0; i--){
    
                while(!st.empty() && A.get((Integer)st.peek())>=A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                    res.set(i, (long)A.size());
                }
                else{
                    res.set(i, (long)st.peek());
                }
                st.push(i);
            }
            return res;
        }
    
        public ArrayList<Long> getNearestGreaterElemLeft(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Long> res = new ArrayList<>();
    
            for(int i=0; i< A.size(); i++){
    
                while(!st.empty() && A.get((Integer)st.peek())<A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                   res.add((long)-1);
                }
                else{
                    res.add((long)st.peek());
                }
                st.push(i); 
            }
            return res;
        }
    
        public ArrayList<Long> getNearestGreaterElemRight(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Long> res = new ArrayList<>();
            for(int i=A.size()-1; i>=0; i--){
                res.add((long)-1);
            }
            for(int i=A.size()-1; i>=0; i--){
    
                while(!st.empty() && A.get((Integer)st.peek())<=A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                    res.set(i, (long)A.size());
                }
                else{
                    res.set(i, (long)st.peek());
                }
                st.push(i);
            }
            return res;
        }
        
}