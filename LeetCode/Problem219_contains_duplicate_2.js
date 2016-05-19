/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    if (k === 0 || nums.length < 2) return false;
    store = {};
    return nums.some((e, i) => {
        if (store[e] === undefined) store[e] = i;
        else if (i - store[e] <= k) return true;
        else store[e] = i;
    });
};
