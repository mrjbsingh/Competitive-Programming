package mathsdsa;
import java.util.ArrayList;
import java.util.Scanner;
/*
There are N players each with strength A[i]. 
when player i attack player j, player j strength reduces to max(0, A[j]-A[i]). 
When a player's strength reaches zero, it loses the game 
and the game continues in the same manner among other players 
until only 1 survivor remains.

Can you tell the minimum health last surviving person can have?
 */
public class PubgGCD{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        int res;
        PubgGCD pm = new PubgGCD();
        res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        int n=A.size();
        int gcdPrefiX[] = new int[n];
        for(int i=0; i<n; i++){
            gcdPrefiX[i]= gcd(A.get(i), i-1>=0?gcdPrefiX[i-1]:0);
            //System.out.print(" "+ gcdPrefiX[i]);
        }
    return gcdPrefiX[n-1];    
    }
    int gcd(int a, int b){
        if(a==0) return b;
        else{
            return gcd(b%a, a);
        }
    }

    
}