import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class Solution {

    @Test
    public void test() {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);
        assertEquals(8, numMatrix.sumRegion(2, 1, 4, 3));
        assertEquals(11, numMatrix.sumRegion(1, 1, 2, 2));
        assertEquals(12, numMatrix.sumRegion(1, 2, 2, 4));
    }

    @Test
    public void testEmptyMatrix() {
        int[][] matrix = new int[][]{};
        NumMatrix numMatrix = new NumMatrix(matrix);
        assertEquals(0, numMatrix.sumRegion(2, 1, 4, 3));
    }

    public class NumMatrix {
        private int[][] accumulations;
        private int height;
        private int width;

        public NumMatrix(int[][] matrix) {
            this.height = matrix.length;
            this.width = height == 0 ? 0 : matrix[0].length;
            this.accumulations = new int[height + 1][width + 1];

            for (int c = 0; c < width + 1; c++) {
                accumulations[0][c] = 0;
            }
            for (int r = 1; r < height + 1; r++) {
                accumulations[r][0] = 0;
                for (int c = 1; c < width + 1; c++) {
                    accumulations[r][c] = accumulations[r][c - 1] +
                            accumulations[r - 1][c] -
                            accumulations[r - 1][c - 1] +
                            matrix[r - 1][c - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sumTop = accumulations[Math.min(height, row1)][Math.min(width, col2 + 1)];
            int sumLeft = accumulations[Math.min(height, row2 + 1)][Math.min(width, col1)];
            int sumTopLeft = accumulations[Math.min(height, row1)][Math.min(width, col1)];
            int sum = accumulations[Math.min(height, row2 + 1)][Math.min(width, col2 + 1)];
            return sum - sumTop - sumLeft + sumTopLeft;
        }
    }
}
