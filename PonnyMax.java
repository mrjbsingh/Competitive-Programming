import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PonnyMax{
    public static void main(String[] args) {
        System.out.println("hello");
        
    }
    public int solve(ArrayList<Integer> A, int B) {
        int op=0;
        boolean flag = false;
        for (int i = 1; i <A.size(); i++) {
            if(A.get(i)>B){
                op++;
            }
            if(A.get(i)==B){
                flag = true;
            }
        }
        if(flag){
            return op;
        }
        else
            return -1;
    }
    

    public void printArr(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}