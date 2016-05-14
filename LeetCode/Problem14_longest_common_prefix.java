public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        char c = '\u0000';
        outer: for (int a = 0; a < strs[0].length(); a++) {
            for (int b = 0; b < strs.length; b++) {
                try {
                    char curr = strs[0].charAt(a);
                    if (strs[b].charAt(a) != curr) {
                        break outer;
                    }
                } catch (Exception ex) {
                    break outer;
                }
            }
            sb.append(strs[0].charAt(a));
        }

        return sb.toString();
    }
}