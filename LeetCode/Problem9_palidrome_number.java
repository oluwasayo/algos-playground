public class Solution {
    public boolean isPalindrome(int x) {
        return x < 0 ? false : Integer.toString(x).equals(new StringBuilder(Integer.toString(x)).reverse().toString());
    }
}