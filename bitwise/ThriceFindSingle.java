package bitwise;

import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of integers, every element appears thrice except for one, 
which occurs once.
A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output: 4
*/
public class ThriceFindSingle{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        int res;
        ThriceFindSingle pm = new ThriceFindSingle();
        res = pm.singleNumber(A);
        
        System.out.print(res);
        
    }
    public int singleNumber(ArrayList<Integer> A) {
        int ones; int ans=0;
        int i,j;
        for(i=0; i<32; i++){
            ones=0;
            for(j=0; j<A.size(); j++){
                
                if((A.get(j)&(1<<i))>0){
                    ones++;
                }
            }
           //System.out.print(" ones & i "+ ones+ " "+ i);
            ans= ans + ((ones%3)<<i);
        }
        return ans;
    }
    
}