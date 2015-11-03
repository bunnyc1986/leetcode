import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class Solution {

    public int countDigitOne(int n) {
        int count = 0, lowc = 1, lown = 0;
        while(n > 0) {
            int c = n % 10;
            n /= 10;
            if (c == 1) {
                count += n * lowc + lown + 1;
            }
            else if (c == 0) {
                count += n * lowc;
            }
            else {
                count += (n + 1) * lowc;
            }
            lown = c * lowc + lown;
            lowc = lowc * 10;
        }
        return count;
    }


    @Test
    public void test() {
        assertEquals(23, countDigitOne(101));
    }
}
