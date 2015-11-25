import org.junit.Test;

import java.util.*;

public class Solution {

    List<String> results;
    Set<Integer>[] pointer;

    public List<String> wordBreak(String s, Set<String> wordDict) {
        pointer = new HashSet[s.length()];
        for (int i = 0; i < s.length(); i++) {
            pointer[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (wordDict.contains(s.substring(j, i + 1))
                        && (j == 0 || pointer[j - 1].size() > 0))
                    pointer[i].add(j);
            }
        }
        results = new ArrayList<String>();
        searchResults(s, s.length() - 1, "");
        return results;
    }

    public void searchResults(String s, int i, String words) {
        if (i < 0) {
            results.add(words);
            return;
        }
        for (Integer bp : pointer[i]) {
            String word = s.substring(bp, i + 1);
            if (words.length() == 0) {
                searchResults(s, bp - 1, word);
            } else {
                searchResults(s, bp - 1, word + " " + words);
            }
        }
    }

    @Test
    public void test() {
        Set<String> dict = new HashSet<String>();
        Collections.addAll(dict, "cat", "cats", "and", "sand", "dog");
        List<String> words = wordBreak("catsanddog", dict);
        System.out.println(words);
    }
}
