/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    if (k === 0 || nums.length <= 1) return;
    k %= nums.length;
    head = nums.slice(nums.length - k);
    tail = nums.slice(0, nums.length - k);
    nums.length = 0;
    nums.push(...[...head, ...tail]);
};
