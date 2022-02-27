import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of integers A, calculate the sum of A [ i ] % A [ j ] 
for all possible i, j pairs. Return sum % (109 + 7) as an output.
 */
public class ModSumAij{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        int res;
        ModSumAij pm = new ModSumAij();
        res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        long sum=0;
        long m= 1000000007;
        long modRes[] = new long[10000];
        for(int i=0; i<10000; i++){
            modRes[i]=-1;
        }
        for(int i=0; i<A.size(); i++){
            if(modRes[A.get(i)]==-1){
                long temp=0;
                for(int j=0; j<A.size(); j++){
                    temp= (temp+A.get(j)%A.get(i))%m;
                }
                modRes[A.get(i)] = temp;
            }
            sum = (sum+modRes[A.get(i)])%m;
            
        }
    return (int) sum;    
    }
    
}