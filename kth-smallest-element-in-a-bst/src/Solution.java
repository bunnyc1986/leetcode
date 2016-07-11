import java.util.Stack;

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
        int count = 0;
        final Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            while(p != null)  {stack.push(p); p = p.left;}
            p = stack.pop();
            if (++count == k) return p.val;
            p = p.right;
        }
        return -1;
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