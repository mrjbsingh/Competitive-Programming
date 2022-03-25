package binarysearch;
import java.util.ArrayList;
import java.util.Scanner;
/*
Given a sorted array A of size N and a target value B, 
return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.
*/
public class BinarySearchFloor{
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
        BinarySearchFloor pm = new BinarySearchFloor();
        res = pm.searchInsert(A, B);
        
        System.out.print(res);
        
    }
    public int searchInsert(ArrayList<Integer> A, int B) {
        int l=0, r=A.size()-1;
        int m; int ans=0;
        while(l<=r){
            m= l+(r-l)/2;
            if(A.get(m)==B)
            return m;
            if(B<A.get(m)){
                r=m-1;
            }
            else{
                l=m+1;
                ans=m;
            }
        }
        if(A.get(ans)<B)
        ans++;
        return ans;
    }
    
}