/**
 * @param {number} num
 * @return {number}
 */
var addDigits = function(num) {
    return num < 10 ? num : num - (9 * Math.floor((num - 1) / 9));
};
