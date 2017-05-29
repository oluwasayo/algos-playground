import static java.lang.Math.*;

public class Solution {

    // Constant space, logarithmic time.
    public int reverse(int x) {
        boolean isNegative = x < 0;
        x = abs(x);
        int log = (int) log10(x);
        int result = 0;
        for (int a = log; a >= 0; a--) {
            int divisor = (int) pow(10, a);
            try {
                int part = (int) ((x / divisor)* pow(10, log - a));
                result = addExact(result, part);
                if (isNegative) addExact(0 - result, part);
            } catch (ArithmeticException ex) {
                return 0;
            }
            x %= divisor;
        }
        
        return isNegative ? 0 - result : result;
    }

    // Linear space, logarithmic time.
    public int reverse2(int x) {
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
