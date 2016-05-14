import java.util.*;

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        char[] chars = str.toCharArray();
        boolean started = false;
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (started) {
                if (!digit(c)) {
                    break;
                }
                sb.append(c);
            } else {
                if (digit(c) || sign(c)) {
                    sb.append(c);
                    started = true;
                } else {
                    if (c != ' ' && c != '\t' && c != '\n') {
                        break;
                    }
                }
            }
        }

        //System.out.println(sb.toString());
        if (sb.length() == 0 || sb.length() == 1 && !digit(sb.charAt(0))) {
            return 0;
        }

        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException nfe) {
            if (sb.charAt(0) == '-') {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }

    private boolean digit(char c) {
        return c >= 48 && c <= 57;
    }

    private boolean sign(char c) {
        return c == '-' || c == '+';
    }
}