public class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if (num1 == "" || num2 == "") return "";
        if (num1.length() == 1 || num2.length() == 1) return singleMultiply(num2, num1);

        // Pad inputs with zeros to make the same number of digits.
        int len = Math.max(num1.length(), num2.length());
        StringBuilder sb1 = new StringBuilder(num1), sb2 = new StringBuilder(num2);
        for (int a = sb1.length(); a < len; a++) sb1.insert(0, '0');
        for (int a = sb2.length(); a < len; a++) sb2.insert(0, '0');
        num1 = sb1.toString(); num2 = sb2.toString();

        // Karatsuba algorithm.
        String[] fComp = split(num1), sComp = split(num2);
        String a = fComp[0], b = fComp[1], c = sComp[0], d = sComp[1];
        // Three recursive multiplications.
        String a_c = multiply(a, c);
        String b_d = multiply(b, d);
        String ab_cd = multiply(add(a, b), add(c, d))
        String e = subtract(subtract(ab_cd, b_d), a_c);
        return add(add(pad(a_c, (len >> 1) << 1), pad(e, len >> 1)), b_d);
    }

    private int effLen(String num) { // Effective length, ignoring leading zeros.
        int a = 0;
        for (; a < num.length(); a++) if (num.charAt(a) != '0') break;
            return num.length() - a;
    }

    private String trim(String num) {
        return trim(new StringBuilder(num));
    }

    private String trim(StringBuilder sb) { // Strip leading zeros.
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.toString();
    }

    private String[] split(String s) { // Split in halves. If odd length first half > second.
        int m = s.length() >> 1;
        m = (s.length() & 1) == 1 ? m + 1 : m;
        return new String[]{s.substring(0, m), s.substring(m)};
    }

    // Multiply an arbitrary string with a single-digit string.
    private String singleMultiply(String num1, String num2) {
        if (num1 == "0" || num2 == "0") return "0";
        if (num1 == "1") return num2;
        if (num2 == "1") return num1;

        String a, b;
        if (num1.length() == 1) {
            a = num2; b = num1;
        } else {
            a = num1; b = num2;
        }

        StringBuilder sb = new StringBuilder();
        int c = 0, s = b.charAt(0) - '0';
        // Grade school multiplication.
        for (int i = a.length() - 1; i >= 0; i--) {
            int f = a.charAt(i) - '0';
            sb.insert(0, ((f * s) + c) % 10);
            c = ((f * s) + c) / 10;
        }

        if (c > 0) sb.insert(0, c);
        return trim(sb);
    }

    private String add(String num1, String num2) {
        String a, b;
        if (num1.length() >= num2.length()) {
            a = num1; b = num2;
        } else {
            a = num2; b = num1;
        }

        StringBuilder sb = new StringBuilder();
        int c = 0, diff = a.length() - b.length();
        // Grade school addition.
        for (int i = a.length() - 1; i >= 0; i--) {
            int f = a.charAt(i) - '0', s = i - diff < 0 ? 0 : b.charAt(i - diff) - '0';
            sb.insert(0, (f + c + s) % 10);
            c = (f + c + s) / 10;
        }

        if (c > 0) sb.insert(0, c);
        return trim(sb);
    }

    private String subtract(String num1, String num2) {
        String a = null, b = null;

        // Ensure that the first operand is always greater than the second.
        if (num1.length() > num2.length()) {
            a = num1; b = num2;
        } else if (num1.length() < num2.length()) {
            a = num2; b = num1;
        } else {
            // Digit size is equal, compare each corresponding digits.
            for (int i = 0; i < num1.length(); i++) {
                if (num1.charAt(i) - '0' > num2.charAt(i) - '0') {
                    a = num1; b = num2; break;
                } else if (num2.charAt(i) - '0' > num1.charAt(i) - '0') {
                    a = num2; b = num1; break;
                }
            }
            if (a == null) return "0"; // Num1 equals num2.
        }

        StringBuilder sb = new StringBuilder();
        int c = 0, diff = a.length() - b.length();
        // Grade school subtraction.
        for (int i = a.length() - 1; i >= 0; i--) {
            int f = a.charAt(i) - '0', s = i - diff < 0 ? 0 : b.charAt(i - diff) - '0';
            int p = f - c - s;
            if (p < 0) {
                p += 10;
                c = 1;
            } else c = 0;
            sb.insert(0, p);
        }

        return trim(sb);
    }

    private String pad(String num, int zeros) {
        StringBuilder sb = new StringBuilder(num);
        for (int a = 0; a < zeros; a++) sb.append('0');
            return sb.toString();
    }
}