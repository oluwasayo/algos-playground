public class Solution {
    public void rotate(int[][] matrix) {
        int[][] buffer = new int[matrix.length][matrix.length];
        for (int a = 0; a < matrix.length; a++) {
            buffer[a] = Arrays.copyOf(matrix[a], matrix.length);
        }
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix.length; y++) {
                matrix[x][buffer.length - 1 - y] = buffer[y][x];
            }
        }
    }

    private void swap(int[] source, int sPos, int[] target, int tPos) {
        int temp = source[sPos];
        source[sPos] = target[tPos];
        target[tPos] = temp;
    }
}