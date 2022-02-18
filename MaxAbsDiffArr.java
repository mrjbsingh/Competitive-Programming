import java.util.ArrayList;
import java.util.Scanner;

public class MaxAbsDiffArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int res;
        MaxAbsDiffArr pm = new MaxAbsDiffArr();
        res = pm.maxArr(A); 
        System.out.println(res);
    }
    public int maxArr(ArrayList<Integer> A) {
        int Xmax,Ymax,Xmin,Ymin;
        Xmax = Ymax= Integer.MIN_VALUE; //A[i]+i 
        Xmin = Ymin= Integer.MAX_VALUE; //A[i]-i
        int temp;
        for(int i=0; i<A.size(); i++){
            temp = A.get(i)+i;
            Xmax = temp>Xmax? temp:Xmax;
            Xmin = temp<Xmin? temp:Xmin;
            temp = A.get(i)-i;
            Ymax = temp>Ymax? temp:Ymax;
            Ymin = temp<Ymin? temp:Ymin;
        }

        return Integer.max(Xmax-Xmin, Ymax-Ymin);
    }

    
}