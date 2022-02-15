import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BalanceArray{
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
    public int solve(ArrayList<Integer> A) {
        int size= A.size();
        int sum[] = new int[size+1];
        sum[0]=0; sum[1]=A.get(0);
        for (int i = 1; i < size; i++) {
            sum[i+1] = A.get(i)+sum[i-1];
        }
        //printArr(sum);
        int special=0, sumN=0, sumN1=0;
        for (int i = 1; i <=size; i++) {
            if((size+i)%2==0){
                sumN = sum[size]-sum[i]+sum[i-1];
                sumN1 = sum[size-1]-sum[i-1]+(i-2>=0?sum[i-2]:0);
            }
            if((size+i)%2==1){
                sumN1 = sum[size-1]-sum[i]+sum[i-1];
                sumN = sum[size]-sum[i-1]+(i-2>=0?sum[i-2]:0);
            }
            if(sumN==sumN1){
                special++;
            }
        }
        return special;
    }
    
    public void printArr(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
}