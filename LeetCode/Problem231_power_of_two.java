public class Solution {

    // Using logarithms.
    public boolean isPowerOfTwo(int n) {
        double a = Math.log(n) / Math.log(2);
        return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
    }

    // Using binary search on raw bits.
    public boolean isPowerOfTwo(int n) {
        int a = 1, lo = 0, hi = 31;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int num = 1 << mid;
            if (num == n) return true;
            else if (num < n) lo = mid;
            else hi = mid;
            if (hi - lo == 1) return (1 << lo == n) || (1 << hi == n);
        }
        return false;
    }
}