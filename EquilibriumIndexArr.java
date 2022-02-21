import java.util.ArrayList;
import java.util.Scanner;

public class EquilibriumIndexArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        int res;
        EquilibriumIndexArr pm = new EquilibriumIndexArr();
        res = pm.solve(A);
        System.out.println(res);
    }
    public int solve(ArrayList<Integer> A) {
        int n= A.size();
        int leftsum[]= new int[A.size()];
        int rightsum[]= new int[A.size()];
        leftsum[0]=A.get(0);
         for(int i=1;i<A.size();i++){
             leftsum[i]= leftsum[i-1] + A.get(i);
         }
         rightsum[n-1]= A.get(n-1);
         for(int i=n-2;i>=0; i--){
            rightsum[i]= rightsum[i+1] + A.get(i);
         }
        for(int i=0;i<A.size();i++){
            if(leftsum[i]==rightsum[i]){
                return i;
            }
         }
        return -1;
    }
}