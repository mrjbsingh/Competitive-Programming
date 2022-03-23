package mathsDSA;
import java.util.Scanner;

/*
Given three integers A, B and C, where A represents n, B represents r and C represents p 
and p is a prime number greater than equal to n, find and return the value of 
nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.

***This solution will work only if p is prime for all other case we need to do the DP=>O(n*r)***

 */
public class ComputeNCR{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int res;
        ComputeNCR pm = new ComputeNCR();
        res = pm.solve(A,B,C);
      
        System.out.print(res);
        
    }
    public int solve(int A, int B, int C) {
        long nfact, inverseNR,nMinusR, rfact, inverseR,res;
        /* n!/(n-r)!*r! will be written as n*(n-1)*(n-2)*....*(n-r+1)/r! if (n-r>r)
            it will reduce computation as common factorial i.e (n-r)! are ignored 
         */
        if(A-B>B){
            nfact=modifiedfactorial((long)A, (long)C, (long)A-B);
            rfact = factorial((long)B, (long)C);
            inverseR = fastPower(rfact, (long)(C-2), (long)C);
            res = (((nfact%C)*(inverseR%C))%C);
            //System.out.print(nfact+" a-b");
        }else{
            nfact=modifiedfactorial((long)A, (long)C, (long)B);
            nMinusR= factorial((long)A-B, (long)C);
            inverseNR= fastPower(nMinusR, (long)(C-2), (long)C);
            res = (((nfact%C)*(inverseNR%C))%C);
            //System.out.print("b");
        }
        
        return (int)res;
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
    long factorial(long n, long m)
    { 
        //((a^(p-1))%p) = 1%p  fermat theorem concept
        // single line to find factorial
        return (n == 1 || n == 0) ? 1 : ((n%m) * (factorial(n - 1,m)%m))%m;
    }
    /*  n!/r! where r<=n
        n*(n-1)*(n-2)*....*(n-r+1)
        it will reduce computation as common divisible factorial are removed
    */
     long modifiedfactorial(long n, long m,long nMinusR)
    { 
        if(n<=nMinusR)
            return 1;
        else
            return (n == 1 || n == 0) ? 1 : ((n%m) * (modifiedfactorial(n - 1,m,nMinusR)%m))%m;
    }
    
}

