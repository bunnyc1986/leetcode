import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * https://leetcode.com/problems/3sum-smaller/
 */
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int counter = 0;
        if (nums.length < 3) {
            return counter;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    counter += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return counter;
    }

    @Test
    public void test1() {
        int output = threeSumSmaller(new int[]{-2, 0, 1, 3}, 2);
        assertEquals(2, output);
    }

    @Test
    public void test2() {
        int output = threeSumSmaller(new int[]{2, 0, 0, 2, -2}, 2);
        assertEquals(5, output);
    }

    @Test
    public void test3() {
        int output = threeSumSmaller(new int[]{0, -4, -1, 1, -1, 2}, -5);
        assertEquals(1, output);
    }
}
