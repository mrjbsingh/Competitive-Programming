import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSubArray{
    public static void main(String[] args) {
        //System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int res;
        MaxSubArray pm = new MaxSubArray();
        res = pm.maxSubArray(A);
        System.out.println(res);
    }
    public int maxSubArray(final List<Integer> A) {
        int ans = Integer.MIN_VALUE, sum =0;
        for(int i=0;i<A.size();i++){
            sum +=A.get(i); 
            ans = ans<sum? sum:ans;
            if(sum<0) sum=0;
        }
        return ans;
    }

    public void printArr(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    
}