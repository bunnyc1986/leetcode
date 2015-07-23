import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/unique-paths/
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m + 1][n + 1];
        matrix[m - 1][n] = 1;
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                matrix[r][c] = matrix[r + 1][c] + matrix[r][c + 1];
            }
        }
        return matrix[0][0];
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(28, solution.uniquePaths(7, 3));
    }
}
