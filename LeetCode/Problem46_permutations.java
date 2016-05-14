import java.util.*;
public class Solution {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        perm(nums, 0, result);
        return result;
    }

    private static void perm(int[] nums, int fix, List<List<Integer>> result) {
        if (fix >= nums.length - 1) {
            List<Integer> line = new ArrayList<>(nums.length);
            for (int num : nums) line.add(num);
            result.add(line);
            return;
        }

        for (int a = fix; a < nums.length; a++) {
            swap(nums, fix, a);
            perm(nums, fix + 1, result);
            swap(nums, fix, a);
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}