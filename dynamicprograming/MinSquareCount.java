package dynamicprograming;

import java.util.Scanner;

/*
Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 */
public class MinSquareCount {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(countMinSquares(num));

    }
    public static int countMinSquares(int A) {
        int dp[] = new int[100005];
        dp[0] = 0;
        for (int i = 1; i <= A; i++) {
            dp[i] = i;
            for (int x = 1; x*x <= A ; x++) {
                if(i-x*x>=0){
                    dp[i] = Math.min(dp[i], dp[i-x*x]+1);
                }
            }
        }
        return dp[A];
    }
}
