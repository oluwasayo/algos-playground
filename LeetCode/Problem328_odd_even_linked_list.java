/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(Integer.MIN_VALUE);
        ListNode evenHead = new ListNode(Integer.MAX_VALUE);
        ListNode oddTail = oddHead;
        ListNode evenTail = evenHead;
        ListNode current = head;
        boolean isOdd = false;
        while (current != null) {
            isOdd = !isOdd;
            ListNode copy = new ListNode(current.val);
            if (isOdd) {
                oddTail.next = copy;
                oddTail = oddTail.next;
            } else {
                evenTail.next = copy;
                evenTail = evenTail.next;
            }
            current = current.next;
        }
        oddTail.next = evenHead.next;
        return oddHead.next;
    }
}