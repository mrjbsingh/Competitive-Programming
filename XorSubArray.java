import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class XorSubArray{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        int res;
        XorSubArray ba = new XorSubArray();
        res = ba.solve(A);
        System.out.println("res "+res);
    }
   
    public int solve(ArrayList<Integer> A) {
        if(A.size()%2==0) return 0;
        else{
            int xor=0;
            for (int i = 0; i < A.size(); i++) {
                
                if(i%2==0){
                    xor^=A.get(i);
                }
            }
            return xor;
        }
    }

}