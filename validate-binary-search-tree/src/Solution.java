/**
 * https://leetcode.com/problems/validate-binary-search-tree/
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

    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode p, Integer low, Integer high) {
        if (p == null) {
            return true;
        }
        return (low == null || p.val > low) && (high == null || p.val < high)
                && isValid(p.left, low, p.val)
                && isValid(p.right, p.val, high);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(10);

        Solution solution = new Solution();
        System.out.println(solution.isValidBST(root));
    }
}
