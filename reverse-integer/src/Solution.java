/**
 * https://leetcode.com/problems/reverse-integer/
 */
public class Solution {
    public int reverse(int x) {
        long rev = 0;
        while(x != 0) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if (Math.abs(rev) > Integer.MAX_VALUE) {
            return 0;
        }
        return (int)rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-321));
    }
}
