package mathsdsa;
import java.util.Scanner;

/*
Given three integers A, B and C, where A represents n, B represents r and C represents p 
and p is a prime number greater than equal to n, find and return the value of 
nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.

NOTE: For this problem, we are considering 1 as a prime.

***This solution will work only if p is prime for all other case we need to do the DP=>O(n*r)***

 */
public class DpComputeNCR{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
        int res;
        DpComputeNCR pm = new DpComputeNCR();
        res = pm.solve(A,B,C);
      
        System.out.print(res);
        
    }
    public int solve(int N, int R, int M) {
        long dpNcr[][] = new long[N+1][R+1];
        int i,j;
        for(i=0;i<N;i++){
            dpNcr[i][0]=1;
        }
        for(i=0;i<=R;i++){
            dpNcr[i][i]=1;
        }
        for(i=2;i<=N;i++){
            for(j=1;j<=R && j<i;j++){
                dpNcr[i][j]= (dpNcr[i-1][j-1]+ dpNcr[i-1][j])%M;
            }
        }

        return (int) dpNcr[N][R];
    }
    
    
    
}

