package dynamicprograming;

import java.util.ArrayList;
import java.util.Scanner;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is
Input 1:


A = [
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
    Output 1: 11
 */
public class MinSumPathTriangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println((num));

    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();
        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j <=i; j++) {
                arr.get(i).set(j, arr.get(i).get(j) + Math.min(arr.get(i+1).get(j), arr.get(i+1).get(j+1)));
            }
        }
        return arr.get(0).get(0);
    }
}
