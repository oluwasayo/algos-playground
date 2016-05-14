public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() < needle.length() || haystack.length() == 0)
            return -1;

        int ind = 0;
        for (int a = 0; a < haystack.length(); a++) {
            for (int b = a; b < haystack.length(); b++) {
                if (haystack.charAt(b) == needle.charAt(ind)) {
                   ind++;
                    if (ind == needle.length()) {
                        return b + 1 - needle.length();
                    }
                } else {
                    ind = 0;
                    break;
                }
            }
        }

        return -1;
    }
}