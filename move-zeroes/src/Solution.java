import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class Solution {

    public void moveZeroes(int[] nums) {
        int zeroAt = -1;
        for (int i = 0; i < nums.length; i++) {
            if (zeroAt == -1 && nums[i] == 0) {
                zeroAt = i;
            }
            if (nums[i] != 0 && zeroAt != -1) {
                nums[zeroAt] = nums[i];
                nums[i] = 0;
                zeroAt++;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }


}
