/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class Solution {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > longest.length()) {
                longest = s.substring(i - (len - 1) / 2, i + len / 2 + 1);
            }
        }
        return longest;
    }

    private int expand(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abacdfgdcaba"));
    }
}
