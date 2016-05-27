public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int a = s.length() - 1; a >= 0; a--) sum += val(s.charAt(a)) * pow(26, a);
        return sum;
    }
    private int val(char c) {
        return c - 'A' + 1;
    }
    private int pow(int base, int exponent) {
        int result = 1;
        for (int a = 0; a < exponent; a++) result *= base;
        return result;
    }
}
