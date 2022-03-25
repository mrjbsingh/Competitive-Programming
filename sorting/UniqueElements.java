package sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
You are given an array A of N elements. 
You have to make all elements unique. 
To do so, in one step you can increase any number by one.

Find the minimum number of steps.
*/
public class UniqueElements{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
    
        UniqueElements pm = new UniqueElements();
        int res = pm.solve(A); 
        System.out.println(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans=0;
        for(int i=1; i<A.size(); i++){
            if(A.get(i)>A.get(i-1)){}
            else{
                ans+=(A.get(i-1)+1)-A.get(i);
                A.set(i,A.get(i-1)+1);
            }
        }
        return ans;
    }
    
}