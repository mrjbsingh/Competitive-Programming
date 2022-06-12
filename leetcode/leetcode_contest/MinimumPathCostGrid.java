package leetcode.leetcode_contest;

public class MinimumPathCostGrid {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j]= Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++){
                    int start = grid[i][k];
                    int end = grid[i][j];
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + moveCost[start][k] + end);
            }
        }
    }
        int ans=0;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m-1][i]) ;
        }
        return ans;
}
}
