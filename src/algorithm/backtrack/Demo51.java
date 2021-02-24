package algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 提示：
 *
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 *
 * https://leetcode-cn.com/problems/n-queens/
 * @author liq
 * @date 2021/2/24
 */
public class Demo51 {


    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (char[] chars : board) {
            Arrays.fill(chars,'.');
        }

        dfs(board,0);

        return res;
    }

    private void dfs(char[][] board, int row) {

        // 满足了一个条件
        if(row == board.length) {
            List<String> list = generator(board);
            res.add(list);
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            if(!isValid(board,row,col)) {
                continue;
            }
            board[row][col] = 'Q';
            dfs(board,row+1);
            board[row][col] = '.';
        }



    }

    private boolean isValid(char[][] board, int row, int col) {
        int n = board.length;

        // 检查列
        for (int i = 0; i < n; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        // 右上方
        for (int i = row - 1, j = col + 1; i >=0 && j < n; i--,j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // 左上方
        for (int i = row - 1, j = col - 1; i >=0 && j >= 0; i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> generator(char[][] board) {
        List<String> list = new LinkedList<>();
        for (char[] chars : board) {
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Demo51().solveNQueens(4);
        System.out.println(lists);
    }


}



















