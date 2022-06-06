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
        int right, down, enrgyLast = arr.get(m-1).get(n-1);
        //arr.get(0).set(0, Math.max(1, 1-arr.get(0).get(0)));
        for (int i = m-1; i >=0; i--) {
            for (int j = n-1; j >=0; j--) {
                if(i+1<m && j+1<n){
                    right= arr.get(i).get(j+1);
                    down = arr.get(i+1).get(j);
                    arr.get(i).set(j, Math.max(1,Math.min( right, down) - arr.get(i).get(j)));
                }else if(j+1<n){
                    right= arr.get(i).get(j+1);
                    arr.get(i).set(j, Math.max(1, right - arr.get(i).get(j)));
                }else if(i+1<m){
                    down = arr.get(i+1).get(j);
                    arr.get(i).set(j, Math.max(1, down - arr.get(i).get(j)));
                }else {
                    arr.get(i).set(i, Math.max(1, 1-arr.get(i).get(i)));
                }
            }
        }


        return arr.get(0).get(0);
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
