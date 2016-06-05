import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/add-binary/
 */
public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        char carry = '0';
        while (i <= a.length() && i <= b.length()) {
            char x = a.charAt(a.length() - i);
            char y = b.charAt(b.length() - i);
            AdderResult r = adder(x, y, carry);
            carry = r.carry;
            sb.append(r.sum);
            i++;
        }

        if (a.length() != b.length()) {
            String longer = a.length() > b.length() ? a : b;
            while (i <= longer.length()) {
                char x = longer.charAt(longer.length() - i);
                AdderResult r = adder(x, '0', carry);
                carry = r.carry;
                sb.append(r.sum);
                i++;
            }
        }

        if (carry == '1') {
            sb.append('1');
        }

        return sb.reverse().toString();
    }


    private AdderResult adder(char x, char y, char carry) {
        if (x == y) {
            if (x == '0') {
                return new AdderResult(carry, '0');
            } else {
                if (carry == '0') {
                    return new AdderResult('0', '1');
                } else {
                    return new AdderResult('1', '1');
                }
            }
        } else {
            if (carry == '0') {
                return new AdderResult('1', '0');
            } else {
                return new AdderResult('0', '1');
            }
        }
    }

    public class AdderResult {
        char sum;
        char carry;

        public AdderResult(char sum, char carry) {
            this.sum = sum;
            this.carry = carry;
        }
    }

    @Test
    public void test() {
        assertEquals("1000", addBinary("1", "111"));
    }

    @Test
    public void test_2() {
        assertEquals("", addBinary(
                "1010000010010",
                "110101"));
    }
}
