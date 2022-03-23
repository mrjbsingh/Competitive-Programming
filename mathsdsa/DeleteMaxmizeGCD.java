package mathsdsa;
import java.util.ArrayList;
import java.util.Scanner;

public class DeleteMaxmizeGCD{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        int res;
        DeleteMaxmizeGCD pm = new DeleteMaxmizeGCD();
        res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int gcdPrefiX[] = new int[n];
        int gcdSuffiX[] = new int[n];
        //gcdPrefiX[0] =gcdSuffiX[0]= 0;
        //gcdPrefiX[n+1] =gcdSuffiX[n+1]= 0;
        if(n==2){
            return Math.max(A.get(0), A.get(1));
        }
        for(int i=0; i<n; i++){
            gcdPrefiX[i]= gcd(A.get(i), i-1>=0?gcdPrefiX[i-1]:0);
            //System.out.print(" "+ gcdPrefiX[i]);
        }
        for(int i=n-1; i>=0; i--){
            gcdSuffiX[i]= gcd(A.get(i), i+1<n?gcdSuffiX[i+1]:0);
            //System.out.print(" "+ gcdSuffiX[i]);
        }
        int ans=Integer.MIN_VALUE;
        for(int i=1; i+1<n; i++){
            ans= Math.max(ans, gcd(gcdPrefiX[i-1], gcdSuffiX[i+1]));
        }
        return ans;
    }
    int gcd(int a, int b){
        if(a==0) return b;
        else{
            return gcd(b%a, a);
        }
    }

    
}