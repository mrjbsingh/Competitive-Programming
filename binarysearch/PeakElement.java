package binarysearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Given an array of integers A, find and return the peak element in it. 
An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. 
We ensure that answer will be unique.
*/
public class PeakElement{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
    
        PeakElement pm = new PeakElement();
        int res = pm.solve(A); 
        
        System.out.println(res);
        
        
    }
    
    public int solve(ArrayList<Integer> A) {
        int l=0, r= A.size()-1, m;
         while(l<=r){
            m= l+(r-l)/2;
            if( (m-1<0 ||A.get(m)>=A.get(m-1)) && ( m+1>A.size()-1 || A.get(m)>=A.get(m+1)) ){
                return A.get(m);  
            }
            if(A.get(m)<A.get(m+1)){
                
                l= m+1;
            }
            else{
                r= m-1;
            }
               
        }
       return 0;
    }
    
}