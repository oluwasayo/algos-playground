/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long lo = 1, hi = n;
        while (lo < hi) {
            if (hi - lo <= 1) return (int) (isBadVersion((int)lo) ? lo : hi);
            long mid = (lo + hi) / 2;
            if (isBadVersion((int)mid)) hi = mid;
            else lo = mid;
        }
        return 1;
    }
}