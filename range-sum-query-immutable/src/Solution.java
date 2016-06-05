import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class Solution {

    @Test
    public void test() {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);

        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }

    public class NumArray {
        private int[] accumulates;

        public NumArray(int[] nums) {
            this.accumulates = new int[nums.length + 1];

            accumulates[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                accumulates[i + 1] = accumulates[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return accumulates[j + 1] - accumulates[i];
        }
    }
}
