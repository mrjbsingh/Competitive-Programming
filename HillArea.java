import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HillArea{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        size1 = sc.nextInt();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            B.add(sc.nextInt());
        }
        String res;
        HillArea pm = new HillArea();
        res = pm.solve(A);
        // for (int i = 0; i < res.size(); i++) {
        //     System.out.print(res.get(i) +" ");
        // }
    }
    public String solve(ArrayList<Integer> A) {
        int sum=0;
        for (int i = 0; i <A.size(); i++) {
            sum+= A.get(i);
        }
        
        return String.valueOf(sum);
    }


    public void printArr(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}