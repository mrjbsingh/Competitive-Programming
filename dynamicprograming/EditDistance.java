package dynamicprograming;

import java.util.Arrays;

public class EditDistance {
    private int dp[][];
    public int minDistance(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        if (A == null && B == null)
            return 0;
        if (lenA == 0)
            return lenB;
        if (lenB == 0)
            return lenA;
        dp = new int[lenA+1][lenB+1];
        for (int i = 0; i < lenA; i++)
            Arrays.fill(dp[i], -1);

        return recursion(A, B,lenA - 1, lenB - 1);
    }

    public int recursion(String A, String B, int indexA, int indexB) {
        if (indexA < 0 && indexB < 0)
            return 0;
        if (indexA < 0)
            return indexB + 1;
        if (indexB < 0)
            return indexA + 1;
        if (dp[indexA][indexB] != -1)
            return dp[indexA][indexB];
        int res = Integer.MAX_VALUE;
        if (A.charAt(indexA) == B.charAt(indexB))
            res = recursion(A, B,indexA - 1, indexB - 1);
        int temp = 1 + recursion(A, B,indexA - 1, indexB - 1);
        temp = Math.min(temp, 1 + recursion(A, B,indexA - 1, indexB));
        temp = Math.min(temp, 1 + recursion(A, B, indexA, indexB - 1));
        res = Math.min(res, temp);
        return dp[indexA][indexB] = res;
    }
}
