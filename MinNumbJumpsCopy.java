import java.util.ArrayList;
import java.util.Scanner;
/*
Given an integer A, return the number of trailing zeroes in A! i.e. factorial of A.

Note: Your solution should run in logarithmic time complexity.
if A=6 then A! = 120.
 Number of trailing zeros = 1. So, return 1.
 */
public class MinNumbJumpsCopy{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        MinNumbJumpsCopy pm = new MinNumbJumpsCopy();
        int res = pm.solve(A);
        
            System.out.print(res+" ");
        
        
    }
    public int solve(ArrayList<Integer> A) {
        int n= A.size();
        int dp[] = new int[n]; 
        dp[n-1] =0;
        dp[0] = calcIfPossible(A, 0, n-1, 0, dp);
        return dp[0]; 
    }
    public int calcIfPossible(ArrayList<Integer> A, int start, int n, int count, int dp[]){
        int ans = Integer.MAX_VALUE-n, temp; 
        if(start>=n)
        {   //System.out.println("returning count");
            return count;
        }    
        if(dp[start]!=0)
        {   //System.out.println("returning count "+count +" for dp "+ start+ " val "+(dp[start]));
            return (count+dp[start]);
        }
            int jumps= A.get(start);
            if(jumps==0)
            {
                dp[start] = Integer.MAX_VALUE-n; //System.out.println("dp at "+start+" val "+ dp[start]);
                return dp[start];
            }  
            else{
                //System.out.println("jumping from "+start);
                for(int j =jumps; j>0; j--){
                    System.out.println(" to "+(start+j)); 
                    if(start+j>=n){
                        ans = count+1; //System.out.println("break pls");
                        break;
                    }
                    temp = calcIfPossible(A, start+j, n, count+1, dp);
                    //System.out.println("temp "+ temp);
                    ans = Math.min(ans, temp);
                    //System.out.println("ans "+ ans);
                }
                dp[start] = ans-count;
                //System.out.println("dp at "+start+" val "+ dp[start]);
                return ans;
            }       
    }
}