import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class Solution {

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int lastDig = s.charAt(0) - '0';
        if (lastDig == 0) {
            return 0;
        }
        int previousCount = 1;
        int currentCount = 1;
        for (int i = 1; i < s.length(); i++) {
            int t = currentCount;
            int currentDig = s.charAt(i) - '0';
            int combined = lastDig * 10 + currentDig;
            if (combined == 0 || (currentDig == 0 && combined > 26)) {
                return 0;
            } else if (lastDig == 0 || combined > 26) {

            } else if (currentDig == 0) {
                currentCount = previousCount;
            } else {
                currentCount += previousCount;
            }

            lastDig = currentDig;
            previousCount = t;
        }

        return currentCount;
    }

    @Test
    public void test() {
        assertEquals(2, numDecodings("12"));
        assertEquals(3, numDecodings("122"));
        assertEquals(1, numDecodings("101101"));
        assertEquals(5, numDecodings("1212"));
        assertEquals(4, numDecodings("24726"));
    }
}
