package dynamicprograming;
/*
Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).

Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
 */
public class FlipArrKnapSack {
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
    public int solve(final int[] A) {
        int n = A.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
           totalSum += A[i];
        }
        int capacity = totalSum/2;
        Pair dp[][] = new Pair[n+1][capacity+1];
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=capacity; j++) {
                dp[i][j] = new Pair(0,0);
            }
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=capacity; j++) {
                if(j<A[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    Pair temp = new Pair(0, 0);
                    temp.sum = dp[i-1][j-A[i-1]].sum+ A[i-1];
                    temp.flipCount = dp[i-1][j-A[i-1]].flipCount+1;
                    Pair maxVal = max(dp[i-1][j], temp);
                    dp[i][j] = new Pair(maxVal.sum, maxVal.flipCount);
                }
            }
        }
        return dp[n][capacity].flipCount;
    }
    public static class Pair{
        int sum;
        int flipCount;
        Pair(int sum, int flipCount){
            this.sum = sum;
            this.flipCount= flipCount;
        }
    }
    public Pair max( Pair p1, Pair p2){
        if(p1.sum > p2.sum)
            return p1;
        else if(p2.sum > p1.sum)
            return p2;
        else
            return p1.flipCount<= p2.flipCount? p1: p2;
    }
}
