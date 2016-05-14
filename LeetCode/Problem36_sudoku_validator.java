import java.util.*;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        for (int a = 0; a < board.length; a++) {
            set.clear();
            for (char c : board[a]) {
                if (c == '.') continue;
                if (!set.add(c)) return false;
            }
        }

        for (int a = 0; a < board[0].length; a++) {
            set.clear();
            for (int b = 0; b < board.length; b++) {
                if (board[b][a] == '.') continue;
                if (!set.add(board[b][a])) return false;
            }
        }

        for (int a = 0; a < board.length / 3; a++) {
            int y = 3 * a;
            for (int b = 0; b < board[0].length / 3; b++) {
                int x = 3 * b;
                set.clear();
                for (int v = 0; v < 3; v++) {
                    for (int h = 0; h < 3; h++) {
                        if (board[v + y][h + x] == '.') continue;
                        if (!set.add(board[v + y][h + x])) return false;
                    }
                }
            }
        }

        return true;
    }
}