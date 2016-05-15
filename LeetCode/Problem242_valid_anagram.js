/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;
    (sArr = []).length = 26; (tArr = []).length = 26;
    sArr.fill(0); tArr.fill(0);
    for (a = 0; a < s.length; a++) {
        sArr[s.charCodeAt(a) - 97]++; tArr[t.charCodeAt(a) - 97]++;
    }
    
    for (a = 0; a < sArr.length; a++) if (sArr[a] !== tArr[a]) return false;
    return true;
};
