package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        boolean rsl = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                if (verticalCheck(board, i) || horizontalCheck(board, i)) {
                    return true;
                }
            }
        }
        return rsl;
    }

    public static boolean verticalCheck(int[][] board, int line) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][line] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean horizontalCheck(int[][] board, int line) {
        for (int i = 0; i < board[line].length; i++) {
            if (board[line][i] != 1) {
                return false;
            }
        }
        return true;
    }
}
