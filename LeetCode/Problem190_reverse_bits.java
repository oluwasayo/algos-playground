public class Solution {
    public int reverseBits(int n) {
        int sum = 0;
        for (int a = 0; a <= 31; a++) sum += (((1 << a) & n) != 0 ? 1 : 0) << (31 - a);
        return sum;
    }
}
