public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int a = 1; a <= num / 1000; a++) sb.append('M');
        char[][] tokens = {{'X','V','I'},{'C','L','X'},{'M','D','C'}};
        for (int a = tokens.length; a > 0; a--) {
            num %= Math.pow(10, a);
            sb.append(spit((int) (num / Math.pow(10, a-1)), tokens[a - 1]));
        }
        return sb.toString();
    }

    private String spit(int num, char[] t) {
        if (num == 0) return "";
        StringBuilder sb = new StringBuilder();
        if (num == 5) return sb.append(t[1]).toString();

        int c = num;
        if (num > 8) c = 10 - num;
        else if (num > 5 && num <= 8) c = num - 5;
        else if (num == 5) c = 0;
        else if (num > 3) c = 5 - num;

        if (num > 5 && num <= 8) sb.append(t[1]);
        for (int a = 1; a <= c; a++) sb.append(t[2]);
        if (num > 8) sb.append(t[0]);
        else if (num > 3 && num < 5) sb.append(t[1]);

        return sb.toString();
    }
}