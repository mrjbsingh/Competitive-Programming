import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxMod{
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
        ArrayList<Integer> res;
        PonnyMobile pm = new PonnyMobile();
        res = pm.solve(A,B);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) +" ");
        }
    }
    public int solve(ArrayList<Integer> A) {
        int max =-1, secondMax=-1, temp;

        for (int i = 0; i <A.size(); i++) {
            temp = A.get(i);
            if(temp>max){
                secondMax =max;
                max =temp;
            }
            else if(temp>secondMax){
                secondMax =temp;
            }
        }
        //printArr(arr);
        //int arr[] = A.toArray();
        
        return secondMax;
    }

    
}