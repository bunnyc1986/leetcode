import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        int maxLength = 0, j = 0, numUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer c = counter.get(ch);
            if (c == null || c == 0) {
                c = 1;
                numUnique++;
            } else {
                c++;
            }
            counter.put(ch, c);

            while (numUnique > 2) {
                int c1 = counter.get(s.charAt(j));
                if (c1 == 1) {
                    numUnique--;
                }
                counter.put(s.charAt(j), c1 - 1);
                j++;
            }
            maxLength = Math.max(i - j + 1, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("abaac"));
        System.out.println(solution.lengthOfLongestSubstringTwoDistinct("abcabcabc"));
    }
}
