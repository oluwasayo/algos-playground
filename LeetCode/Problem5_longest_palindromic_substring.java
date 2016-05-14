public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 2) {
            return s;
        }

        int longest = 0;
        String result = "";
        outer: for (int pos = 1; pos < s.length() - 1; pos++) {
            int a = 0;
            while (pos >= a && pos + a < s.length()) {
                if (s.charAt(pos - a) != s.charAt(pos + a)) break;
                a++;
            }
            a--;
            if (pos < a || pos + a >= s.length()) a++;
            result = 1 + (2 * a) > longest ? s.substring(pos - a, pos + a + 1) : result;
            longest = Math.max(longest, 1 + (2 * a));
        }

        outer: for (int pos = 0; pos < s.length() - 1; pos++) {
            int a = 0;
            while (pos >= a && pos + a + 1 < s.length()) {
                if (s.charAt(pos - a) != s.charAt(pos + a + 1)) break;
                a++;
            }
            a--;
            if (pos < a || pos + a + 1 >= s.length()) a++;
            result = 2 * (a + 1) > longest ? s.substring(pos - a, pos + a + 2) : result;
            longest = Math.max(longest, 2 * (a + 1));
        }

        return result;
    }
}