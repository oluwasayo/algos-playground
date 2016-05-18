/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    store = {}; nums1 = [...new Set(nums1)]; nums2 = [...new Set(nums2)]; result = [];
    nums1.forEach(element => store[element] = store[element] === undefined ? 1 : 2);
    nums2.forEach(element => store[element] = store[element] === undefined ? 1 : 2);
    Object.keys(store).forEach(key => {if (store[key] > 1) result.push(parseInt(key))});
    return result;
};
