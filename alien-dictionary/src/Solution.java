import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/alien-dictionary/
 */
public class Solution {
    public String alienOrder(String[] words) {
        Set<Character> unOrdered = new HashSet<>();
        Map<Character, Set<Character>> adjacents = new HashMap<>();
        String prev = "";
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            for (; j < words[i].length(); j++) {
                if (j >= prev.length()) {
                    break;
                }
                if (prev.charAt(j) != words[i].charAt(j)) {
                    Set<Character> next = adjacents.get(prev.charAt(j));
                    if (next == null) {
                        next = new HashSet<>();
                        adjacents.put(prev.charAt(j), next);
                    }
                    next.add(words[i].charAt(j));
                    break;
                }
            }
            for (; j < words[i].length(); j++) {
                unOrdered.add(words[i].charAt(j));
            }
            prev = words[i];
        }

        Map<Character, Integer> inDegrees = new HashMap<>();
        for (char ch : adjacents.keySet()) {
            if (!inDegrees.containsKey(ch)) {
                inDegrees.put(ch, 0);
            }
            for (char nextCh : adjacents.get(ch)) {
                Integer counter = inDegrees.get(nextCh);
                inDegrees.put(nextCh, counter == null ? 1 : counter + 1);
            }
        }
        Queue<Character> order = new LinkedList<>();
        for (Character ch : inDegrees.keySet()) {
            if (inDegrees.get(ch) == 0) {
                order.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!order.isEmpty()) {
            char ch = order.poll();
            sb.append(ch);
            unOrdered.remove(ch);
            if (!adjacents.containsKey(ch)) {
                continue;
            }
            for (char nextCh : adjacents.get(ch)) {
                int inDegree = inDegrees.get(nextCh) - 1;
                inDegrees.put(nextCh, inDegree);
                if (inDegree == 0) {
                    order.add(nextCh);
                }
            }
        }

        for (char ch : inDegrees.keySet()) {
            if (inDegrees.get(ch) > 0) {
                // circle exists
                return "";
            }
        }

        for (char ch : unOrdered) {
            sb.append(ch);
        }
        return sb.toString().trim();
    }

    @Test
    public void test() {
        String alienOrder1 = alienOrder(new String[]{
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        });
        System.out.println(alienOrder1);
    }

    @Test
    public void test4() {
        String alienOrder4 = alienOrder(new String[]{
                "za",
                "zb",
                "ca",
                "cb"
        });
        System.out.println(alienOrder4);
    }

    @Test
    public void test3() {
        String alienOrder3 = alienOrder(new String[]{
                "ab",
                "adc"
        });
        System.out.println(alienOrder3);
    }

    @Test
    public void test2() {
        String alienOrder2 = alienOrder(new String[]{
                "z",
                "z"
        });
        System.out.println(alienOrder2);
    }

    @Test
    public void test5() {
        String alienOrder = alienOrder(new String[]{
                "ri", "xz", "qxf", "jhsguaw", "dztqrbwbm", "dhdqfb", "jdv", "fcgfsilnb", "ooby"
        });
        System.out.println(alienOrder);
    }

}
