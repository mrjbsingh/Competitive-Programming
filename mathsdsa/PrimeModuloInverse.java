package mathsdsa;
import java.util.Scanner;

public class PrimeModuloInverse{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        int res;
        PrimeModuloInverse pm = new PrimeModuloInverse();
        res = pm.solve(A,B);
      
        System.out.print(res);
        
    }
    public int solve(int A, int B) {
        //int pow= (B-2)%(B-1);
        return (int)fastPower((long)A, (long)(B-2), (long)B);
    }
    long fastPower(long a, long b, long m){
        System.out.println("a b "+ a+" "+b);
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
}