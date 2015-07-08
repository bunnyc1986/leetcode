/**
 * https://leetcode.com/problems/implement-strstr/
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            String sub = haystack.substring(i, i + needle.length());
            if (sub.equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        String haystack = "aaabacdsedsws";
        String needle = "ba";
        System.out.println(strStr.strStr(haystack, needle));

    }
}
