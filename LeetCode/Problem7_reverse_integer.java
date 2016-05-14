public class Solution {
    public int reverse(int x) {
        int num = x;
        StringBuilder result = new StringBuilder();
        char[] chars = Integer.toString(Math.abs(num)).toCharArray();
        for (int a = chars.length - 1; a >= 0; a--) {
            result.append(chars[a]);
        }
        int ret = 0;
        try {
            ret = Integer.parseInt(result.toString());
        } catch (NumberFormatException nfe) {
            return 0;
        }
        return x < 0 ? 0 - ret : ret;
    }
}