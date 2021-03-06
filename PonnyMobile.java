import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PonnyMobile{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        size1 = sc.nextInt();
        ArrayList<Integer> B = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            B.add(sc.nextInt());
        }
        ArrayList<Integer> res;
        PonnyMobile pm = new PonnyMobile();
        res = pm.solve(A,B);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) +" ");
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res = new ArrayList<>();
        int arr[] = new int[A.size()];
        arr[0] = A.get(0);
        for (int i = 1; i <A.size(); i++) {
            int val = A.get(i) + arr[i-1];
            arr[i]= val;
        }
        //printArr(arr);
        //int arr[] = A.toArray();
         for (int i = 0; i < B.size(); i++) {
            res.add(customBSearch(arr,0,A.size()-1,B.get(i)));
        }
        
        return res;
    }

    public void printArr(int a[]){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public int customBSearch(int a[], int l, int h, int elem){
        int mid, ans, size=h;
        ans = 0;
        //System.out.println("elem "+ elem);
        while(l<=h){
            mid = (h+l)/2;
            //System.out.println("l "+l+" h "+h+" mid "+mid);
            if(a[mid] == elem){
                ans = mid;
                break;
            }
            else if(a[mid]<elem){
                //customBSearch(a, mid+1,h, elem);
                l= mid+1;
                ans = mid;
            }
            else if(a[mid]>elem){
                ans = a[mid]>elem? mid-1:mid;
                h= mid-1;
            }
            else{

            }
        }
        if(h<0) ans = a[0]>elem? -1:0;
        else if(l>size) ans = size;
        return ans+1;
    }
}