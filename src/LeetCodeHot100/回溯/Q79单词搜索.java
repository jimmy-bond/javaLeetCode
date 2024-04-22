package LeetCodeHot100.回溯;

import com.sun.org.apache.bcel.internal.generic.FALOAD;

import javax.swing.plaf.basic.BasicOptionPaneUI;

public class Q79单词搜索 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //从[i,j]这个坐标开始查找
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        if (index == word.length - 1)
            return true;
        char tmp = board[i][j];
        board[i][j] = '.';
        boolean res = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i, j + 1, index + 1) || dfs(board, word, i, j - 1, index + 1);
        board[i][j] = tmp;
        return res;
    }
}
