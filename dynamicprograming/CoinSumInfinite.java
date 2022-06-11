package dynamicprograming;

import java.util.Arrays;

/*
You are given a set of coins A. In how many ways can you make sum B assuming you have infinite amount of each coin in the set.

NOTE:
Coins in set A will be unique. Expected space complexity of this problem is O(B).
The answer can overflow. So, return the answer % (106 + 7).
 */
public class CoinSumInfinite {
    public int coinchange2(int[] coins, int sum) {
        int n = coins.length;
        int dp[] = new int[sum+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        int M = 1000007;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]])%M;

            }
        }
        return dp[sum];
    }
}
