import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class Solution {

    public int firstBadVersion(int n) {
        if (n < 1) {
            return 0;
        }
        return firstBadVersion(1, n);
    }

    int firstBadVersion(int start, int end) {
        if (start == end) {
            return isBadVersion(start) ? start : -1;
        } else if (end - start == 1) {
            if (isBadVersion(start)) {
                return start;
            } else if (isBadVersion(end)) {
                return end;
            } else {
                return -1;
            }
        } else {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                return firstBadVersion(start, mid);
            } else {
                return firstBadVersion(mid, end);
            }
        }
    }

    // For test
    boolean isBadVersion(int version) {
        return version >= 10;
    }

    @Test
    public void test() {
        int badVersion = firstBadVersion(13);
        assertEquals(10, badVersion);
    }
}
