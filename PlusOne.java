import java.util.ArrayList;
import java.util.Scanner;

public class PlusOne{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        
        int size1 = sc.nextInt();

        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        ArrayList<Integer> res;
        PlusOne pm = new PlusOne();
        res = pm.plusOne(A);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) +" ");
        }
    }
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean flag = false;
        int realSize = 0;
        res.add(0); //bydefault with extrasize
        for(int i=0; i<A.size(); i++){
            if(flag || A.get(i)>0){
                res.add(0);
                flag = true;
                realSize++;
            }
        }
        int carry=1;
        for(int i=A.size()-1, j=realSize; i>=A.size()-realSize; i--,j--){
            carry += A.get(i);
            res.set(j, carry%10);
            carry= carry/10;
        }
        if(carry==1){
            res.set(0,1);
        }
        else{
            res.remove(0);
        }
        return res;
    }

    
}