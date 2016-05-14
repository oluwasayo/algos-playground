/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    start = 0, end = s.length - 1, chars = s.split('');
    while (start < s.length && end > -1 && start < end) {
        while (!isVowel(chars[start])) if (++start >= s.length || start == end) return chars.join('');
        while (!isVowel(chars[end])) if (--end < 0 || start == end) return chars.join('');
        swap(chars, start++, end--);
    }
    return chars.join('');
};

function isVowel(c) { return "aeiouAEIOU".indexOf(c) >= 0 ? true : false; }

function swap(chars, start, end) {
    temp = chars[start];
    chars[start] = chars[end];
    chars[end] = temp;
}