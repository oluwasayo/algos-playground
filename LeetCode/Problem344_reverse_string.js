/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    pos = 0, mid = s.length / 2 >> 0, chars = s.split('');
    while (pos < mid) swap(chars, pos, s.length - 1 - pos++);
    return chars.join('');
};

function swap(chars, start, end) {
    temp = chars[start];
    chars[start] = chars[end];
    chars[end] = temp;
}