public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) return nums[0] == target ? 0 : -1;
        else if (nums[0] <= nums[nums.length - 1]) return Math.max(java.util.Arrays.binarySearch(nums, target), -1);

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            if (hi - lo == 1)  return nums[lo] == target ? lo : nums[hi] == target ? hi : -1;

            int mid = (lo + hi) / 2;
            // Force search into the right section of array.
            if (nums[mid] >= nums[0] && target < nums[0]) {
                // Mid point > rotation point and we're searching right section.
                lo = mid;
                continue;
            } else if (nums[mid] <= nums[0] && target >= nums[0]) {
                // Mid point <= rotation point and we're searching left section.
                hi = mid;
                continue;
            }

            // We're now in the right section. Perform standard binary search.
            if (nums[mid] > target) {
                hi = mid;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}