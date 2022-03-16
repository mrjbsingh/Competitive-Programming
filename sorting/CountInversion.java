package sorting;
import java.util.ArrayList;
import java.util.Scanner;
/*
Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. 
Find the total number of inversions of A modulo (109 + 7).
*/
public class CountInversion{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList <Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
    
        CountInversion pm = new CountInversion();
        int res = pm.solve(A); 
        System.out.println(res);
        
    }
    public int solve(ArrayList<Integer> A) {
        long sum = mergeSort(A, 0, A.size()-1);
       
        return (int)sum;
    }
    public long mergeSort(ArrayList<Integer> A, int s, int e){
        
        long sum=0, M = 1000000007;
        if(s<e){
            int mid = s+(e-s)/2; 
            
            sum = (sum +mergeSort(A, s, mid))%M;
            sum = (sum +mergeSort(A, mid+1, e))%M;

            sum = (sum +merge(A, s, mid, e))%M;
        }
        return sum;
    }
    public long merge(ArrayList<Integer> A, int s, int mid, int e){
       
        int i=0, j=0, k=0;
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> left = new ArrayList<>();
       
        int n1= mid-s+1;
        int n2= e-mid;
        for(i=0; i<n1; i++){
            right.add(A.get(s+i));
        }
       
        for(i=0; i<n2; i++){
            left.add(A.get(mid+1+i));
        }
        
        i=s;j=0; k=0; 
        long sum =0,M = 1000000007;
        while(i<=e){
            
            if(j<right.size() && k<left.size() && right.get(j)<=left.get(k)){
                A.set(i, right.get(j));  
                j++;
                i++;
            }
            else if(j<right.size() && k<left.size() && right.get(j)>left.get(k)){
                A.set(i, left.get(k));
                sum = (sum + (right.size()-j)%M)%M;
                k++;
                i++;
            }
            else if(j<right.size()){
                A.set(i, right.get(j));  
                j++;
                i++;
            }
            else if(k<left.size()){
                A.set(i, left.get(k));  
                k++;
                i++;
            }
           
        }
       
        return sum;
    }
    
}