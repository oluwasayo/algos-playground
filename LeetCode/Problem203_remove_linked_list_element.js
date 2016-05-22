/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} val
 * @return {ListNode}
 */
var removeElements = function(head, val) {
    while (head !== null && head.val === val) head = head.next;
    if (head === null) return null;
    prev = head, node = prev.next;
    while (node !== null) {
        if (node.val === val) {
            prev.next = node = node.next;
            continue;
        }
        prev.next = node; 
        prev = prev.next; 
        node = node.next;
    }
    return head;
};
