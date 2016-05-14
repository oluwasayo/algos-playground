public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        if (nums.length == 1) return Arrays.asList(range(nums[0], nums[0]));

        List<String> result = new ArrayList<>();
        int last = nums[0], curr = nums[0];
        boolean flag = false;
        for (int a = 1; a < nums.length; a++) {
            if (nums[a] - curr != 1) {
                result.add(range(last, curr));
                last = nums[a]; curr = nums[a];
                flag = false;
            } else {
                curr = nums[a];
                flag = true;
            }
        }
        result.add(range(last, curr));
        return result;
    }

    private String range(int start, int end) {
        return start == end ? Integer.toString(start) : start + "->" + end;
    }
}