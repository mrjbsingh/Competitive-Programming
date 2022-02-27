import java.util.ArrayList;
import java.util.Scanner;
/*
Given an integer A, find and return the Ath magic number.

A magic number is defined as a number which can be expressed 
as a power of 5 or sum of unique powers of 5.

First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….
 */
public class NthMagicNum{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
       
        int res;
        NthMagicNum pm = new NthMagicNum();
        res = pm.solve(size1);
        
        System.out.print(res);
        
    }
    public int solve(int A) {
        int arr[]= new int[A+1];
        int i,j;
        arr[0]=5;
        arr[1]=5*5;
        for(i=1;i<A; ){
            for(j=0;j<i && i+j+1 <A;j++){
                arr[i+j+1] = arr[i]+arr[j];
            }
            if(i+j+1<A)
            {arr[i+j+1] = arr[i]*5;}
            i=i+j+1; 
        }
    return arr[A-1];
    }
    
}