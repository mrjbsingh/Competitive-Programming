package dynamicprograming;

import java.util.Scanner;
/*
You are climbing a stair case and it takes A steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Stairs {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(climbStairs(num));

    }
    public static int climbStairs(int A) {
        int ways[] = new int[50];
        ways[1] = 1;
        ways[2] = 2;
        if(A<=2){
            return ways[A];
        }
        else{
            for(int i = 3; i <= A; i++){
                ways[i] = ways[i-1] + ways[i-2];
            }
            return ways[A];
        }
    }
}
