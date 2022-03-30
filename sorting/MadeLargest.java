package sorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/*Given an array A of non-negative integers, 
arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.
 A = [3, 30, 34, 5, 9]
 9534330
*/
public class MadeLargest{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
       
       
        MadeLargest pm = new MadeLargest();
        String res = pm.largestNumber(A); 
        System.out.println(res);
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        int n = A.size();
        
        ArrayList<String> str= new ArrayList<>();
        for(int i=0; i<n;i++){
            str.add(String.valueOf(A.get(i)));
        }
        Collections.sort(str, new StrComparator());
        String res = new String();
        for(int i=0; i<n;i++){
            res+=str.get(i);
        } 
        int i=0;
        while(i<res.length() && res.charAt(i) =='0'){
            i++;
        } 

    return i>1? res.substring(i-1): res;
}
class StrComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            String s12 = s1+s2;
            String s21 = s2+s1;
            return s21.compareTo(s12);
        }
    }
    
}