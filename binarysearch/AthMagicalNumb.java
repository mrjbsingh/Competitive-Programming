package binarysearch;
import java.util.Scanner;
/*
You are given three positive integers, A, B, and C.

Any positive integer is magical if divisible by either B or C.

Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.

I/P 
A = 4
B = 2
C = 3

O/P - 6
First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
*/
public class AthMagicalNumb{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
    
        AthMagicalNumb pm = new AthMagicalNumb();
        int res = pm.solve(A, B, C); 
        
        System.out.println(res);
        
        
    }
    public int solve(int A, int B, int C) {
        long l,r, m, lcm, cnt;
        l= Math.min(B,C);
        r = A*l;
        lcm = (B/gcd(B,C))*C;
        long mod = 1000000007;
        //System.out.println("l "+ l+" r "+r);
        while(l<=r){
            
            m = l+(r-l)/2;
            cnt = m/B + m/C - m/lcm;

            if(cnt==A &&(m%B ==0 || m%C ==0)){
                return (int) (m%mod);
            }
            if(cnt<A)
                l=m+1;
            else
                r=m-1;
           
        }
        return -1;   
    }
    int gcd(int a, int b){
        if(a==0) return b;
        else{
            return gcd(b%a, a);
        }
    }
}
/*
807414236
3788
38141

238134151
*/