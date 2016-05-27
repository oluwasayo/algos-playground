public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int a = 0; a < s.length(); a++) sum += (s.charAt(a) - 'A' + 1) * pow(26, s.length() - a - 1);
        return sum;
    }

    private int pow(int base, int exponent) {
        int result = 1;
        for (int a = 0; a < exponent; a++) result *= base;
        return result;
    }
}
