package leetcode.leetcode_contest;

import java.util.Arrays;
/*
https://leetcode.com/contest/weekly-contest-296/problems/partition-array-such-that-maximum-difference-is-k/
 */
public class PartitionArrDiffeK {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count=1,start=0;
        for(int i=1; i<nums.length;i++){
            if(nums[i]-nums[start]>k){
                count++;
                start=i;
            }
        }
        return count;
    }
}
