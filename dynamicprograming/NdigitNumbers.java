package dynamicprograming;

import java.util.ArrayList;
import java.util.Scanner;

/*
Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.

Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.

Since the answer can be large, output answer modulo 1000000007
 */
public class NdigitNumbers {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println((num));

    }
    public static int solve(int N, int Sum) {
        int count[][] = new int[N+1][Sum+1];
        int M= 1000000007;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= Sum; j++) {
                if(i==1){
                    count[i][j] = (j<=9)?1:0;
                }
                else{
                    for (int d = 0; d <=9 && d<j; d++) {
                        count[i][j] = (count[i][j] + count[i-1][j-d])%M;
                    }
                }
            }
        }
        return count[N][Sum];
    }
}
