package bitwise;

import java.util.ArrayList;
import java.util.Scanner;
/*
You have an array A with N elements. We have 2 types of operation available on this array :
We can split an element B into 2 elements C and D such that B = C + D.
We can merge 2 elements P and Q to one element R such that R = P^Q i.e XOR of P and Q.
You have to determine whether it is possible to convert array A to size 1, 
containing a single element equal to 0 after several splits and/or merge?
Input 1:

 A = [9, 17]
Input 2:

 A = [1]


Example Output
Output 1:

 Yes
Output 2:

 No

 */
public class IntrestingArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
        String res;
        IntrestingArr pm = new IntrestingArr();
        res = pm.solve(A);
        
        System.out.print(res);
        
    }
    public String solve(ArrayList<Integer> A) {
        int oddCount=0;
        for(int i=0; i<A.size(); i++){
            if(A.get(i)%2==1){
                oddCount++;
            }
        }
        if(oddCount%2==1)
            return "No";
        else
            return "Yes";
    }
    
}