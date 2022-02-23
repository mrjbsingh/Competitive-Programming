import java.util.ArrayList;
import java.util.Scanner;

/*
Given a vector A of non-negative integers representing an elevation map 
where the width of each bar is 1, compute how much water it is able to 
trap after raining.
 */
public class RainWaterTrapped{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        int res;
        RainWaterTrapped ba = new RainWaterTrapped();
        res = ba.trap(A);
        System.out.println("res "+res);
    }
   
    public int trap(ArrayList<Integer> A) {
        int n=A.size();
        int leftMax[] = new int[n];
        leftMax[n-1] = A.get(n-1);
        for(int i=n-2; i>=0; i--){
            leftMax[i] = Math.max(A.get(i),leftMax[i+1]);
        }
        int rightMax= A.get(0);
        int commonEleveation, area=0;
        for(int i=0; i<n; i++){
            rightMax = Math.max(rightMax,A.get(i));
            commonEleveation= Math.min(rightMax,leftMax[i]);
            area+= (commonEleveation-A.get(i));  // area were water is traped over this building
        }
    return area;
    }

}