public class Solution {
    public String countAndSay(int n) {
        StringBuilder buffer = new StringBuilder("1");
        int count = 0;
        String str = "";
        for (int a = 1; a < n; a++) {
            str = new String(buffer.toString());
            buffer.setLength(0);
            int curr = str.charAt(0) - '0';
            count = 1;
            for (int b = 1; b < str.length(); b++) {
                int temp = str.charAt(b) - '0';
                if (temp == curr) {
                    count++;
                    continue;
                } else {
                    buffer.append(count).append(str.charAt(b - 1));
                    curr = temp;
                    count = 1;
                }
            }
            buffer.append(count).append(str.charAt(str.length() - 1));
        }
        return buffer.toString();
    }
}