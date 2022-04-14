package hashmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Shaggy has an array A consisting of N elements. We call a pair of 
distinct indices in that array a special if elements at those indices 
in the array are equal.

Shaggy wants you to find a special pair such that the distance between 
that pair is minimum. Distance between two indices is defined as |i-j|. 
If there is no special pair in the array, then return -1.*/
public class MinDistanceSameElem{
    public static void main(String[] args) {
        System.out.println("hello");
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < size1; i++) {
            A.add(sc.nextInt());
        }
        
        MinDistanceSameElem pm = new MinDistanceSameElem();
        int res = pm.solve(A);
        
        System.out.print(res);
        
        
        
    }
    public int solve(ArrayList<Integer> A) {
        Map<Integer, ArrayList<Integer>> hmap = new HashMap<>();

        for(int i=0; i< A.size(); i++){
            if(hmap.containsKey(A.get(i))){
                hmap.get(A.get(i)).add(i);
            }else{
                ArrayList<Integer> list= new ArrayList<>();
                list.add(i);
                hmap.put(A.get(i), list);
            }
            
        }
        int min= Integer.MAX_VALUE;
        boolean flag = false;
        for(Map.Entry<Integer, ArrayList<Integer>> e: hmap.entrySet()){
            ArrayList<Integer> listIndex= e.getValue();
            if(listIndex.size()>1){
                flag=true;
                for(int i=1; i<listIndex.size(); i++){
                min = Math.min(min, listIndex.get(i)-listIndex.get(i-1) );
                }
            }
            
        }
        if(flag)
            return min;
        else
            return -1;
    }
}