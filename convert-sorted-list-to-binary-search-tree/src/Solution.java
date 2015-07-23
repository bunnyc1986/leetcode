import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ListNode list;

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        for (ListNode p = head; p != null; p = p.next, length++) ;
        list = head;
        return sortedListToBST(0, length - 1);
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(list.val);
        root.left = left;
        list = list.next;
        root.right = sortedListToBST(mid + 1, end);
        return root;
    }

    @Test
    public void test() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(8);
        p = p.next;
        p.next = new ListNode(13);
        p = p.next;
        p.next = new ListNode(16);

        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBST(head);
        assertEquals(5, root.val);
        assertEquals(1, root.left.val);
        assertEquals(3, root.left.right.val);
        assertEquals(13, root.right.val);
    }
}
