/**
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) ) {
                i++;
                if (i > s.length() - 1) {
                    return true;
                }
            }
            while (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                if (j < i) {
                    return true;
                }
            }
            if (Character.toLowerCase(s.charAt(i++)) !=
                    Character.toLowerCase(s.charAt(j--))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String test1 = "\"Sue,\" Tom smiles, \"Selim smote us.\"";
        System.out.println(validPalindrome.isPalindrome(test1));
        String test2 = ".,";
        System.out.println(validPalindrome.isPalindrome(test2));
        String test3 = "1a2";
        System.out.println(validPalindrome.isPalindrome(test3));
    }
}
