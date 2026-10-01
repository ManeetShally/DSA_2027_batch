/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        while (lists.length > 1) {
            int n = lists.length;
            ListNode[] merged = new ListNode[(n + 1) / 2];

            for (int i = 0; i < n / 2; i++) {
                merged[i] = merge(lists[i], lists[n - 1 - i]);
            }

            if (n % 2 == 1) {
                merged[n / 2] = lists[n / 2];
            }

            lists = merged;
        }

        return lists[0];
    }

    ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }

            curr = curr.next;
        }

        curr.next = (a != null) ? a : b;

        return dummy.next;
    }
}