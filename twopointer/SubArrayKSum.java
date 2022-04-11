package twopointer;
import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single element "-1".

First sub-array means the sub-array for which starting index in minimum.
*/
public class SubArrayKSum{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        
        SubArrayKSum pm = new SubArrayKSum();
        ArrayList<Integer> res = pm.solve(A, B);
        for (int index = 0; index < res.size(); index++) {
            System.out.print(res.get(index));
        }
        
        
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int i, j, n= A.size();
        long sum[] = new long[n+1];
        sum[0]=0;
        for(int k=0;k<n;k++){
            sum[k+1]= sum[k]+A.get(k);
            
        }
        i=0; j=1;
        long temp=0;
        while(i<=n && j<=n){
            temp= sum[j]-sum[i];
          
            if((int)temp== B){
                break;
            }
            else if((int)temp<B){
                j++;
            }
            else {
                i++;
            }
        }
         ArrayList<Integer> res = new ArrayList<Integer>();
        if(i==n+1 || j== n+1){
            res.add(-1);
            return res;
        }
       
        for(int k=i; k<j; k++){
            res.add(A.get(k));
        }
        return res;
    }
    
}