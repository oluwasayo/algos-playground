import java.util.*;
public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> hashCodes = new HashSet<>();
        perm(nums, 0, result, hashCodes);
        return result;
    }

    private void perm(int[] nums, int fix, List<List<Integer>> result, Set<Integer> hashCodes) {
        if (fix == nums.length - 1) {
            int hashcode = Arrays.hashCode(nums);
            if (!hashCodes.contains(hashcode)) {
                List<Integer> line = new ArrayList<>();
                for (int a : nums) line.add(a);
                result.add(line);
                hashCodes.add(hashcode);
            }
            return;
        }

        for (int a = fix; a < nums.length; a++) {
            swap(nums, fix, a);
            perm(nums, fix + 1, result, hashCodes);
            swap(nums, fix, a);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}