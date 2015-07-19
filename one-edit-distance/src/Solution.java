/**
 * https://leetcode.com/problems/one-edit-distance/
 */
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        // Length diff > 1; it's impossible to be one edit
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        // length equal; only one char diff allowed
        if (s.length() == t.length()) {
            int diff = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i) && diff++ > 1) {
                    return false;
                }
            }
            if (diff == 1) {
                return true;
            }
        } else {
            // length diff == 1; only one missing is allowed
            String longer, shorter;
            if (s.length() > t.length()) {
                longer = s;
                shorter = t;
            } else {
                longer = t;
                shorter = s;
            }
            int i = 0, j = 0;
            for (; i < shorter.length(); i++) {
                if (shorter.charAt(i) != longer.charAt(j)) {
                    if (j - i > 0 ||
                            shorter.charAt(i) != longer.charAt(j += 1)) {
                        return false;
                    }
                }
                j++;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isOneEditDistance("aaa", "aab")); //true
        System.out.println(solution.isOneEditDistance("aa", "aab")); //true
        System.out.println(solution.isOneEditDistance("baa", "aa")); //true
        System.out.println(solution.isOneEditDistance("ab", "acd")); //false
        System.out.println(solution.isOneEditDistance("123", "4125")); //false
    }
}
