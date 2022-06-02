package dynamicprograming;

import java.util.ArrayList;
import java.util.Scanner;

/*
Given a 2 x N grid of integer, A, choose numbers such that the sum of the numbers is maximum
and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.

Note: You can choose more than 2 numbers.
 */
public class MaxSumWithoutAdjacent {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println((num));

    }
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int n = A.get(0).size();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Math.max(A.get(0).get(i), A.get(1).get(i));
        }
        if(n==1){
            return arr[0];
        }
        int ans[] = new int[n];
        ans[0] = Math.max(0, arr[0]);
        ans[1] = Math.max(ans[0], arr[1]);
        for (int i = 2; i < n; i++) {
           ans[i] = Math.max(arr[i]+ans[i-2], ans[i-1]);
        }
        return ans[n-1];
    }
}
