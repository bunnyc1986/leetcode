import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/missing-ranges/
 */
public class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> missingRanges = new ArrayList<String>();
        if (nums.length == 0) {
            addValidRange(missingRanges, lower, upper);
            return missingRanges;
        }
        int missingLower = lower;
        int missingUpper = nums[0] - 1;
        addValidRange(missingRanges, missingLower, missingUpper);
        for (int i = 0; i < nums.length - 1; i++) {
            missingLower = nums[i] + 1;
            missingUpper = nums[i + 1] - 1;
            addValidRange(missingRanges, missingLower, missingUpper);
        }
        addValidRange(missingRanges, nums[nums.length - 1] + 1, upper);
        return missingRanges;
    }

    private void addValidRange(List<String> missingRanges, int rangeStart, int rangeEnd) {
        if (rangeStart == rangeEnd) {
            missingRanges.add(Integer.toString(rangeStart));
        } else if (rangeStart < rangeEnd) {
            missingRanges.add(String.format("%d->%d", rangeStart, rangeEnd));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99));
        System.out.println(solution.findMissingRanges(new int[]{}, 0, 99));
    }
}
