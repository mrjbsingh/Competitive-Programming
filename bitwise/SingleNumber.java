package bitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 */
public class SingleNumber{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        final List<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        int res;
        SingleNumber pm = new SingleNumber();
        res = pm.singleNumber(A);
        
        System.out.print(res);
        
    }
    public int singleNumber(final List<Integer> A) {
        int res=A.get(0);
        for(int i=1; i<A.size(); i++){
            res= res^A.get(i);
        }
        return res;
    }
    
}