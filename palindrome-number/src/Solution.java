/**
 * https://leetcode.com/problems/palindrome-number/
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while(x != 0) {
            int l = x / div;
            int r = x % 10;
            if (l != r) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(12321));
        System.out.println(solution.isPalindrome(123431));
    }
}
