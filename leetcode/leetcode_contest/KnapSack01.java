package leetcode.leetcode_contest;

import java.util.Arrays;

/*
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapSack01 {
    public int distributeCookies(int[] cookies, int k) {
        int sum=0;
        int children[] = new int[k];

        for (int i = 0; i < cookies.length; i++) {
            sum+=cookies[i];
        }
        int j=0;
        int ans=Integer.MAX_VALUE;
        while (j<k){
            int capacity = sum/(k-j);
            System.out.println("sum "+ sum);
            System.out.println("capacity" + capacity);
            Arrays.sort(cookies);
            int oneSetOfCookies = solve(cookies, capacity);
            System.out.println("oneSetOfCookies "+ oneSetOfCookies);
            children[j] = oneSetOfCookies;
            ans = Math.min(ans, oneSetOfCookies);
            sum=0;
            for (int i = 0; i < cookies.length; i++) {
                System.out.println("deleting ");
                if(cookies[i]<=oneSetOfCookies){
                    System.out.print(cookies[i]+" ");
                    oneSetOfCookies-= cookies[i];
                    cookies[i]=0;
                }
                sum+=cookies[i];
            }
            j++;
        }
        return ans;
    }
    public int solve(int[] W, int C) {
        int n = W.length;
        int dp[][] = new int[n+1][C+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=C; j++) {
                if(j<W[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i-1]]+ W[i-1]);
                }
            }
        }
        return dp[n][C];
    }
}
