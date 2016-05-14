public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int last = s.length() - 1;
        while (last >= 0 && s.charAt(last) == ' ') last--;
        for (int a = last; a >= 0; a--) if (s.charAt(a) == ' ') return last - a;
        return last + 1;
    }
}