import java.util.ArrayList;
import java.util.Scanner;
/*
Given an integer A, return the number of trailing zeroes in A! i.e. factorial of A.

Note: Your solution should run in logarithmic time complexity.
if A=6 then A! = 120.
 Number of trailing zeros = 1. So, return 1.
 */
public class FactorialZeros{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
       
        FactorialZeros pm = new FactorialZeros();
        int res = pm.trailingZeroes(size1);
        
            System.out.print(res+" ");
        
       
        
    }
    public int trailingZeroes(int A) {
        int ans=1, count=0,i=1;
        if(A<5){
            return 0;
        }
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(0);
        while(i*5<=A){
            
            System.out.print("i "+ i);
            count++;
            
            if(i%5==0){
                count += powerofFive(i);
                //System.out.println("\ni "+ i +" dp val "+ powerofFive(i));
            }
            else{
              
            }
            System.out.println(" count "+ count);
            //dp.add(count);
            i++;
        }
        
        return count;
        
    }
    public int powerofFive(int n){
        int ans=1; int i=0;
        while(n%5==0){
            n/=5;
            i++;
        }
           return i;
        
    }
}