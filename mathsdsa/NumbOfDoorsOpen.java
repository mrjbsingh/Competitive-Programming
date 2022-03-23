package mathsdsa;
import java.util.ArrayList;
import java.util.Scanner;
/*
Given an integer A which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.

A person moves to and fro changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.

In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
In the third go, he/she alters the states of doors numbered 3, 6, 9 …
This continues till the A'th go in which you alter the state of the door numbered A.

Find and return the number of open doors at the end of the procedure.
https://www.scaler.com/academy/mentee-dashboard/class/19125/assignment/problems/4106/
*/
public class NumbOfDoorsOpen{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
       
        int res;
        NumbOfDoorsOpen pm = new NumbOfDoorsOpen();
        res = pm.solve(size1);
        
        System.out.print(res);
        
    }
    public int solve(int A) {
        
    return sqrtofNum(A);
    }
    int sqrtofNum(int A){
        int i;
        for(i=1; i*i<=A; i++){
            
        }
        if(i*i==A)
            return i;
        else
            return i-1;
    }
}