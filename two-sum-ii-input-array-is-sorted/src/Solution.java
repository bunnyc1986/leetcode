/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class Solution {
    public int[] twoSum(int[] sortedNums, int target) {
        int i = 0, j = sortedNums.length - 1;
        while (i < j) {
            int sum = sortedNums[i] + sortedNums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i + 1, j + 1};
            }

        }
        return null;
    }

    public static void main(String[] args) {
        Solution twoSum = new Solution();
        int[] nums = new int[]{1, 3, 5, 7, 8, 9, 10, 12, 14, 18};
        int target = 20;

        int[] results = twoSum.twoSum(nums, target);
        System.out.println(String.format("%d, %d", results[0], results[1]));
    }
}
