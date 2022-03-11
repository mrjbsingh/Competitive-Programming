package bitwise;

import java.util.ArrayList;
import java.util.Scanner;
/*
Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

A = 5
Example Output
10

Example Explanation
The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
*/
public class StrangeEquality{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
       
        
        StrangeEquality pm = new StrangeEquality();
        int res = pm.solve(A);
       
            System.out.print(res);
        
       
        
    }
    public int solve(int A) {
        int ans=0;
        int temp =A;
        for(int i=0; i<32; i++){
            if((A&(1<<i))<=0){
                ans = ans+ (1<<i);
            }
            temp= temp/2;
            if(temp<1)
            {
                ans = ans +(1<<i+1);
                break;
            }
        }
    return ans;
    }
    
}