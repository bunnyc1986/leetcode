import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (map.containsKey(target - a)) {
                int index1 = i + 1;
                int index2 = map.get(target - a) + 1;
                if (index1 < index2) {
                    return new int[]{index1, index2};
                } else {
                    return new int[]{index2, index1};
                }
            }
            map.put(a, i);
        }
        return null;
    }

    public int[] twoSum2(int[] sortedNums, int target) {
        int i = 0, j = sortedNums.length - 1;
        while (i < j) {
            int sum = sortedNums[i] + sortedNums[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return new int[]{i, j};
            }

        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[]{1, 3, 5, 7, 8, 9, 10, 12, 14, 18};
        int target = 20;

        int[] results = twoSum.twoSum(nums, target);
        System.out.println(String.format("%d, %d", results[0], results[1]));

        results = twoSum.twoSum2(nums, target);
        System.out.println(String.format("%d, %d", results[0], results[1]));
    }
}
