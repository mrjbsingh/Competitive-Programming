package leetcode.leetcode_contest;

import java.util.Arrays;
/*
https://leetcode.com/contest/weekly-contest-294/problems/maximum-bags-with-full-capacity-of-rocks/
 */
public class MaxBagWithFullCapacity {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int capacityLeft[] = new int[n];
        for(int i=0; i<n; i++){
            capacityLeft[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(capacityLeft);
        int count=0;
        int sumRequired=0;
        for(int i=0; i<n; i++){
            sumRequired =  sumRequired +capacityLeft[i];
            if(sumRequired <=additionalRocks){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}
