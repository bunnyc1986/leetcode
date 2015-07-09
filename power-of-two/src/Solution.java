/**
 * https://leetcode.com/problems/power-of-two/
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(2));
        System.out.println(new Solution().isPowerOfTwo(10));
    }
}
