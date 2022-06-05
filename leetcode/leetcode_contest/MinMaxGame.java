package leetcode.leetcode_contest;
/*
https://leetcode.com/contest/weekly-contest-296/problems/min-max-game/
 */
public class MinMaxGame {
    public int minMaxGame(int[] nums) {

        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.min(nums[0], nums[1]);
        }
        int len = nums.length/2;
        while(len>=1){
            int arr[] = new int[len];
            for(int i=0; i<len; i++){
                if(i%2==0)
                    arr[i] = Math.min(nums[2*i], nums[2*i+1]);
                else
                    arr[i] = Math.max(nums[2*i], nums[2*i+1]);
            }
            for(int i=0; i<len; i++){
                nums[i] = arr[i];
            }
            len = len/2;
        }

        return nums[0];
    }
}
