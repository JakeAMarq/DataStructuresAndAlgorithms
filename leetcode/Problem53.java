package leetcode;

public class Problem53 { 
    class Solution {
        public int maxSubArray(int[] nums) {        
            int max = Integer.MIN_VALUE, sum = 0, prevSum = 0;
            
            for (int i = 0; i < nums.length; i++) {
                sum = nums[i] + (prevSum > 0 ? prevSum : 0);
                max = Math.max(max, sum);
                prevSum = sum;
            }
            
            return max;
        }
    }
}