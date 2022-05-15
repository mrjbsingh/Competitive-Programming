package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/
 */
public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hmap = new HashMap<>();
            for(int i=0; i<nums.length; i++){
                hmap.put(nums[i], i);
                //System.out.println(nums[i], i);
            }
            int res[] = new int[2];
            for(int i=0; i<nums.length; i++){

                if (hmap.containsKey(target-nums[i]) && hmap.get(target-nums[i])!=i){
                    res[0] = i;
                    res[1] = hmap.get(target-nums[i]);
                    break;
                }
            }
            return res;
        }
}
