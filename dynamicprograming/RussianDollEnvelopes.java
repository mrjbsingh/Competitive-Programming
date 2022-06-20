package dynamicprograming;

import java.util.Arrays;
import java.util.Comparator;
/*
Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.
 */
public class RussianDollEnvelopes {
    public int solve(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Sort2dArr(0));
        int dp[] = new int[n];
        Arrays.fill(dp, 1);  //dp based on LIS logic
        int ans=1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <i; j++) {
                if(envelopes[i][1]> envelopes[j][1] && envelopes[i][0]> envelopes[j][0]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
    public class Sort2dArr implements Comparator<int []>{
        int column;
        Sort2dArr(int column){
            this.column = column;
        }
        public int compare(final int entry1[], final int entry2[]){
            if(entry1[column] >= entry2[column]){
                return 1;
            }
            else
                return -1;
        }
    }

}
