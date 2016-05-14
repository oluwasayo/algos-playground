public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int a = 0; a < nums.length - 1; a++) {
            for (int b = a+1; b < nums.length; b++) {
                if (nums[b] + nums[a] == target)
                    return new int[]{a+1, b+1};
            }
        }
        return new int[]{-1, -1};
    }
}