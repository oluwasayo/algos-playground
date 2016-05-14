public class Solution {

    // Move through and swap non-zeros to the front.
    public void moveZeroes(int[] nums) {
        for (int a = 0, b = 0; a < nums.length; a++) if (nums[a] != 0) swap(nums, a, b++);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    // Alternative solution involving block movement.
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (nums[end] == 0) if (--end <= start) return;
            if (nums[start++] == 0) {
                int lo = start-1, hi = lo;
                while (nums[++hi] == 0) ;
                if (hi <= end) end = move(nums, lo, hi, end);
            }
        }
    }

    private int move(int[] nums, int lo, int hi, int end) {
        System.arraycopy(nums, hi, nums, lo, end - hi + 1);
        int zeroStart = end - hi + lo + 1;
        Arrays.fill(nums, zeroStart, end + 1, 0);
        return zeroStart;
    }
}