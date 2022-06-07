package dynamicprograming;
/*
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i],
we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited
number of instances of an item.
 */
public class UnboundedKnapsack {
    public int solve(int capacity, int[] value, int[] weight) {
        int dp[] = new int[capacity+1];
        for (int i = 0; i <= capacity ; i++) {
            for (int j = 0; j < value.length; j++) {
                if(i>=  weight[j])
                    dp[i] = Math.max(dp[i], dp[i-weight[j]] + value[j]);

            }
        }
        return dp[capacity];
    }
}
