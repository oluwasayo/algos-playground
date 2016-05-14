public class Solution {
    public int removeElement(int[] nums, int val) {
        int pos = 0;
        for (int a = 0; a < nums.length; a++) {
            if (nums[a] != val)
                nums[pos++] = nums[a];
        }
        return pos;
    }
}