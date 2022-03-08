package bitwise;

import java.util.ArrayList;
import java.util.Scanner;
/*
We define f(X, Y) as number of different corresponding bits in binary representation of X and Y.
For example, f(2, 7) = 2, since binary representation of 2 and 7 are 010 and 111, respectively. The first and the third bit differ, so f(2, 7) = 2.

You are given an array of N positive integers, A1, A2 ,..., AN. Find sum of f(Ai, Aj) for all pairs (i, j) such that 1 ≤ i, j ≤ N. Return the answer modulo 109+7.
sc - class/19127/homework/problems/330 
*/
public class DiffBitSumPair{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        int res;
        DiffBitSumPair pm = new DiffBitSumPair();
        res = pm.cntBits(A);
        
        System.out.print(res);
        
    }
    public int cntBits(ArrayList<Integer> A) {
        long oneCOunt;
        long ans=0; long m=1000000007;
        int n=A.size();
        for(int i=0; i<32;i++){
             oneCOunt=0;
            
            for(int j=0; j<A.size();j++){
                if((A.get(j)&(1<<i))>0)
                {   
                    oneCOunt++;
                }
                
            }
            
            ans = (ans + ((2*((n-oneCOunt)*oneCOunt)%m)%m))%m;
        }
        return (int)ans;
    }
    
}