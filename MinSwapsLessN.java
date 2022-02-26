import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of integers A and an integer B, 
find and return the minimum number of swaps required to bring 
all the numbers less than or equal to B together.

Note: It is possible to swap any two elements, 
not necessarily consecutive.
*/
public class MinSwapsLessN{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        int res;
        MinSwapsLessN ba = new MinSwapsLessN();
        res = ba.solve(A, B);
        System.out.println("res "+res);
    }
   
    public int solve(ArrayList<Integer> A, int B) {
        int temp, swaps=Integer.MAX_VALUE;
        int count=0; 
        int arr[] = new int[A.size()];
        
        for(int i=0;i<A.size();i++){
            if(A.get(i)<=B){
                count++;
            }
            arr[i]= count;
           
        }
        for(int i=0;i+count<=A.size();i++){
            temp = count- ((i+count-1>=0?arr[i+count-1]:0)-(i-1>=0?arr[i-1]:0));
             swaps = Math.min(swaps, temp);
        }
    return swaps;
    }

}