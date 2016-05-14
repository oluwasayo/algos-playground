import java.util.*;
public class Solution {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }
        int a = s.indexOf('(');
        if (a < 0) {
            return 0;
        }
        if (s.lastIndexOf(')') < 0) {
            return 0;
        }

        boolean[] dp = new boolean[s.length()];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for ( ; a < s.length(); a++) {
            if (s.charAt(a) == '(') deque.push(a);
            else {
                if (!deque.isEmpty()) {
                    dp[a] = true;
                    dp[deque.pop()] = true;
                }
            }
        }

        int result = 0, w = 0;
        for (boolean isUsed : dp) {
            if (isUsed) result = Math.max(result, ++w);
            else w = 0;
        }

        return result;
    }
}