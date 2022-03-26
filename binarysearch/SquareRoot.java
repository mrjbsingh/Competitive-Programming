package binarysearch;
import java.util.Scanner;
/*
Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

*/
public class SquareRoot{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
    
        SquareRoot pm = new SquareRoot();
        int res = pm.sqrt(A); 
        
        System.out.println(res);
        
        
    }
    public int sqrt(int A) {
        long l=0, r=A, m;
        int ans=0;
        if(A<=1)
            return A;
        while(l<=r){
            m= l+(r-l)/2;
            if(m*m==A){
                return (int) m;
            }
            if(m*m< A && (m+1)*(m+1)>A){
                ans= (int) m;
                break;
            }
              
            if(m*m>=A)
                r=m-1;
            else
                l=m+1;
        }
        return ans;
    }
}