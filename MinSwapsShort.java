import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MinSwapsShort{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        int res;
        MinSwapsShort ba = new MinSwapsShort();
        res = ba.solve(A);
        System.out.println("res "+res);
    }
   
    public int solve(ArrayList<Integer> A) {
        int temp, swaps=0;
        for(int i=0;i<A.size();i++){
            while(i!=A.get(i)){
                temp = A.get(A.get(i));
                A.set(A.get(i),A.get(i));
                A.set(i,temp);
                swaps++;
            }
        }
        return swaps;
    }

}