package 回溯算法;

import javax.swing.*;

class Q37 {
    public void solveSudoku(char[][] board)
    {
    backtraveling(board);
    }
    public boolean backtraveling(char[][] board)
    {
        //首先找到空点位置
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++)
            {
                if(board[i][j] != '.') continue;

                for(char k = '1'; k <= '9'; k++)
                {
                    if(isValid(board,k,i,j)){
                        board[i][j] = k;
                      if( backtraveling(board)) {
                          return true;
                      }
                        board[i][j] = '.';
                    }
                }
                //9个数字都不满足则返回错误
                return false;
            }
        }
        //遍历完整个棋盘
        return true;
    }

    public boolean isValid(char[][]board,char value,int row, int col) {
        //判断同一行有没有相同数字
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) return false;
        }
        //判断同一列有没有相同数字
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) return false;
        }
        //判断九个格里面有没有相同数字
        int r = 0;
        int c = 0;
        int r1 = row - 3;
        int c1 = col -3;
        while(r1 >= 0)
        {
            r += 3;
            r1 -= 3;
        }
        while(c1 >= 0)
        {
            c += 3;
            c1 -= 3;
        }
        //此时的 r 和 c 是row 和 col 所处九宫格位置的开头
        for(int i = r ; i < r+3; i++)
            for(int j = c; j <c+ 3; j++)
            {
                if(board[i][j] == value) return false;
            }
        return true;
    }


}
