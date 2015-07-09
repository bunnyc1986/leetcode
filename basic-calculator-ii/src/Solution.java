import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator-ii/
 */
public class Solution {
    static final char ZERO = '0';

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - ZERO;
            }
            if (!Character.isDigit(s.charAt(i)) && !Character.isSpaceChar(s.charAt(i))
                    || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(0 - num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int sum = 0;
        for (int e : stack) {
            sum += e;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("3+2*2"));
        System.out.println(new Solution().calculate(" 3/2 "));
        System.out.println(new Solution().calculate(" 3+5 / 2 "));
        System.out.println(new Solution().calculate("42"));
    }
}
