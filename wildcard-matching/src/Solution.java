import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/wildcard-matching/
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];
        m[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    m[i][j] =
                            (i > 0 && m[i - 1][j]) ||
                            (i > 0 && j > 0 && m[i - 1][j - 1]) ||
                            (j > 0 && m[i][j - 1]);
                } else {
                    m[i][j] = i > 0 && m[i - 1][j - 1] && (c == '?' || c == s.charAt(i - 1));
                }
            }
        }
        return m[s.length()][p.length()];
    }

    @Test
    public void test() {
        Assert.assertFalse(isMatch("abab", "ab*ba*b"));
        Assert.assertTrue(isMatch("aa", "*"));
        Assert.assertFalse(isMatch("aab", "c*a*b"));
        Assert.assertTrue(isMatch("", "*"));
    }
}
