import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = sortedArrayToBST(array, start, mid - 1);
        root.right = sortedArrayToBST(array, mid + 1, end);
        return root;
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        TreeNode root = solution.sortedArrayToBST(new int[]{1, 3, 5, 8, 10, 12});
        assertEquals(5, root.val);
        assertEquals(1, root.left.val);
        assertEquals(3, root.left.right.val);
    }
}
