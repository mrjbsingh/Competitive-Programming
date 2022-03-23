package mathsdsa;
import java.util.ArrayList;
import java.util.Scanner;
/*
Given a positive integer A. Return an array of minimum length 
whose elements represent the powers of 3 and the sum of all the elements 
is equal to A.
Input 1:

 13
Input 2:

 3


Example Output

Output 1:

 [1, 3, 9]
Output 2:

 [3]
 */
public class PowOf3{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
       
        PowOf3 pm = new PowOf3();
        ArrayList<Integer> res = pm.solve(size1);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i)+" ");
        }
       
        
    }
    public ArrayList<Integer> solve(int A) {
        int ans=1;
        ArrayList<Integer> res = new ArrayList<>();
        while(A>0){
            ans = pow3(A);
            res.add(ans);
            A = A-ans;
        }
    return res;
    }
    public int pow3(int A){
        int ans=1;
         while(ans<A){
            ans*=3;
        }
        if(ans==A) return ans;
        else 
        return ans/3;
    }
    
}