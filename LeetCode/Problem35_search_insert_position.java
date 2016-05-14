public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0] >= target ? 0 : 1;

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (hi - lo == 1) return nums[lo] >= target ? lo : nums[hi] < target ? hi + 1 : hi;

            int mid = (lo + hi) / 2;
            if (nums[mid] >= target) hi = mid;
            else lo = mid;
        }
        return nums[lo] < target ? lo - 1 : lo;
    }
}