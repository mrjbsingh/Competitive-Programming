import java.util.ArrayList;
import java.util.Scanner;

public class BeggarsRangeQuerry{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        
        int R = sc.nextInt();
        int C = sc.nextInt();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for (int q = 0; q < R; q++) {
            ArrayList<Integer> A = new ArrayList<>();
            for (int i = 0; i < C; i++) {
                A.add(sc.nextInt());
            }
            B.add(A);
        }
        
       
        BeggarsRangeQuerry pm = new BeggarsRangeQuerry();
        ArrayList<Integer> res = pm.solve(size1, B); 
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) +" ");
        }
    }
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> Bpot = new ArrayList<Integer>(A);
        int L,R,p, finalDonation;
        for(int i=0; i<A; i++){
            Bpot.add(0);
        }
        for(int q=0; q<B.size(); q++){
            ArrayList<Integer> querry = B.get(q); 
            L = querry.get(0)-1;
            R = querry.get(1)-1;
            p = querry.get(2);
            finalDonation= p+Bpot.get(L); // current donation amt and his previous amt
            Bpot.set(L,finalDonation);
            if(R+1<A) {
                finalDonation = Bpot.get(R+1)-p;  //deduction of donation amount from old balance
                Bpot.set(R+1,finalDonation); 
            }
        }
        //generate prefixSum
        int sum=0;
        for(int i=0; i<A; i++){
            sum+=Bpot.get(i);
            Bpot.set(i,sum);
        }
        return Bpot;
    }
}