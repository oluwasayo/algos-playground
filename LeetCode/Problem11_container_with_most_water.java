public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        for (int a = 0, b = height.length - 1; a < b;) {
            result = Math.max(result, Math.min(height[a], height[b]) * (b - a));
            if (height[a] < height[b]) a++; else b--;
        }
        return result;
    }
}