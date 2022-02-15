import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IsRectangle{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        int res;
        BalanceArray ba = new BalanceArray();
        res = ba.solve(A);
        System.out.println("res "+res);
    }
    public int solve(int A, int B, int C, int D) {
        if(A==B && C==D){
            return 1;
        }
        else if(A==C && B==D){
            return 1;
        }
        else if(A==D && B==C){
            return 1;
        }
        return 0;
    }
   
    
}