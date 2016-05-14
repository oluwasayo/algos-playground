public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int a = 0; a < 32; a++) if (((n >>> a) & 1) == 1) res++;
        return res;
    }
}