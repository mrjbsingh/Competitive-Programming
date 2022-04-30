package stacks;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/*
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.
Input 1:

 A = [2, 1, 5, 6, 2, 3]

Example Output
Output 1:
 10
*/
public class LargestAreaHistogram{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        
        LargestAreaHistogram pm = new LargestAreaHistogram();
        int res = pm.largestRectangleArea(A);
        
        System.out.print(res);
        
    }
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> smallLeft = getNearestSmallElemLeft(A);
        ArrayList<Integer> smallRight = getNearestSmallElemRight(A);
        
        int maxArea = A.get(0)*(smallRight.get(0)- smallLeft.get(0) -1);
        int area;

       
        for(int i=1; i<A.size(); i++){
            area = A.get(i)*(smallRight.get(i)- smallLeft.get(i) -1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
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
}