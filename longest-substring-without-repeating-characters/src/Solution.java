import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxlength = 0;
        int start = 0;
        Map<Character, Integer> markers = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (markers.containsKey(s.charAt(i))) {
                start = Math.max(start, markers.get(s.charAt(i)) + 1);
            }
            markers.put(s.charAt(i), i);
            maxlength = Math.max(maxlength, i - start + 1);

        }
        return maxlength;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().lengthOfLongestSubstring("abcabcdb"));
        System.out.println(new Solution().lengthOfLongestSubstring("c"));
        //System.out.println(new Solution().lengthOfLongestSubstring("aa"));
    }
}