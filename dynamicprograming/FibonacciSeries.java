package dynamicprograming;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long fib[] = new long[50];
        fib[0] = 0;
        fib[1] = 1;
        if(num<=1){
            System.out.println(fib[num]);
        }
        else{
            for(int i = 2; i <= num; i++){
                fib[i] = fib[i-1] + fib[i-2];
            }
            System.out.println(fib[num]);
        }

    }
}
