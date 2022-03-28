package binarysearch;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Given a sorted array of integers A(0 based index) of size N, 
find the starting and the ending position of a given integer B in array A.
*/
public class SearchForRange{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
    
        SearchForRange pm = new SearchForRange();
        ArrayList<Integer> res = pm.searchRange(A, B); 
        
        System.out.println(res.get(0)+" "+ res.get(1));
        
        
    }
    public ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(findLeftMost(A,B));
        res.add(findRightMost(A,B));
        return res;
    }
    public int findLeftMost(final List<Integer> A, int B){
        int l=0, r=A.size()-1, m;
        int start=-1;
        while(l<=r){
            m= l+(r-l)/2;
            if(A.get(m)==B && (m<=0 || A.get(m-1)!=B)){
                start= m;
                break;
            }
            if(A.get(m)<B)
                l=m+1;
            else
                r=m-1;
        }
        return start;
    }
    public int findRightMost(final List<Integer> A, int B){
        int l=0, r=A.size()-1, m;
        int end=-1;
        while(l<=r){
            m= l+(r-l)/2;
            if(A.get(m)==B && (m>=A.size()-1 || A.get(m+1)!=B)){
                end= m;
                break;
            }
            if(A.get(m)<=B)
                l=m+1;
            else
                r=m-1;
        }
        return end;
    }
}