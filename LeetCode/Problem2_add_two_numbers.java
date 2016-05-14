public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val, n2 = l2 == null ? 0: l2.val;
            node.next = new ListNode((carry + n1 + n2) % 10);
            carry = (carry + n1 + n2) / 10;
            node = node.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }

        if (carry > 0) {
            node.next = new ListNode(carry);
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(9);// n1.next = new ListNode(4); n1.next.next = new ListNode(3);
        ListNode n2 = new ListNode(1); n2.next = new ListNode(9); n2.next.next = new ListNode(9);
        ListNode sol = new Solution().addTwoNumbers(n1, n2);
        print(sol);
    }

    private static void print(ListNode sol) {
        for ( ; sol != null; sol = sol.next) {
            System.out.print(sol.val + " -> ");
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}