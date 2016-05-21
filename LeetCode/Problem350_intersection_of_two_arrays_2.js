/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function(nums1, nums2) {
    store = {}, store2 = {};
    nums1.forEach(e => store[e] = store[e] === undefined ? 1 : store[e] + 1);
    nums2.forEach(e => store2[e] = store2[e] === undefined ? 1 : store2[e] + 1);
    result = [];
    for (var e in store) { 
        console.log("Inspecting: " + e);
        if (!store.hasOwnProperty(e) || store2[e] === undefined) continue;
        console.log("here");
        for (a = 0; a < Math.min(store[e], store2[e]); a++) result.push(parseInt(e));
    }
    console.log(store); console.log(store2);
    return result;
};
