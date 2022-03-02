import java.util.ArrayList;
import java.util.Scanner;
/*
Given an integer A, return the number of trailing zeroes in A! i.e. factorial of A.

Note: Your solution should run in logarithmic time complexity.
if A=6 then A! = 120.
 Number of trailing zeros = 1. So, return 1.
 */
public class CountDivisor{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        CountDivisor pm = new CountDivisor();
        ArrayList<Integer> res = pm.solve(A);
        for(int i=0; i<res.size(); i++){
            System.out.print(res.get(i)+" ");
        }
            
        
       
        
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<A.size(); i++){
            res.add(divisor(A.get(i)));
        }
        return res;
    }

    public int divisor(int num){
        int count=2; // as num is divided by 1 and num
        if(num<=1)
        return 1;
        for(int i=2; i*i<=num; i++){
            if(num%i==0){
                count+=2; // i and num/i both will be divisor 
            }
            if(i*i==num)
             count-=1;    // if num is 9 then i=3 and num/i=3 are same 
        }
        return count;
    }
}