/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Solution {
    static Map<Character, Character[]> mapping = new HashMap<>();

    static {
        mapping.put('1', new Character[] {});
        mapping.put('2', new Character[] {'a', 'b', 'c'});
        mapping.put('3', new Character[] {'d', 'e', 'f'});
        mapping.put('4', new Character[] {'g', 'h', 'i'});
        mapping.put('5', new Character[] {'j', 'k', 'l'});
        mapping.put('6', new Character[] {'m', 'n', 'o'});
        mapping.put('7', new Character[] {'p', 'q', 'r', 's'});
        mapping.put('8', new Character[] {'t', 'u', 'v'});
        mapping.put('9', new Character[] {'w', 'x', 'y', 'z'});
        mapping.put('0', new Character[] {' '});
        mapping.put('*', new Character[] {'+'});
        mapping.put('#', new Character[] {});
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1) {
            return new ArrayList<>();
        }
        List<String> output = new ArrayList<>();
        for(char c : mapping.get(digits.charAt(0))) {
            output.add("" + c);
        }

        for(int i = 1; i < digits.length(); i++) {
            List<String> newOutput = new ArrayList<>();
            for(String s : output) {
                for(char c : mapping.get(digits.charAt(i))) {
                    newOutput.add(s + c);
                }
            }
            output = newOutput;
        }

        return output;
    }

    @Test
    public void test() {
        String digits = "23";
        List<String> output = letterCombinations(digits);
        assertEquals(9, output.size());
        System.out.println(output); // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
