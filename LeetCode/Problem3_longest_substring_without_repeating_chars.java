import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        Deque<Character> deque = new ArrayDeque<Character>();
        Map<Character, Integer> buffer = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (int c = 0; c < chars.length; c++) {
            if (buffer.containsKey(chars[c])) {
                while (deque.peekLast() != chars[c]) {
                    buffer.remove(deque.pollLast());
                }
                buffer.remove(deque.pollLast());
            }

            buffer.put(chars[c], c); deque.push(chars[c]);
            System.out.printf("Char = %c, buffer = %s\n", chars[c], print(deque));
            result = Math.max(result, buffer.size());
        }
        return result;
    }

    private String print(Deque<Character> s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c).append(" ");
        }
        return sb.toString();
    }
}