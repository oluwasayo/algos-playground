public class NumArray {

    private int[] nums;
    private int[] prefixSums;

    public NumArray(int[] nums) {
        this.nums = nums;
        prefixSums = new int[nums.length];
        if (nums.length > 0) {
            prefixSums[0] = nums[0];
            for (int a = 1; a < nums.length; a++) prefixSums[a] = prefixSums[a - 1] + nums[a];
        }
    }

    public int sumRange(int i, int j) {
        return nums.length == 0 ? 0 : i == j ? nums[i] : prefixSums[j] - (i == 0 ? 0 : prefixSums[i - 1]);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);