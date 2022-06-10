package dynamicprograming;
/*
Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.

Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
 */
public class RodCutting {
    public int solve(int[] A) {
        int capacity = A.length;
        int dp[] = new int[capacity+1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j]+A[j-1]);
            }
        }
        return dp[capacity];
    }
}
