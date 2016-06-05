import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/remove-element/
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int insertAt = -1;
        for (int i = 0; i < nums.length; i++) {
            if (insertAt == -1 && nums[i] == val) {
                insertAt = i;
            }
            if (insertAt != -1 && nums[i] != val) {
                nums[insertAt] = nums[i];
                insertAt++;
            }
        }
        return insertAt == -1 ? nums.length : insertAt;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 2, 3};
        int length = removeElement(nums, 3);
        assertEquals(2, length);
    }

    @Test
    public void test1() {
        int[] nums = new int[]{2};
        int length = removeElement(nums, 3);
        assertEquals(1, length);
    }
}
