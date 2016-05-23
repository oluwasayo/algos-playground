/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
 var reverseList = function(head) {
    if (head === null || head.next === null) return head;
    return reverseRecursive(head); // OR: return reverseIterative(head);
};

// O(n) time, O(n) space using stack data structure.
function reverseIterative(head) {
    stack = [];
    while (head !== null) {
        stack.push(head);
        head = head.next;
    }
    head = stack.pop(); node = head;
    while (stack.length !== 0) {
        node.next = stack.pop();
        node = node.next;
        node.next = null;
    }
    return head;
}

// O(n) time, O(1) space on heap (but O(n) space on function call stack).
function reverseRecursive(head) {
    return recurse(head)[0];
}

// Keep track of new head and tail for fast rotation.
function recurse(head) {
    if (head.next === null) return [head, head];
    
    temp = recurse(head.next);
    temp[1].next = head;
    temp[1].next.next = null;
    return [temp[0], temp[1].next];
}
