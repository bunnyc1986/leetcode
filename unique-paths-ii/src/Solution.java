import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m + 1][n + 1];
        matrix[m - 1][n] = 1;
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                matrix[r][c] = obstacleGrid[r][c] == 1 ? 0 : matrix[r + 1][c] + matrix[r][c + 1];
            }
        }
        return matrix[0][0];
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(2, solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        assertEquals(1, solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 1, 0}}));
        assertEquals(1, solution.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 0}}));
    }
}
