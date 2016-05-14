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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode ln = head;
        while (ln != null) {
            size++;
            ln = ln.next;
        }
        if (size == 1) return null;
        int target = size - n;
        if (target <= 0) return head.next;
        ln = head;
        for (int a = 1; a < target; a++) {
            ln = ln.next;
        }
        ln.next = ln.next.next;
        return head;
    }
}