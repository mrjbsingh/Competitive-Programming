import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of non-negative integers A where each element represents 
your maximum jump length at that position.
The initial position is the first index of the array and goal is to reach 
the last index of the array with the minimum number of jumps.

https://www.scaler.com/academy/mentee-dashboard/class/19121/homework/problems/3952/

 */
public class MinNumbJumpsFinal{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        MinNumbJumpsFinal pm = new MinNumbJumpsFinal();
        int res = pm.solve(A);
        
            System.out.print(res+" ");
        
        
    }
    public int solve(ArrayList<Integer> A) {
        
        int n= A.size();
        int maxV= Integer.MAX_VALUE-n;
        int dp[] = new int[n];
        dp[n-1]=0;
        if(A.get(0)==0)
        return -1;
        for(int i=n-2; i>=0;i--){
            if(A.get(i)==0)
                dp[i] = maxV;
            else if(A.get(i)+i>=n-1){
                dp[i]=1;
            }
            else{
                int maxjump= A.get(i), ans=maxV;
                for(int j=maxjump; j>0;j-- )
                {
                    ans=Math.min(dp[j+i],ans);
                }
                dp[i] = ans+1;
            }
        }
        return dp[0];
    }
}