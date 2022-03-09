package bitwise;

import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of integers, every element appears thrice except for one, 
which occurs once.
A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Output: 4
*/
public class FindTwoSingleNumb{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        ArrayList<Integer> res;
        FindTwoSingleNumb pm = new FindTwoSingleNumb();
        res = pm.solve(A);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
       
        
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        
        int i,j; int xor=A.get(0);
        for(j=1; j<A.size(); j++){
            xor^=A.get(j);
        }
        //int lbs = xor&(~(xor-1));
        int lbs = xor^(xor&(xor-1));
        int x=0,y=0;

        for(j=0; j<A.size(); j++){
                
                if((A.get(j)&(lbs))>0){
                    x^=A.get(j);
                }
                else{
                    y^=A.get(j);
                }
            }
        ArrayList<Integer> res = new ArrayList<>();
        if(x<y)
        {res.add(x);
        res.add(y);
        }else{
            res.add(y);
            res.add(x);
        }
        return res;
    }
    
}