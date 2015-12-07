import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class Solution {

    public boolean isMatch(String s, String p) {
        boolean[][] m = new boolean[s.length() + 1][p.length() + 1];
        m[0][0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char c = p.charAt(j - 1);
                if (c == '*') {
                    m[i][j] = (i > 0 && m[i - 1][j] && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) ||
                            (j > 1 && m[i][j - 2]);
                } else {
                    m[i][j] = i > 0 && m[i - 1][j - 1] && (c == '.' || c == s.charAt(i - 1));
                }
            }
        }
        return m[s.length()][p.length()];
    }

    @Test
    public void test() {
        Assert.assertTrue(isMatch("abab", "ab*ba*b"));
        Assert.assertTrue(isMatch("aaa", "ab*ac*a"));
        Assert.assertTrue(isMatch("aaaaaaa", "a*b*"));
        Assert.assertTrue(isMatch("aa", "aa"));
        Assert.assertFalse(isMatch("aaa", "aa"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));
        Assert.assertTrue(isMatch("aa", ".*"));
        Assert.assertTrue(isMatch("aabccaa", "b*.*"));
        Assert.assertTrue(isMatch("aaa", "ab*a*c*a"));
        Assert.assertTrue(isMatch("aaaaaaaaaaaaab", "ab*a*a*a*a*a*a*a*a*a*a*a*a*a*b"));
    }
}
