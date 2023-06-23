package org.example.technical_Inteview_evaluation.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestZero {
    /*
    Given an m x n binary matrix mat,
    return the distance of the nearest 0 for each cell.
    The distance between two adjacent cells is 1.
    Example 1:
    Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
    Output: [[0,0,0],[0,1,0],[0,0,0]]
    Example 2:
    Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
    Output: [[0,0,0],[0,1,0],[1,2,1]]
    Constraints:
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 104
    1 <= m * n <= 104
    mat[i][j] is either 0 or 1.
    There is at least one 0 in mat.
     */
    class State {
        int row;
        int col;
        int steps;
        State(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;

        int[][] matrix = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<State> queue = new LinkedList<>();

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = mat[row][col];
                if (mat[row][col] == 0) {
                    queue.add(new State(row, col, 0));
                    seen[row][col] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            State state = queue.remove();
            int row = state.row, col = state.col, steps = state.steps;

            for (int[] direction: directions) {
                int nextRow = row + direction[0], nextCol = col + direction[1];
                if (valid(nextRow, nextCol) && !seen[nextRow][nextCol]) {
                    seen[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, steps + 1));
                    matrix[nextRow][nextCol] = steps + 1;
                }
            }
        }
        return matrix;
    }
    public boolean valid(int row, int col) {
        return 0 <= row && row < m && 0 <= col && col < n;
    }
}

