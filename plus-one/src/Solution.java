import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> output = new ArrayList<Integer>();
        if (digits.length == 0) {
            return new int[]{1};
        }
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            output.add(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            output.add(carry);
        }
        int[] rtn = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            rtn[i] = output.get(output.size() - i - 1);
        }
        return rtn;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
    }
}
