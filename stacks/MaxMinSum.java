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
            ArrayList<Integer> smallLeft = getNearestSmallElemLeft(A);
            ArrayList<Integer> smallRight = getNearestSmallElemRight(A);
            ArrayList<Integer> greaterLeft = getNearestGreaterElemLeft(A);
            ArrayList<Integer> greaterRight = getNearestGreaterElemRight(A);
    
            long sum = 0;
            long M = 1000000007;
            for(int i=0; i<A.size(); i++){
                long subArrElemMin = ((smallRight.get(i)-i)*(i-smallLeft.get(i)))%M;
                long subArrElemMax = ((greaterRight.get(i)-i)*(i-greaterLeft.get(i)))%M;
                //System.out.print("")
                sum = (sum + (A.get(i)*((subArrElemMax - subArrElemMin + M)%M))%M)%M;
            }
            return (int)sum;
        }
    
        public ArrayList<Integer> getNearestSmallElemLeft(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();
    
            for(int i=0; i< A.size(); i++){
    
                while(!st.empty() && A.get((Integer)st.peek())>=A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                    res.add(-1);
                }
                else{
                    res.add((Integer)st.peek());
                }
                st.push(i); 
            }
            return res;
        }
    
        public ArrayList<Integer> getNearestSmallElemRight(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();
            for(int i=A.size()-1; i>=0; i--){
                res.add(-1);
            }
            for(int i=A.size()-1; i>=0; i--){
    
                while(!st.empty() && A.get((Integer)st.peek())>=A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                    res.set(i, A.size());
                }
                else{
                    res.set(i, (Integer)st.peek());
                }
                st.push(i);
            }
            return res;
        }
    
        public ArrayList<Integer> getNearestGreaterElemLeft(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();
    
            for(int i=0; i< A.size(); i++){
    
                while(!st.empty() && A.get((Integer)st.peek())<=A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                    res.add(-1);
                }
                else{
                    res.add((Integer)st.peek());
                }
                st.push(i); 
            }
            return res;
        }
    
        public ArrayList<Integer> getNearestGreaterElemRight(ArrayList<Integer> A){
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();
            for(int i=A.size()-1; i>=0; i--){
                res.add(-1);
            }
            for(int i=A.size()-1; i>=0; i--){
    
                while(!st.empty() && A.get((Integer)st.peek())<=A.get(i)){
                    st.pop();
                }
                if(st.empty()){
                    res.set(i, A.size());
                }
                else{
                    res.set(i, (Integer)st.peek());
                }
                st.push(i);
            }
            return res;
        }
    //528969747
}