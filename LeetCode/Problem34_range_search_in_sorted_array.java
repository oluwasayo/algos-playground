public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums, target, true), find(nums, target, false)};
    }

    public int find(int[] nums, int target, boolean left) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (hi - lo == 1) {
                if (left) {
                    return nums[lo] == target ? lo : nums[hi] == target ? hi : -1;
                } else {
                    return nums[hi] == target ? hi : nums[lo] == target ? lo : -1;
                }
            }
            int mid = (hi + lo) / 2;
            if (left) {
                if (nums[mid] >= target) hi = mid;
                else lo = mid;
            } else {
                if (nums[mid] > target) hi = mid;
                else lo = mid;
            }

        }
        return nums[lo] == target ? lo : -1;
    }
}