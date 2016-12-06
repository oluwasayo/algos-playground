public class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int a = arr.length - 1; a >= 0; a--) {
            if (arr[a].length() > 0) {
                if (sb.length() > 0) sb.append(" ");
                sb.append(arr[a]);
            }
        }
        return sb.toString();
    }
}
