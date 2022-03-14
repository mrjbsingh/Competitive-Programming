package sorting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
/*Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in less than equal to B swaps.
Problem Constraints
1 <= |A| <= 100000
1 <= B <= min(|A|, 500)
*/
public class KthSmallestNormal{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        final List<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        int B = sc.nextInt();
        int res;
        KthSmallestNormal pm = new KthSmallestNormal();
        res = pm.kthsmallest(A, B); 
        System.out.println(res);
    }
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int lastMin=-1, minIndex=-1;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        while(B>0){
            min = Integer.MAX_VALUE;
            for(int i=0; i<A.size(); i++){
                if(A.get(i)<=min && A.get(i)>=lastMin && !hmap.containsKey(i)){
                    min = A.get(i);
                    minIndex = i;
                }
            }
            lastMin = min;
            //System.out.print(" min "+ min+" minIndex "+minIndex);
            hmap.put(minIndex,min);
            B--;
        }
        return lastMin;
    }
    
}