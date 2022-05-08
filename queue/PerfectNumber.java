package queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 */
public class PerfectNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        PerfectNumber ts = new PerfectNumber();
        String res = ts.solve(A);
        System.out.println(res);
    }
    public String solve(int A) {
        String a="1", b="2";
        ArrayList<String> q = new ArrayList<>();
        q.add("1");
        q.add("2");
        if(A<=2){
            return makePalindrome(q.get(A-1));
        }
        int ptr=0, cnt=A;
        while(cnt>0){
            q.add(q.get(ptr)+a);
            q.add(q.get(ptr)+b);
            ptr++;
            cnt-=2;
        }
        
        return makePalindrome(q.get(A-1));
    }

    public static String makePalindrome(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb.toString() + sb.reverse().toString();
    }
}
