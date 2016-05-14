public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        if (nums.length == 2) {
            swap(nums, 0, 1);
            return;
        }

        for (int a = nums.length - 2; a >= 0; a--) {
            if (nums[a] < nums[a + 1]) {
                int cap = a + 1;
                for (int b = a + 2; b < nums.length; b++) {
                    if (nums[b] < nums[cap] && nums[b] > nums[a]) {
                        cap = b;
                    }
                }

                swap(nums, a, cap);
                java.util.Arrays.sort(nums, a + 1, nums.length);
                return;
            }
        }

        java.util.Arrays.sort(nums);
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}