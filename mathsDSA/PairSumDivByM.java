package mathsDSA;
import java.util.ArrayList;
import java.util.Scanner;

public class PairSumDivByM{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        int res;
        PairSumDivByM pm = new PairSumDivByM();
        res = pm.solve(A,B);
        System.out.println(res);
    }
    public int solve(ArrayList<Integer> A, int B) {
        long m = 1000000007;
        long count=0;
        long moduloArr[] = new long[B];
        for(int i=0;i<A.size();i++){
            moduloArr[A.get(i)%B]++;
        }
        count = ((moduloArr[0]*(moduloArr[0]-1))/2)%m;
        for(int i=1;i<B-i;i++){
            count = (count%m+(moduloArr[i]*moduloArr[B-i])%m)%m;
        }
        if(B%2==0){
            count = (count%m+((moduloArr[B/2]*(moduloArr[B/2]-1))/2)%m)%m;
        }
    return (int)count;    
    }
}