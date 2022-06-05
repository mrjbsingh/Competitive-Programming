package leetcode.leetcode_contest;

import java.util.HashMap;
import java.util.Map;
/*
https://leetcode.com/contest/weekly-contest-296/problems/replace-elements-in-an-array/
 */
public class ReplaceNumbInArr {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hmap.put(nums[i], i);
        }
        for(int i=0; i<operations.length; i++){
            hmap.put(operations[i][1], hmap.get(operations[i][0]));
            hmap.remove(operations[i][0]);
        }
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet()){
            nums[entry.getValue()] = entry.getKey();
        }
        return nums;
    }
}
