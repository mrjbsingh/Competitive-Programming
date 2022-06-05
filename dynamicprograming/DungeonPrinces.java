package dynamicprograming;

import java.util.ArrayList;
import java.util.Scanner;

/*
mentee-dashboard/class/26792/assignment/problems/17?navref=cl_tt_lst_sl
 */
public class DungeonPrinces {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println((num));

    }
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> arr) {
        int m = arr.size();
        int n = arr.get(0).size();
        int left, up, enrgyLast = arr.get(m-1).get(n-1);
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n; j++) {
                if(i-1>=0 && j-1>=0){
                    left= arr.get(i-1).get(j);
                    up = arr.get(i).get(j-1);
                    arr.get(i).set(j, arr.get(i).get(j) + Math.max( left, up));
                }else if(i-1>=0){
                    left= arr.get(i-1).get(j);
                    arr.get(i).set(j, arr.get(i).get(j) + left);
                }else if(j-1>=0){
                    up = arr.get(i).get(j-1);
                    arr.get(i).set(j, arr.get(i).get(j) + up);
                }
            }
        }
        System.out.println(arr.get(m-1).get(n-1));
        if(arr.get(m-1).get(n-1)>=0)
            return 1;
        else {
            if(enrgyLast>0){
                arr.get(m-1).set(n-1,arr.get(m-1).get(n-1)-enrgyLast);
            }
            return -1*arr.get(m-1).get(n-1)+1;
        }
    }
    public int minimumTotal(ArrayList<ArrayList<Integer>> arr) {
        int n = arr.size();
        for (int i = n-2; i >=0; i--) {
            for (int j = 0; j <=i; j++) {
                arr.get(i).set(j, arr.get(i).get(j) + Math.min(arr.get(i+1).get(j), arr.get(i+1).get(j+1)));
            }
        }
        return arr.get(0).get(0);
    }
}
