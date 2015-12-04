import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * https://leetcode.com/problems/insert-interval/
 */
public class Solution {

    //Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return String.format("[%d, %d]", start, end);
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        List<Interval> results = new ArrayList<>();
        if (intervals.isEmpty()) {
            results.add(newInterval);
            return results;
        }
        int i = 0;
        for(; i < intervals.size() && intervals.get(i).end < newInterval.start; i++) {
            results.add(intervals.get(i));
        }
        Interval merged = new Interval();
        merged.start = i == intervals.size() ? newInterval.start : Math.min(intervals.get(i).start, newInterval.start);
        merged.end = newInterval.end;
        for(; i < intervals.size() && intervals.get(i).start <= newInterval.end; i++) {
            merged.end = Math.max(intervals.get(i).end, newInterval.end);
        }
        results.add(merged);
        for(; i < intervals.size(); i++) {
            results.add(intervals.get(i));
        }
        return results;
    }


    @Test
    public void test1() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 3),
                new Interval(6, 9)
        );
        List<Interval> results = insert(intervals, new Interval(2, 5));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 5], [6, 9]", output);
        System.out.printf("Test 1: %s\n", output);
    }

    @Test
    public void test2() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 2),
                new Interval(3, 5),
                new Interval(6, 7),
                new Interval(8, 10),
                new Interval(12, 16)
        );
        List<Interval> results = insert(intervals, new Interval(4, 9));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 2], [3, 10], [12, 16]", output);
        System.out.printf("Test 2: %s\n", output);
    }

    @Test
    public void test3() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 2)
        );
        List<Interval> results = insert(intervals, new Interval(1, 9));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 9]", output);
        System.out.printf("Test 3: %s\n", output);
    }

    @Test
    public void test4() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5)
        );
        List<Interval> results = insert(intervals, new Interval(2, 3));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 5]", output);
        System.out.printf("Test 4: $s\n", output);
    }

    @Test
    public void test5() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5)
        );
        List<Interval> results = insert(intervals, new Interval(6, 8));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 5], [6, 8]", output);
        System.out.printf("Test 5: %s\n", output);
    }

    @Test
    public void test6() {
        List<Interval> intervals = Arrays.asList(
                new Interval(5, 10)
        );
        List<Interval> results = insert(intervals, new Interval(1, 4));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 4], [5, 10]", output);
        System.out.printf("Test 6: %s\n", output);
    }

    @Test
    public void test7() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5)
        );
        List<Interval> results = insert(intervals, new Interval(5, 7));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 7]", output);
        System.out.printf("Test 7: %s\n", output);
    }

    @Test
    public void test8() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5)
        );
        List<Interval> results = insert(intervals, new Interval(0, 1));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[0, 5]", output);
        System.out.printf("Test 8: %s\n", output);
    }

    @Test
    public void test9() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5),
                new Interval(10, 15)
        );
        List<Interval> results = insert(intervals, new Interval(7, 8));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[1, 5], [7, 8], [10, 15]", output);
        System.out.printf("Test 9: %s\n", output);
    }

    @Test
    public void test10() {
        List<Interval> intervals = Arrays.asList(
                new Interval(1, 5)
        );
        List<Interval> results = insert(intervals, new Interval(0, 0));
        String output = results.stream()
                .map(Interval::toString)
                .collect(Collectors.joining(", "));
        assertEquals("[0, 0], [1, 5]", output);
        System.out.printf("Test 10: %s\n", output);
    }
}
