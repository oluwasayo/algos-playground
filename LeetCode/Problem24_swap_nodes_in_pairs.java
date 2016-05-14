/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = head;
        ListNode next = head.next;
        head.next = head.next.next;
        next.next = head;
        result = next;

        ListNode curr = result.next;
        while (curr != null && curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            curr.next = second;
            first.next = second.next;
            second.next = first;

            curr = curr.next.next;
        }

        return result;
    }
}