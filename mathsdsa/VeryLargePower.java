package mathsdsa;
import java.util.Scanner;

/*
Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).

"^" means power ,

"%" means "mod", and

"!" means factorial.
 */
public class VeryLargePower{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int res;
        VeryLargePower pm = new VeryLargePower();
        res = pm.solve(A,B);
      
        System.out.print(res);
        
    }
    public int solve(int A, int B) {
        long m = 1000000007;
        long factorialB = factorial((long)B);

        return (int)fastPower((long)A, factorialB, m);
    }
    long fastPower(long a, long b, long m){
        //System.out.println("a b "+ a+" "+b);
        a=a%m;
        if(b==0)
        return 1;
        if(b%2==1){
            return ((a%m)*(fastPower((a*a)%m,(b-1)/2,m)%m))%m;
        }
        else{
            return fastPower((a*a)%m,b/2,m)%m;
        }
    }
    long factorial(long n)
    { 
        long m = 1000000007-1; //((a^(p-1))%p) = 1%p  fermat theorem concept
        // single line to find factorial
        return (n == 1 || n == 0) ? 1 : ((n%m) * (factorial(n - 1)%m))%m;
    }
}