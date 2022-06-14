package dynamicprograming;

import java.util.Arrays;

/*
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class KnapSack2nd {
    public int solve(int[] A, int[] W, int C) {
        int n = A.length;
        int dp[] = new int[50 * n + 1];
        Arrays.fill(dp, 1000000000);

        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 50 * n; j >= A[i]; j--) {
                dp[j] = Math.min(dp[j], W[i] + dp[j - A[i]]);
            }
        }
        int ans = 0;
        for (int i = 50 * n; i >= 0; i--) {
            if (dp[i] <= C) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
