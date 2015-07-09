/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i] > nums[i] ? sum + nums[i] : nums[i];
            max = max > sum ? max : sum;
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
