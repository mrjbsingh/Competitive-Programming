import java.util.ArrayList;
import java.util.Scanner;

public class SpcSubseqAG{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        int res;
        SpcSubseqAG pm = new SpcSubseqAG();
        res = pm.solve(str);
        System.out.println(res);
    }
    public int solve(String A) {
        int sum=0, M=1000000007, n=A.length();
        int suffixSumG[] = new int[n];
        suffixSumG[n-1] = A.charAt(n-1)=='G'?1:0;
        for(int j=n-2; j>=0;j--){
            if(A.charAt(j)=='G'){
                suffixSumG[j]= 1+suffixSumG[j+1];
            }
            else{
                suffixSumG[j]= suffixSumG[j+1];
            }     
        }
        for(int i=0; i<n;i++){
            if(A.charAt(i)=='A'){
               sum = (sum +suffixSumG[i])%M;
            }
        }
    return sum;
    }
}