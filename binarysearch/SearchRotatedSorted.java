package binarysearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, return its index otherwise, return -1.
*/
public class SearchRotatedSorted{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
    
        SearchRotatedSorted pm = new SearchRotatedSorted();
        int res = pm.search(A, B); 
        
        System.out.println(res);
        
        
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int l=0,r=A.size()-1, m;
        while(l<=r){
            m= l+(r-l)/2;
            if(A.get(m)==B){
                return m;
            }
            if(A.get(0)>=A.get(m)){
                if(A.get(0)<=B || A.get(m)>= B)
                    r=m-1;
                else
                    l=m+1;
            }
            else{
                if(A.get(0)>B || A.get(m)<B)
                    l=m+1;
                else
                    r=m-1;
            }
        }
        return -1;

    }
}