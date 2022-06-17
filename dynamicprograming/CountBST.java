package dynamicprograming;

import java.util.Arrays;

public class CountBST {

    public int numTrees(int A) {
        long[][] dp = new long[A][A];
        for (int i = 0; i < A; i++)
            Arrays.fill(dp[i], -1);
        return (int) recursion(dp, 0, A - 1);
    }

    public long recursion(long[][] dp, int i, int j) {
        int n = dp.length;
        if (i < 0 || j < 0 || i >= n || j >= n)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i >= j)
            return dp[i][j] = 1;
        dp[i][j] = 0;
        for (int k = i; k <= j; k++) {
            dp[i][j] += (recursion(dp, i, k - 1) * recursion(dp, k + 1, j));
        }
        return dp[i][j];
    }
}
