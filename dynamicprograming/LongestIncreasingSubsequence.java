package dynamicprograming;

import java.util.Arrays;
/*
Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.
 */
public class LongestIncreasingSubsequence {
    public int lis(final int[] A) {
        int n = A.length;
        int LIS[] = new int[n];
        int ans = 1;
        Arrays.fill(LIS, 1);
        for(int i=1; i< n; i++){
            for(int j=0; j<i; j++){
                if(A[i] > A[j]){
                    LIS[i] = Math.max(LIS[i], LIS[j]+1);
                }
            }
            ans = Math.max(LIS[i], ans);
        }

        return ans;
    }
}
