import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/wiggle-sort/
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            if ((i%2==0) != (nums[i] < nums[i-1])) {
                int t = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = t;
            }
        }
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
