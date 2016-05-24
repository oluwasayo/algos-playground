/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    sum = 0;
    for (a = 0; a <= 31; a++) sum += (((1 << a) & n) !== 0 ? 1 : 0) << (31 - a) >>> 0;
    return sum;
};
