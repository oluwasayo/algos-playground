public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();

        int h = word1.length() + 1, w = word2.length() + 1;
        int[][] grid = new int[h][w];
        for (int a = 0; a < h; a++) grid[a][0] = a;
        for (int a = 0; a < w; a++) grid[0][a] = a;
        for (int a = 1; a < h; a++) {
            for (int b = 1; b < w; b++) {
                int s = grid[a-1][b-1] + (word1.charAt(a-1) == word2.charAt(b-1) ? 0 : 1);
                int i = grid[a][b-1] + 1, d = grid[a-1][b] + 1;
                grid[a][b] = Math.min(Math.min(s, i), d);
            }
        }
        return grid[h-1][w-1];
    }
}