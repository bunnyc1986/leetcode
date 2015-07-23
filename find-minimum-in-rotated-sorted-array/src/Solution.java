import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class Solution {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start >= end || nums[start] < nums[end]) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        if (nums[mid] > nums[end]) {
            return findMin(nums, mid + 1, end);
        } else {
            return findMin(nums, start, mid);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(0, solution.findMin(new int[]{3, 4, 5, 6, 0, 1, 2}));
        assertEquals(0, solution.findMin(new int[]{0, 1, 2, 3, 4, 5, 6}));
    }
}
