import java.util.*;
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern.isEmpty() || str.isEmpty()) return false;
        String[] tokens = str.split("\\s");
        if (tokens.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> words = new HashSet<String>();
        for (int a = 0; a < pattern.length(); a++) {
            char c = pattern.charAt(a);
            if ((!map.containsKey(c) && words.contains(tokens[a]))
                || (map.containsKey(c) && !tokens[a].equals(map.get(c)))) return false;
            map.put(pattern.charAt(a), tokens[a]); words.add(tokens[a]);
        }
        return true;
    }
}