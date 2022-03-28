package binarysearch;
import java.util.ArrayList;
import java.util.Scanner;
/*
Given a sorted array of integers A where every element appears twice except 
for one element which appears once, find and return this single element that appears only once.

NOTE: Users are expected to solve this in O(log(N)) time.
*/
public class SingleElementSortedArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
    
        SingleElementSortedArr pm = new SingleElementSortedArr();
        int res = pm.solve(A); 
        
        System.out.println(res);
        
        
    }
    
    public int solve(ArrayList<Integer> A) {
        int l=0, r=A.size()-1,m, ans=-1;
        while(l<=r){
            //System.out.println("l "+l+" r "+r);
            m = l+(r-l)/2;
            
            if((m<=0|| A.get(m)!=(int)A.get(m-1)) && (m>= (A.size()-1) || A.get(m)!=(int)A.get(m+1))){
                ans= A.get(m);
                break;
            }
            if(( (m%2 ==0) && (A.get(m)==(int)A.get(m-1))) || ( (m%2==1) && A.get(m)==(int)A.get(m+1)) ){
                    r=m-1;
            }
            else if(((m%2==1) && A.get(m)==(int)A.get(m-1))|| ((m%2==0) && A.get(m)==(int)A.get(m+1))) {
                    l=m+1;
            }
        }
        return ans;
    }
    
}