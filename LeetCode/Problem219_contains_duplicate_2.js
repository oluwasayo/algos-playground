/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    if (k === 0 || nums.length === 0) return false;
    store = {};
    for (a = 0; a < nums.length; a++) {
        if (store[nums[a]] === undefined) store[nums[a]] = a;
        else if (a - store[nums[a]] <= k) return true;
        else store[nums[a]] = a;
    }
    return false;
};
