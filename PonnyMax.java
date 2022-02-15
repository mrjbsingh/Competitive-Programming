import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PonnyMax{
    public static void main(String[] args) {
        System.out.println("hello");
        
    }
    public int solve(ArrayList<Integer> A, int B) {
        int op=0;
        boolean flag = false;
        for (int i = 1; i <A.size(); i++) {
            if(A.get(i)>B){
                op++;
            }
            if(A.get(i)==B){
                flag = true;
            }
        }
        if(flag){
            return op;
        }
        else
            return -1;
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