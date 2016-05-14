/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 import java.util.*;
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Deque<ListNode> deque = new ArrayDeque<ListNode>();
        ListNode result = head;
        ListNode tail = head;
        ListNode curr = head;
        for (int i = 1; curr != null; i += k) {
            deque.clear();
            int pos = 0;
            while (pos < k && curr != null) {
                deque.push(curr);
                curr = curr.next;
                pos++;
            }

            if (deque.size() < k) {
                return result;
            }

            ListNode link = deque.peek().next;
            ListNode newHead = deque.pop();
            ListNode newCurr = newHead;
            while (deque.peek() != null) {
                newCurr.next = deque.pop();
                newCurr = newCurr.next;
            }
            newCurr.next = link;
            curr = link;
            if (i == 1) {
                result = newHead;
            } else {
                tail.next = newHead;
                tail = newCurr;
            }
        }

        return result;
    }
}