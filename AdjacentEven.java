import java.util.ArrayList;
import java.util.Scanner;

public class AdjacentEven{
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
        int even=0, odd=0;
        for (int i = 0; i <A.size(); i++) {
            if(A.get(i)%2==0){
                even++;
            }
            else
            odd++;
        }
        return even>odd? odd:even;
    }
   

   
}