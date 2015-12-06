import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * https://leetcode.com/problems/3sum/
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[++j]) ;
                    while (j < k && nums[k] == nums[--k]) ;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return results;
    }

    @Test
    public void test1() {
        List<List<Integer>> output = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, output.size());
        assertEquals("[-1, -1, 2]", output.get(0).toString());
        assertEquals("[-1, 0, 1]", output.get(1).toString());
    }

    @Test
    public void test2() {
        List<List<Integer>> output = threeSum(new int[]{0, 0, 0, 0, 0, 0, 0});
        assertEquals(1, output.size());
        assertEquals("[0, 0, 0]", output.get(0).toString());
    }

    @Test
    public void test3() {
        List<List<Integer>> output = threeSum(new int[]{7, -1, -1, -1, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7,
                9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4,
                2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4,
                -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2,
                6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6});
        assertEquals(119, output.size());
    }
}
