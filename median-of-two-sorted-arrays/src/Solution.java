import org.junit.Test;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * refers from: https://leetcode.com/discuss/60472/25-lines-java-solution
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = (m + n) / 2;
        int lo = 0, hi = Math.min(k, m);

        int i, j;
        while (true) {
            i = lo + (hi - lo) / 2;
            j = k - i;
            if (get(nums1, i) >= get(nums2, j - 1)) {
                if (get(nums2, j) >= get(nums1, i - 1)) break;
                else hi = i - 1;
            } else lo = i + 1;
        }
        if ((m + n) % 2 == 1) return Math.min(get(nums1, i), get(nums2, j)); //odd
        return (double) (Math.min(get(nums1, i), get(nums2, j)) + Math.max(get(nums1, i - 1), get(nums2, j - 1))) / 2;//even
    }

    private int get(int[] nums, int i) {
        if (i < 0) return Integer.MIN_VALUE;
        if (i >= nums.length) return Integer.MAX_VALUE;
        return nums[i];
    }

    @Test
    public void test() {
        int[] num1 = new int[]{1, 3, 5, 7, 8, 10};
        int[] num2 = new int[]{2, 9, 11, 15, 20, 25, 27};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

}
