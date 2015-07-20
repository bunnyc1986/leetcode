/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class Solution {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        int end = lists.length - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists[begin] = mergeTwoLists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode merged = new ListNode(0);
        ListNode p = merged;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return merged.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(10);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(9);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(7);

        Solution solution = new Solution();
        ListNode output = solution.mergeKLists(new ListNode[]{l1, l2, l3});
        ListNode p = output;
        while (p != null) {
            System.out.print(p.val);
            System.out.print(',');
            p = p.next;
        }
        System.out.println();
    }
}
