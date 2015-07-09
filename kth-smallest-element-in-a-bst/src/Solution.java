/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
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


    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countChildren(root.left);
        if (k <= leftCount) {
            return kthSmallest(root.left, k);
        } else if (k > leftCount + 1) {
            return kthSmallest(root.right, k - 1 - leftCount);
        }
        return root.val;
    }

    private int countChildren(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countChildren(root.left) + countChildren(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode o11 = new TreeNode(4);
        TreeNode o12 = new TreeNode(9);
        root.left = o11;
        root.right = o12;
        TreeNode o21 = new TreeNode(2);
        TreeNode o22 = new TreeNode(5);
        o11.left = o21;
        o11.right = o22;
        TreeNode o23 = new TreeNode(8);
        TreeNode o24 = new TreeNode(10);
        o12.left = o23;
        o12.right = o24;
        TreeNode o31 = new TreeNode(1);
        TreeNode o32 = new TreeNode(3);
        o21.left = o31;
        o21.right = o32;


        System.out.println(new Solution().kthSmallest(root, 5));

    }
}