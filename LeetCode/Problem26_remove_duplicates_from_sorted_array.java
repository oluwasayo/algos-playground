public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int len = nums.length;
        int pos = 0;
        for (int a = 1; a < nums.length; a++) {
            if (nums[a] == nums[pos]) {
                len--;
            } else {
                nums[++pos] = nums[a];
            }
        }

        return len;
    }
}