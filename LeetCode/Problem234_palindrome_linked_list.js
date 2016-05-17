/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {boolean}
 */
// TODO(oluwasayo): Investigate doing this in O(n) time and O(1) space.
var isPalindrome = function(head) {
    stack = []; node = head;
    while(node !== null) {
        stack.push(node); 
        node = node.next;
    }
    while (stack.length > 0) {
        if (stack.pop().val !== head.val) return false;
        head = head.next;
    }
    return true;
};
