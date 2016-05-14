public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int a = 0; a < s.length(); a++) {
            char c = s.charAt(a), d = t.charAt(a);
            if ((!map.containsKey(c) && set.contains(d))
                || (map.containsKey(c) && d != map.get(c))) return false;
            map.put(c, d); set.add(d);
        }
        return true;
    }
}