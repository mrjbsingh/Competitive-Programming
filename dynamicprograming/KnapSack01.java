package dynamicprograming;
/*
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapSack01 {
    public int solve(int[] A, int[] W, int C) {
        int n = A.length;
        int dp[][] = new int[n+1][C+1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=C; j++) {
                if(j<W[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i-1]]+ A[i-1]);
                }
            }
        }
        return dp[n][C];
    }
}
