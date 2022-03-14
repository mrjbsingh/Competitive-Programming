package sorting;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Given two sorted integer arrays A and B, merge B and A as one sorted array 
and return it as an output.
*/
public class MergeTwoSortedArr{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int size2 = sc.nextInt();
        final List<Integer> B = new ArrayList<>();
        for (int i = 0; i < size2; i++) {
            B.add(sc.nextInt());
        }
    
        MergeTwoSortedArr pm = new MergeTwoSortedArr();
        ArrayList<Integer> res = pm.solve(A, B); 
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
        
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        int n = A.size() + B.size();
        int i=0, j=0, k=0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i<n){
            if(j<A.size() && k<B.size() && A.get(j)<=B.get(k)){
                res.add(A.get(j));
                j++;
                i++;
            }
            else if(j<A.size() && k<B.size() && A.get(j)>B.get(k)){
                res.add(B.get(k));
                k++;
                i++;
            }
            else if(j<A.size()){
                res.add(A.get(j));
                j++;
                i++;
            }
            else if(k<B.size()){
                res.add(B.get(k));
                k++;
                i++;
            }
        }
        return res;
    }
    
}