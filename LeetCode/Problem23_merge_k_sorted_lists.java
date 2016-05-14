/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        } else if (end - start == 1) {
            return merge(arr[start], arr[end]);
        } else {
            return merge(merge(arr, start, (start + end) / 2), merge(arr, ((start + end) / 2) + 1, end));
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode result = new ListNode(Integer.MIN_VALUE);
            ListNode curr = result;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }

            if (l1 != null) {
                curr.next = l1;
            } else if (l2 != null) {
                curr.next = l2;
            }

            return result.next;
        }
    }
}