public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        int blocks = s.length() / ((2 * numRows) - 2);
        int blockWidth = (2 * numRows) - 2;
        char[][] grid = new char[numRows][(s.length() / 2) + 1];

        boolean downwards = true;
        int d = 0, w = 0;
        for (int a = 1; a <= s.length(); a++) {
            grid[d][w] = s.charAt(a - 1);
            if (a % blockWidth == 1) {
                downwards = true;
            } else if (a % blockWidth == numRows || (blockWidth == 2 && a % blockWidth == 0)) {
                downwards = false;
            }

            if (downwards) {
                d++;
            } else {
                d--; w++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a = 0; a < grid.length; a++) {
            for (int b = 0; b < grid[0].length; b++) {
                if (grid[a][b] != '\u0000') {
                    sb.append(grid[a][b]);
                }
            }
        }

        return sb.toString();
    }
}